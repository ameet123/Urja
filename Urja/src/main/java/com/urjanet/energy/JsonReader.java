package com.urjanet.energy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map.Entry;
import java.util.stream.Stream;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.gson.Gson;
import com.urjanet.energy.entity.AEOCategory;
import com.urjanet.energy.entity.AEOSeries;
import com.urjanet.energy.entity.CoalCategory;
import com.urjanet.energy.entity.CoalSeries;
import com.urjanet.energy.entity.GenericSeries;
import com.urjanet.energy.entity.NgCategory;
import com.urjanet.energy.entity.NgSeries;
import com.urjanet.energy.entity.PetCategory;
import com.urjanet.energy.entity.PetSeries;
import com.urjanet.energy.entity.SedCategory;
import com.urjanet.energy.entity.SedSeries;
import com.urjanet.energy.entity.Series;
import com.urjanet.energy.entity.UtilityCompanies;
import com.urjanet.energy.entity.UtilityRates;
import com.urjanet.energy.json.BulkManifest;
import com.urjanet.energy.json.UtilityCompaniesJson;
import com.urjanet.energy.json.UtilityRatesJson;
import com.urjanet.energy.service.AEOCategoryService;
import com.urjanet.energy.service.AEOService;
import com.urjanet.energy.service.CoalCategoryService;
import com.urjanet.energy.service.CoalService;
import com.urjanet.energy.service.GenericCategoryService;
import com.urjanet.energy.service.GenericService;
import com.urjanet.energy.service.NgCategoryService;
import com.urjanet.energy.service.NgService;
import com.urjanet.energy.service.PetCategoryService;
import com.urjanet.energy.service.PetService;
import com.urjanet.energy.service.SedCategoryService;
import com.urjanet.energy.service.SedService;
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
	private CoalService coalSeriesSvc;
	@Autowired
	private CoalCategoryService coalCategorySvc;
	@Autowired
	private NgService ngSeriesSvc;
	@Autowired
	private NgCategoryService ngCategorySvc;
	@Autowired
	private PetService petSeriesSvc;
	@Autowired
	private PetCategoryService petCategorySvc;
	@Autowired
	private SedService sedSeriesSvc;
	@Autowired
	private SedCategoryService sedCategorySvc;
	@Autowired
	private AEOService aeoSeriesSvc;
	@Autowired
	private AEOCategoryService aeoCategorySvc;

	@Autowired
	private Gson gson;

	@Value("${seds:n}")
	private char seds;
	@Value("${aeo:n}")
	private char aeo;
	@Value("${pet:n}")
	private char pet;
	@Value("${ng:n}")
	private char ng;
	@Value("${coal:n}")
	private char coal;
	@Value("${manifest:n}")
	private char manifest;
	@Value("${utilRates:f}")
	private char utilRates;
	@Value("${utilCompanies:f}")
	private char utilCompanies;

	@Bean
	@ConditionalOnProperty("seds")
	public int processSEDS() {
		return processSeriesAndCategory(Constants.BULK_DATA
				+ Constants.SEDS_FILE, SedSeries.class, sedSeriesSvc,
				SedCategory.class, sedCategorySvc, seds, Constants.SEDS_HTTP);
	}

	@Bean
	@ConditionalOnProperty("aeo")
	public int processAEO() {
		return processSeriesAndCategory(Constants.BULK_DATA
				+ Constants.AEO_FILE, AEOSeries.class, aeoSeriesSvc,
				AEOCategory.class, aeoCategorySvc, aeo, Constants.AEO_HTTP);
	}

	@Bean
	@ConditionalOnProperty("ng")
	public int processNG() {
		return processSeriesAndCategory(
				Constants.BULK_DATA + Constants.NG_FILE, NgSeries.class,
				ngSeriesSvc, NgCategory.class, ngCategorySvc, ng,
				Constants.NG_HTTP);
	}

	@Bean
	@ConditionalOnProperty("pet")
	public int processPET() {
		return processSeriesAndCategory(Constants.BULK_DATA
				+ Constants.PET_FILE, PetSeries.class, petSeriesSvc,
				PetCategory.class, petCategorySvc, pet, Constants.PET_HTTP);
	}

	@Bean
	@ConditionalOnProperty("coal")
	public int processCOAL() {
		return processSeriesAndCategory(Constants.BULK_DATA
				+ Constants.COAL_FILE, CoalSeries.class, coalSeriesSvc,
				CoalCategory.class, coalCategorySvc, coal, Constants.COAL_HTTP);
	}

	public <T extends GenericSeries, J> int processSeriesAndCategory(
			String file, Class<? extends GenericSeries> T,
			GenericService<T> gsvc, Class<?> J,
			GenericCategoryService<J> gCatSvc, char signal, String uri) {
		int i = 0;
		// ascertain the decompression process requirement
		System.out.println("Processing " + T.getSimpleName() + " ...");
		if (signal == 'h') {
			Utility.downloadHttpFile(uri, Constants.BULK_DATA);
			Utility.unzipFile(Constants.BULK_DATA + FilenameUtils.getName(uri),
					Constants.BULK_DATA);
			LOGGER.debug("completed " + FilenameUtils.getName(uri)
					+ " download");
		}

		try (Stream<String> ls = Files.lines(Paths.get(file))) {
			i = ls.map(p -> persistGenericSeries(p, T, gsvc, J, gCatSvc))
					.reduce(Integer::sum).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(T.getSimpleName() + " Processed:" + i);
		return i;
	}

	private <T extends GenericSeries, J> int persistGenericSeries(String text,
			Class<? extends GenericSeries> T, GenericService<T> gsvc,
			Class<?> J, GenericCategoryService<J> gCatSvc) {
		// find out series or category
		if (Utility.isSeries(text)) {
			@SuppressWarnings("unchecked")
			T ss = (T) Utility.fromJson(text, T);
			ss.fillChildData();
			ss.fillLevels();
			LOGGER.debug(" series:" + ss.getName() + " Random data: year="
					+ ss.getChildData().iterator().next().getPeriod()
					+ " data=" + ss.getChildData().iterator().next().getData());
			gsvc.save(ss);
		} else if (Utility.isCategory(text)) {
			@SuppressWarnings("unchecked")
			J cat = (J) Utility.fromJson(text, J);
			gCatSvc.save(cat);
		}
		return 1;
	}

	/**
	 * gets the manifest for all the zip files String manifest =
	 * "/home/ac2211/Urja/energy/manifest.json"; String text =
	 * Utility.fetchFromFile(manifest);
	 * 
	 * @return
	 */
	@Bean
	@ConditionalOnProperty("manifest")
	public int processEiaManifest() {
		String text;
		int i = 0;
		text = Utility.fetchHttp(Constants.MANIFEST_HTTP);
		LOGGER.debug("First few lines:" + text.substring(0, 200));

		BulkManifest bm = Utility.fromJson(text, BulkManifest.class);
		System.out.println(bm.getDataset().size());
		for (Entry<String, Series> e : bm.getDataset().entrySet()) {
			LOGGER.debug("key=>" + e.getKey() + " val=>"
					+ e.getValue().getIdentifier());
			Series sr = e.getValue();
			seriesSvs.save(sr);
			i++;
			System.out.println("AccessURL:" + sr.getAccessURL());
		}

		System.out.println("Total files in manifest:" + i);
		return i;
	}

	/**
	 * JSON for Utility Rates table if (fetchMechanism == 'f') { text =
	 * Utility.fetchFromFile(ApiConstants.UTIL_RATE_JSON_FILE); }
	 */
	@Bean
	@ConditionalOnProperty("utilRates")
	public int processUtilityRates() {
		System.out.println("Processing util rates...");

		String text = null;
		int i = 0;

		if (utilRates == 'f'){
			text = Utility.fetchFromFile(ApiConstants.UTIL_RATE_JSON_FILE);
		} else if (utilRates == 'h'){
			text = Utility.fetchHttp(ApiConstants.UTIL_RATE_JSON_API);
		}
		

		UtilityRatesJson ur = Utility.fromJson(text, UtilityRatesJson.class);
		System.out.println("Total rec:" + ur.getItems().length);

		for (UtilityRates rate : ur.getItems()) {
			this.utilityRateSvc.save(rate);
			if (++i % 100 == 0) {
				System.out.println("Saved row:" + i);
			}
		}
		return i;
	}

	/**
	 * if (fetchMechanism == 'f') { text =
	 * Utility.fetchFromFile(ApiConstants.UTIL_COMP_JSON_FILE);
	 * 
	 * @return number of records processed
	 */
	@Bean
	@ConditionalOnProperty("utilCompanies")
	public int processUtilityCompanies() {
		String text = null;
		int i = 0;
		
		if (utilCompanies == 'f'){
			text = Utility.fetchFromFile(ApiConstants.UTIL_COMP_JSON_FILE);
		} else if (utilCompanies == 'h'){
			text = Utility.fetchHttp(ApiConstants.UTIL_COMP_JSON_API);
		}
		UtilityCompaniesJson ur = Utility.fromJson(text,
				UtilityCompaniesJson.class);
		System.out.println("Total rec:" + ur.getItems().length);

		for (UtilityCompanies comp : ur.getItems()) {
			this.utilityCompSvc.save(comp);
			if (++i % 100 == 0) {
				System.out.println("Saved row:" + i);
			}
		}
		return i;
	}
}