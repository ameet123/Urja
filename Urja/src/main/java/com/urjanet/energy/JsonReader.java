package com.urjanet.energy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map.Entry;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.gson.Gson;
import com.urjanet.energy.entity.SedsSeries;
import com.urjanet.energy.entity.Series;
import com.urjanet.energy.entity.UtilityCompanies;
import com.urjanet.energy.entity.UtilityRates;
import com.urjanet.energy.json.BulkManifest;
import com.urjanet.energy.json.UtilityCompaniesJson;
import com.urjanet.energy.json.UtilityRatesJson;
import com.urjanet.energy.service.SeriesService;
import com.urjanet.energy.service.UtilityCompaniesService;
import com.urjanet.energy.service.UtilityRatesService;
import com.urjanet.energy.util.ApiConstants;
import com.urjanet.energy.util.Utility;

/**
 * Contains beans to fetch JSON data for various tables
 * 
 * @author ac2211
 *
 */
@Configuration
public class JsonReader {
	@Autowired
	private UtilityRatesService utilityRateSvc;
	@Autowired
	private UtilityCompaniesService utilityCompSvc;
	@Autowired
	private SeriesService seriesSvs;
	@Autowired
	private Gson gson;

	@Value("${fetch}")
	private char fetchMechanism;

	@Bean
	public int uncomp() throws IOException {
		String source = "/home/ac2211/Urja/energy/bulk/SEDS.zip";
		String destination = "/home/ac2211/Urja/energy/bulk/";
//		final int BUFFER = 2048;
//
//		try {
//			BufferedOutputStream dest = null;
//			FileInputStream fis = new FileInputStream(source);
//			ZipInputStream zis = new ZipInputStream(new BufferedInputStream(fis));
//			ZipEntry entry;
//			while ((entry = zis.getNextEntry()) != null) {
//				System.out.println("Extracting: " + entry.getName());
//				int count;
//				byte data[] = new byte[BUFFER];
//				// write the files to the disk
//				FileOutputStream fos = new FileOutputStream(destination+entry.getName());
//				dest = new BufferedOutputStream(fos, BUFFER);
//				while ((count = zis.read(data, 0, BUFFER)) != -1) {
//					dest.write(data, 0, count);
//				}
//				dest.flush();
//				dest.close();
//			}
//			zis.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		try(Stream<String> ls = Files.lines(Paths.get(destination+"small.txt"))){
			System.out.println("in stream");
			ls.forEach(p->readSeries(p));
			
		}
		return 1;

	}
	private int readSeries(String text){		
		SedsSeries ss1 = Utility.fromJson(text, SedsSeries.class);
		ss1.fillSedsData();
		System.out.println(" series:"+ss1.getName()+" Random data: year="+ss1.getSedData().iterator().next().getYear()+ " data="+ss1.getSedData().iterator().next().getData());

		return 1;
	}

	// @Bean
	public int getSeds() {
		Utility.decompressHttp("http://api.eia.gov/bulk/SEDS.zip");
		return 1;
	}

	// @Bean
	public int processEiaManifest() {
		String manifest = "/home/ac2211/Urja/energy/manifest.json";
		String text = Utility.fetchFromFile(manifest);
		System.out.println("First few lines:" + text.substring(0, 200));
		BulkManifest bm = Utility.fromJson(text, BulkManifest.class);
		System.out.println(bm.getDataset().size());
		for (Entry<String, Series> e : bm.getDataset().entrySet()) {
			System.out.println("key=>" + e.getKey() + " val=>"
					+ e.getValue().getIdentifier());
			Series sr = e.getValue();
			seriesSvs.save(sr);
			System.out.println("AccessURL:" + sr.getAccessURL());
		}
		return 1;
	}

	/**
	 * JSON for Utility Rates table
	 */
	// @Bean
	public int processUtilityRates() {
		String text = null;
		if (fetchMechanism == 'f') {
			text = Utility.fetchFromFile(ApiConstants.UTIL_RATE_JSON_FILE);
		} else if (fetchMechanism == 'h') {
			text = Utility.fetchHttp(ApiConstants.UTIL_RATE_JSON_API);
		}

		UtilityRatesJson ur = Utility.fromJson(text, UtilityRatesJson.class);
		System.out.println("Total rec:" + ur.getItems().length);

		int i = 0;
		for (UtilityRates rate : ur.getItems()) {
			this.utilityRateSvc.save(rate);
			if (++i % 100 == 0) {
				System.out.println("Saved row:" + i);
			}
		}
		return i;
	}

	// @Bean
	public int processUtilityCompanies() {
		String text = null;
		if (fetchMechanism == 'f') {
			text = Utility.fetchFromFile(ApiConstants.UTIL_COMP_JSON_FILE);
		} else if (fetchMechanism == 'h') {
			text = Utility.fetchHttp(ApiConstants.UTIL_COMP_JSON_API);
		}
		UtilityCompaniesJson ur = Utility.fromJson(text,
				UtilityCompaniesJson.class);
		System.out.println("Total rec:" + ur.getItems().length);

		int i = 0;
		for (UtilityCompanies comp : ur.getItems()) {
			this.utilityCompSvc.save(comp);
			if (++i % 100 == 0) {
				System.out.println("Saved row:" + i);
			}
		}
		return i;
	}
}