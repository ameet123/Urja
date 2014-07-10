package com.urjanet.energy.util;

import org.apache.commons.io.FilenameUtils;

public class Constants {

	// Data pool related parameters
	public static final String PROPERTY_NAME_DATABASE_DRIVER = "db.driver";
	public static final String PROPERTY_NAME_DATABASE_PASSWORD = "db.password";
	public static final String PROPERTY_NAME_DATABASE_URL = "db.url";
	public static final String PROPERTY_NAME_DATABASE_USERNAME = "db.username";
	public static final String PROPERTY_NAME_BONECP_PART_CNT = "bonecp.partitionCount";
	public static final String PROPERTY_NAME_BONECP_MAX_CNT_PER_PART = "bonecp.maxConnectionsPerPartition";

	// Hibernate parameters
	public static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
	public static final String PROPERTY_NAME_HIBERNATE_FORMAT_SQL = "hibernate.format_sql";
	public static final String PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY = "hibernate.ejb.naming_strategy";
	public static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
	public static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN = "entitymanager.packages.to.scan";
	public static final String PROPERTY_NAME_DDL_AUTOCREATE = "hibernate.hbm2ddl.auto";
	public static final String PROPERTY_NAME_JPA_L2_CACHE = "hibernate.cache.use_second_level_cache";
	public static final String PROPERTY_NAME_QUERY_CACHE = "hibernate.cache.use_query_cache";
	public static final String PROPERTY_NAME_CACHE_FACTORY_CLASS = "hibernate.cache.region.factory_class";
	public static final String PROPERTY_NAME_QUERY_STATS = "hibernate.generate_statistics";
	public static final String PROPERTY_NAME_CACHE_MODE = "cache.mode";

	public static final String PROPERTY_NAME_MESSAGESOURCE_BASENAME = "message.source.basename";
	public static final String PROPERTY_NAME_MESSAGESOURCE_USE_CODE_AS_DEFAULT_MESSAGE = "message.source.use.code.as.default.message";
	
	// file constants
	public static final String SERIES_PATTERN = "^\\{\"series_id";
	public static final String CATEGORY_PATTERN = "^\\{\"category_id";
	
	public static final String BULK_DATA = "/home/ac2211/Urja/energy/bulk/";
	public static final String AEO_FILE = "AEO.txt";
	public static final String SEDS_FILE = "SEDS.txt";
	public static final String NG_FILE = "NG.txt";
	public static final String PET_FILE = "PET.txt";
	public static final String COAL_FILE = "COAL.txt";
	
	public static final String MANIFEST_HTTP = "http://api.eia.gov/bulk/manifest.txt";
	
	public static final String COAL_HTTP = "http://api.eia.gov/bulk/COAL.zip";
	public static final String AEO_HTTP = "http://api.eia.gov/bulk/AEO.zip";
	public static final String PET_HTTP = "http://api.eia.gov/bulk/PET.zip";
	public static final String NG_HTTP = "http://api.eia.gov/bulk/NG.zip";
	public static final String SEDS_HTTP = "http://api.eia.gov/bulk/SEDS.zip";
	
	public static final String SEDS_ZIP = FilenameUtils.getName(SEDS_HTTP);
	public static final String AEO_ZIP = FilenameUtils.getName(AEO_HTTP);
}