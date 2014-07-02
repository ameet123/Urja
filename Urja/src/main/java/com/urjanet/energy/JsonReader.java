package com.urjanet.energy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map.Entry;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.gson.Gson;
import com.urjanet.energy.entity.AeoCategory;
import com.urjanet.energy.entity.AeoSeries;
import com.urjanet.energy.entity.Category;
import com.urjanet.energy.entity.SedsSeries;
import com.urjanet.energy.entity.Series;
import com.urjanet.energy.entity.UtilityCompanies;
import com.urjanet.energy.entity.UtilityRates;
import com.urjanet.energy.json.BulkManifest;
import com.urjanet.energy.json.UtilityCompaniesJson;
import com.urjanet.energy.json.UtilityRatesJson;
import com.urjanet.energy.service.AeoCategoryService;
import com.urjanet.energy.service.AeoSeriesService;
import com.urjanet.energy.service.CategoryService;
import com.urjanet.energy.service.SedsSeriesService;
import com.urjanet.energy.service.SeriesService;
import com.urjanet.energy.service.UtilityCompaniesService;
import com.urjanet.energy.service.UtilityRatesService;
import com.urjanet.energy.util.ApiConstants;
import com.urjanet.energy.util.Constants;
import com.urjanet.energy.util.Utility;

/**
 * Contains beans to fetch JSON data for various tables
 * 
 * @author ac2211
 *
 */
@Configuration
public class JsonReader {
	private static Logger LOGGER = LoggerFactory.getLogger(JsonReader.class);
	
	@Autowired
	private UtilityRatesService utilityRateSvc;
	@Autowired
	private UtilityCompaniesService utilityCompSvc;
	@Autowired
	private SeriesService seriesSvs;
	@Autowired
	private SedsSeriesService sedsSeriesSvc;
	@Autowired
	private CategoryService categorySvc;
	@Autowired
	private AeoSeriesService aeoSeriesSvc;
	@Autowired
	private AeoCategoryService aeoCategorySvc;
	
	@Autowired
	private Gson gson;

	@Value("${fetch}")
	private char fetchMechanism;

//	@Bean
	public int downloadBulk(){
		String coal =  "http://api.eia.gov/bulk/COAL.zip";
		String aeo = "http://api.eia.gov/bulk/AEO.zip";
		String pet = "http://api.eia.gov/bulk/PET.zip";
		String ng = "http://api.eia.gov/bulk/NG.zip";
		String destination = "/home/ac2211/Urja/energy/bulk/";
		
//		Utility.downloadHttpFile(coal, destination);
//		Utility.unzipFile(destination+"COAL.zip", destination);
//		Utility.downloadHttpFile(aeo, destination);
//		Utility.unzipFile(destination+"AEO.zip", destination);
//		Utility.downloadHttpFile(pet, destination);
//		Utility.unzipFile(destination+"PET.zip", destination);
		Utility.downloadHttpFile(ng, destination);
		Utility.unzipFile(destination+"NG.zip", destination);
		return 1;
	}
//	@Bean
	public int uncomp() throws IOException {
		String source = "/home/ac2211/Urja/energy/bulk/SEDS.zip";
		String destination = "/home/ac2211/Urja/energy/bulk/";
//		Utility.unzipFile(source, destination);
		try(Stream<String> ls = Files.lines(Paths.get(destination+"SEDS.txt"))){
			ls.forEach(p->persistSedsSeries(p));			
		}
		return 1;
	}
	@Bean
	public int processAeo(){
		int count = 0;
		try(Stream<String> ls = Files.lines(Paths.get(Constants.BULK_DATA+Constants.AEO_FILE))){
			count = ls.map(p->persistAeoSeries(p)).reduce(Integer::sum).get();			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("AEO Processed:"+count);
		return count;
	}
	private int persistSedsSeries(String text){	
		// find out series or category		
		if (Utility.isSeries(text)) {		
			SedsSeries ss1 = Utility.fromJson(text, SedsSeries.class);
			ss1.fillSedsData();
			LOGGER.debug(
					" series:"+ss1.getName()+
					" Random data: year="+ss1.getSedData().iterator().next().getYear()+
					" data="+ss1.getSedData().iterator().next().getData());
			sedsSeriesSvc.save(ss1);
		} else if (Utility.isCategory(text)){
			Category cat = Utility.fromJson(text, Category.class);
			LOGGER.debug(" Category:"+cat.getName());
			categorySvc.save(cat);
		}
		return 1;
	}
	private int persistAeoSeries(String text){	
		// find out series or category		
		if (Utility.isSeries(text)) {		
			AeoSeries ss = Utility.fromJson(text, AeoSeries.class);
			ss.fillChildData();
			LOGGER.debug(
					" series:"+ss.getName()+
					" Random data: year="+ss.getChildData().iterator().next().getYear()+
					" data="+ss.getChildData().iterator().next().getData());
			aeoSeriesSvc.save(ss);
		} else if (Utility.isCategory(text)){
			AeoCategory cat = Utility.fromJson(text, AeoCategory.class);
			LOGGER.debug(" AEO Category:"+cat.getName());
			aeoCategorySvc.save(cat);
		}
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