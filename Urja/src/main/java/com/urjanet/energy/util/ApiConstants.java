package com.urjanet.energy.util;

/**
 * List of various APIs to fetch
 * @author ac2211
 *
 */
public class ApiConstants {

	public static final String UTIL_RATE_JSON_FILE = "/home/ac2211/Urja/energy/energyOrig.json";
	public static final String UTIL_COMP_JSON_FILE = "/home/ac2211/Urja/energy/comp.json";
	/**
	 * full detailed utility rates in csv
	 */
	public static final String UTIL_RATE_CSV_API = "http://en.openei.org/services/rest/utility_rates?version=latest&format=csv&detail=full&offset=0&limit=5";
	/**
	 * detailed utility rates in JSON
	 */
	public static final String UTIL_RATE_JSON_API = "http://en.openei.org/services/rest/utility_rates?version=latest&format=json_plain&detail=full";
	/**
	 * detailed utility company data in JSON
	 */
	public static final String UTIL_COMP_JSON_API = "http://en.openei.org/services/rest/utility_companies?version=2&format=json_plain&detail=full";
}
