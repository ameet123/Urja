package com.urjanet.energy;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.urjanet.energy.entity.UtilityRates;
import com.urjanet.energy.json.UtilityRatesJson;
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
	/**
	 * JSON for Utility Rates table
	 */
	@Bean
	public int processUtilityRates() {
		String text = Utility.fetchHttp(ApiConstants.UTIL_RATE_JSON_API);
		System.out.println("From static util few lines:"
				+ text.substring(0, 200));

		UtilityRatesJson ur = Utility.fromJson(text, UtilityRatesJson.class);
		System.out.println("1st:" + ur.getItems()[0].getName());
		System.out.println("Total rec:" + ur.getItems().length);
		UtilityRates uDb = new UtilityRates();
		// copy from json to entity
		BeanUtils.copyProperties(ur.getItems()[0], uDb);
		System.out.println("Entity class: label=>"+uDb.getLabel());
		return 1;
	}
}