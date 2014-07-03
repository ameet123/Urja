package com.urjanet.energy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Splitter;
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
		Utility.downloadHttpFile(Constants.COAL_HTTP, Constants.BULK_DATA);
		Utility.unzipFile(Constants.BULK_DATA+"COAL.zip", Constants.BULK_DATA);
		Utility.downloadHttpFile(Constants.AEO_HTTP, Constants.BULK_DATA);
		Utility.unzipFile(Constants.BULK_DATA+"AEO.zip", Constants.BULK_DATA);
		Utility.downloadHttpFile(Constants.PET_HTTP, Constants.BULK_DATA);
		Utility.unzipFile(Constants.BULK_DATA+"PET.zip", Constants.BULK_DATA);
		Utility.downloadHttpFile(Constants.NG_HTTP, Constants.BULK_DATA);
		Utility.unzipFile(Constants.BULK_DATA+"NG.zip", Constants.BULK_DATA);
		Utility.downloadHttpFile(Constants.SEDS_HTTP, Constants.BULK_DATA);
		Utility.unzipFile(Constants.BULK_DATA+"SEDS.zip", Constants.BULK_DATA);
		return 1;
	}
//	@Bean
	public int processSeds() throws IOException {
		int count = 0;
		try(Stream<String> ls = Files.lines(Paths.get(Constants.BULK_DATA+Constants.SEDS_FILE))){
			count = ls.map(p->persistSedsSeries(p)).reduce(Integer::sum).get();			
		}
		System.out.println("SEDS Processed:"+count);
		return count;
	}
	@Bean
	public int processAeo(){
		int count = 0;
		try(Stream<String> ls = Files.lines(Paths.get(Constants.BULK_DATA+Constants.AEO_FILE))){
			count = ls.map(p->persistAeoSeries(p)).reduce(Integer::sum).get();			
		} catch (IOException e) {
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
			fillLevels(ss);
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
	/**
	 * construct multiple levels/categories out of name
	 * @param as
	 */
	private void fillLevels(AeoSeries as){
		// make levels out of name
		Iterator<String> it = Splitter.on(':').split(as.getName()).iterator();
		int i = 0;
		while (it.hasNext()){
			i++;
			switch (i) {
			case 1:
				as.setLevel1(it.next());
				break;
			case 2:
				as.setLevel2(it.next());
				break;
			case 3:
				as.setLevel3(it.next());
				break;
			case 4: 
				as.setLevel4(it.next());
				break;
			case 5:
				as.setLevel5(it.next());
				break;
			default:
				break;
			}
		}		
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