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
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.gson.Gson;
import com.urjanet.energy.entity.AeoCategory;
import com.urjanet.energy.entity.AeoSeries;
import com.urjanet.energy.entity.Category;
import com.urjanet.energy.entity.CoalCategory;
import com.urjanet.energy.entity.CoalSeries;
import com.urjanet.energy.entity.GenericSeries;
import com.urjanet.energy.entity.NgCategory;
import com.urjanet.energy.entity.NgSeries;
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
import com.urjanet.energy.service.CoalCategoryService;
import com.urjanet.energy.service.CoalService;
import com.urjanet.energy.service.GenericCategoryService;
import com.urjanet.energy.service.GenericService;
import com.urjanet.energy.service.NgCategoryService;
import com.urjanet.energy.service.NgService;
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
	private CoalService coalSeriesSvc;
	@Autowired
	private CoalCategoryService coalCategorySvc;
	@Autowired
	private NgService ngSeriesSvc;
	@Autowired
	private NgCategoryService ngCategorySvc;

	@Autowired
	private Gson gson;

	@Value("${fetch}")
	private char fetchMechanism;
	@Value("${seds:n}")
	private char seds;
	@Value("${aeo:n}")
	private char aeo;

	@Bean
	@ConditionalOnProperty("seds")
	public int processSeds() throws IOException {
		int count = 0;

		System.out.println("Processing seds bean...");
		if (seds == 'h') {
			Utility.downloadHttpFile(Constants.SEDS_HTTP, Constants.BULK_DATA);
			Utility.unzipFile(Constants.BULK_DATA + Constants.SEDS_ZIP,
					Constants.BULK_DATA);
			LOGGER.debug("completed seds download");
		}

		try (Stream<String> ls = Files.lines(Paths.get(Constants.BULK_DATA
				+ Constants.SEDS_FILE))) {
			count = ls.map(p -> persistSedsSeries(p)).reduce(Integer::sum)
					.get();
		}
		System.out.println("SEDS Processed:" + count);

		return count;
	}

	@Bean
	@ConditionalOnProperty("aeo")
	public int processAeo() {
		int count = 0;

		System.out.println("Processing AEO ...");
		if (aeo == 'h') {
			Utility.downloadHttpFile(Constants.AEO_HTTP, Constants.BULK_DATA);
			Utility.unzipFile(Constants.BULK_DATA + Constants.AEO_ZIP,
					Constants.BULK_DATA);
			LOGGER.debug("completed aeo download");
		}
		try (Stream<String> ls = Files.lines(Paths.get(Constants.BULK_DATA
				+ Constants.AEO_FILE))) {
			count = ls.map(p -> persistAeoSeries(p)).reduce(Integer::sum).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("AEO Processed:" + count);
		return count;
	}

	private int persistSedsSeries(String text) {
		// find out series or category
		if (Utility.isSeries(text)) {
			SedsSeries ss1 = Utility.fromJson(text, SedsSeries.class);
			ss1.fillSedsData();
			LOGGER.debug(" series:" + ss1.getName() + " Random data: year="
					+ ss1.getSedData().iterator().next().getYear() + " data="
					+ ss1.getSedData().iterator().next().getData());
			sedsSeriesSvc.save(ss1);
		} else if (Utility.isCategory(text)) {
			Category cat = Utility.fromJson(text, Category.class);
			LOGGER.debug(" Category:" + cat.getName());
			categorySvc.save(cat);
		}
		return 1;
	}

//	@Bean
	public int testCoal() {
		Iterator<String> it;
		int i = 0;
		try {
			it = Files.lines(
					Paths.get("/home/ac2211/Urja/energy/bulk/COAL.small"))
					.iterator();
			while (it.hasNext()) {
				String text = it.next();
				persistGenericSeries(text, CoalSeries.class, coalSeriesSvc,
						CoalCategory.class, coalCategorySvc);
				i++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	@Bean
	public int processNG(){
		return processSubject(Constants.BULK_DATA+Constants.NG_FILE, NgSeries.class, ngSeriesSvc, NgCategory.class, ngCategorySvc);
	}

	public <T extends GenericSeries, J> int processSubject(String file,
			Class<? extends GenericSeries> T, GenericService<T> gsvc,
			Class<?> J, GenericCategoryService<J> gCatSvc) {
		Iterator<String> it;
		int i = 0;
		String text;
		try {
			it = Files.lines(Paths.get(file)).iterator();
			while (it.hasNext()) {
				text = it.next();
				persistGenericSeries(text, T, gsvc, J, gCatSvc);
				i++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
			System.out.println("Found category");
			@SuppressWarnings("unchecked")
			J cat = (J) Utility.fromJson(text, J);
			gCatSvc.save(cat);
		}
		return 1;
	}

	private int persistAeoSeries(String text) {
		// find out series or category
		if (Utility.isSeries(text)) {
			AeoSeries ss = Utility.fromJson(text, AeoSeries.class);
			ss.fillChildData();
			ss.fillLevels();
			LOGGER.debug(" series:" + ss.getName() + " Random data: year="
					+ ss.getChildData().iterator().next().getYear() + " data="
					+ ss.getChildData().iterator().next().getData());
			aeoSeriesSvc.save(ss);
		} else if (Utility.isCategory(text)) {
			AeoCategory cat = Utility.fromJson(text, AeoCategory.class);
			LOGGER.debug(" AEO Category:" + cat.getName());
			aeoCategorySvc.save(cat);
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
		if (fetchMechanism == 'h') {
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
		if (fetchMechanism == 'h') {
			text = Utility.fetchHttp(ApiConstants.UTIL_RATE_JSON_API);

			UtilityRatesJson ur = Utility
					.fromJson(text, UtilityRatesJson.class);
			System.out.println("Total rec:" + ur.getItems().length);

			for (UtilityRates rate : ur.getItems()) {
				this.utilityRateSvc.save(rate);
				if (++i % 100 == 0) {
					System.out.println("Saved row:" + i);
				}
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
		if (fetchMechanism == 'h') {
			text = Utility.fetchHttp(ApiConstants.UTIL_COMP_JSON_API);

			UtilityCompaniesJson ur = Utility.fromJson(text,
					UtilityCompaniesJson.class);
			System.out.println("Total rec:" + ur.getItems().length);

			for (UtilityCompanies comp : ur.getItems()) {
				this.utilityCompSvc.save(comp);
				if (++i % 100 == 0) {
					System.out.println("Saved row:" + i);
				}
			}
		}
		return i;
	}
}