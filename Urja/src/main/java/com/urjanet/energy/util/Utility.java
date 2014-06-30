package com.urjanet.energy.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.annotation.PostConstruct;

import org.apache.commons.io.IOUtils;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.DeflateDecompressingEntity;
import org.apache.http.client.entity.GzipCompressingEntity;
import org.apache.http.client.entity.GzipDecompressingEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HttpContext;
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
//	@Qualifier("getGson")
	private Gson thisGson;
	@Autowired
	private CloseableHttpClient theHclient;

	@PostConstruct
	public void init() {
		gson = thisGson;
		hclient = theHclient;
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
	public static String decompressHttp(String uri) {
		String text = null;
		HttpGet rateGet = new HttpGet(uri);
		rateGet.addHeader("Accept-Encoding", "deflate");
		rateGet.setHeader("Content-Type", "application/zip");
		rateGet.addHeader("Content-Type", "application/zip");
//		rateGet.setHeader("Content-Encoding", "gzip, deflate");
		try {

	
			
			CloseableHttpResponse rateResponse = hclient.execute(rateGet);
			for (Header h:rateResponse.getAllHeaders()){
				System.out.println("headers h:"+h.getName()+" val:"+h.getValue());
			}
//			HttpEntity rateEntity = new GzipCompressingEntity(rateResponse.getEntity());
//			rateResponse.setEntity(new DeflateDecompressingEntity(rateResponse.getEntity()));
			HttpEntity rateEntity = rateResponse.getEntity();


			OutputStream outputStream = new FileOutputStream("/home/ac2211/Urja/energy/bulk/seds.txt");
			
			IOUtils.copy(rateEntity.getContent(), outputStream);
			outputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return text;
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