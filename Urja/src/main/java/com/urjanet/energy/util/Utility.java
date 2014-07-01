package com.urjanet.energy.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.annotation.PostConstruct;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.io.CharStreams;
import com.google.gson.Gson;

/**
 * combination of Component and PostConstruct allow us to wire a bean in static
 * context.
 * 
 * @author ac2211
 *
 */
@Component
public class Utility {

	private static final Logger LOGGER = LoggerFactory.getLogger(Utility.class);
	private static Gson gson;
	private static CloseableHttpClient hclient;

	@Autowired
	private Gson thisGson;
	@Autowired
	private CloseableHttpClient theHclient;

	@PostConstruct
	public void init() {
		gson = thisGson;
		hclient = theHclient;
	}
	/**
	 * unzip all the files in the archive created using PKZIP
	 * this is akin to tar so it could have multiple files
	 * once we get the files in the archive, then we can run
	 * decompress on each in a loop.
	 * @param source
	 * @param destination
	 */
	public static void unzipFile(String source, String destination){
		final int BUFFER = 2048;
		//
		try {
			BufferedOutputStream dest = null;
			FileInputStream fis = new FileInputStream(source);
			ZipInputStream zis = new ZipInputStream(
					new BufferedInputStream(fis));
			ZipEntry entry;
			while ((entry = zis.getNextEntry()) != null) {
				System.out.println("Extracting: " + entry.getName());
				int count;
				byte data[] = new byte[BUFFER];
				// write the files to the disk
				FileOutputStream fos = new FileOutputStream(destination
						+ entry.getName());
				dest = new BufferedOutputStream(fos, BUFFER);
				while ((count = zis.read(data, 0, BUFFER)) != -1) {
					dest.write(data, 0, count);
				}
				dest.flush();
				dest.close();
			}
			zis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * fetch JSON data from already existing file
	 * @param file
	 * @return JSON string
	 */
	public static String fetchFromFile(String file) {
		try {
			return new String(Files.readAllBytes(Paths.get(file)));
		} catch (IOException e) {
			return "";
		}
	}

	/**
	 * fetch an HTTP page based on uri
	 * 
	 * @param uri
	 * @return String
	 */
	public static String fetchHttp(String uri) {
		String text = null;
		HttpGet rateGet = new HttpGet(uri);
		try {
			CloseableHttpResponse rateResponse = hclient.execute(rateGet);
			HttpEntity rateEntity = rateResponse.getEntity();
			try (final Reader reader = new InputStreamReader(
					rateEntity.getContent())) {
				text = CharStreams.toString(reader);
			}
			LOGGER.debug("First few lines:{}", text.substring(0, 100));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return text;
	}
	/**
	 * download and save over http file
	 * @param uri
	 */
	public static void downloadHttpFile(String uri, String destination) {
		// find the file name from URI
		String file = FilenameUtils.getName(uri);
		HttpGet rateGet = new HttpGet(uri);
		rateGet.addHeader("Accept-Encoding", "deflate");
		try {
			CloseableHttpResponse rateResponse = hclient.execute(rateGet);
			HttpEntity rateEntity = rateResponse.getEntity();
			OutputStream outputStream = new FileOutputStream(destination+file);	
			IOUtils.copy(rateEntity.getContent(), outputStream);
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static boolean isCategory(String text){
		return isFound(text, Constants.CATEGORY_PATTERN);
	}
	public static boolean isSeries(String text){
		return isFound(text, Constants.SERIES_PATTERN);
	}
	/**
	 * generic pattern matcher
	 * @param text
	 * @param PATTERN
	 * @return boolean
	 */
	public static boolean isFound(String text, final String PATTERN){
		Pattern pattern = Pattern.compile(PATTERN);
		Matcher match = pattern.matcher(text);
		if (match.find()){		
			return true;
		} else {
			return false;
		}			
	}
	/**
	 * convert a json string to appropriate object
	 * 
	 * @param json
	 * @param clazz
	 * @return JSON String converted to class
	 */
	public static <T> T fromJson(String json, Class<T> clazz) {
		return gson.fromJson(json, clazz);
	}
}