package com.urjanet.energy;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import com.jolbox.bonecp.BoneCPDataSource;
import com.urjanet.energy.util.Constants;

@Configuration
@EnableJpaRepositories
@PropertySource("datastore.properties")
public class DataSourceContext {

	// Get the values from property files.
	@Value("${" + Constants.PROPERTY_NAME_BONECP_PART_CNT + "}")
	private int boneCpPartCnt;

	@Value("${" + Constants.PROPERTY_NAME_BONECP_MAX_CNT_PER_PART + "}")
	private int boneCpMaxConnPerPart;

	@Value("${" + Constants.PROPERTY_NAME_HIBERNATE_DIALECT + "}")
	private String hibDialect;

	@Value("${" + Constants.PROPERTY_NAME_DATABASE_DRIVER + "}")
	private String dbDriver;
	@Value("${" + Constants.PROPERTY_NAME_DATABASE_URL + "}")
	private String dbUrl;
	@Value("${" + Constants.PROPERTY_NAME_DATABASE_USERNAME + "}")
	private String dbUser;
	@Value("${" + Constants.PROPERTY_NAME_DATABASE_PASSWORD + "}")
	private String dbPass;

	@Value("${" + Constants.PROPERTY_NAME_HIBERNATE_FORMAT_SQL + "}")
	private String hibFormatSQL;
	@Value("${" + Constants.PROPERTY_NAME_QUERY_STATS + "}")
	private boolean hibGenerateStats;
	@Value("${" + Constants.PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY + "}")
	private String hibNameStrategy;
	@Value("${" + Constants.PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN + "}")
	private String[] entityPkgToScan;
	@Value("${" + Constants.PROPERTY_NAME_DDL_AUTOCREATE + ":\"\"}")
	private String ddlAutoCreate;
	@Value("${" + Constants.PROPERTY_NAME_HIBERNATE_SHOW_SQL + "}")
	private String showSQL;

	@Value("${" + Constants.PROPERTY_NAME_MESSAGESOURCE_BASENAME + "}")
	private String msgBasename;
	@Value("${"
			+ Constants.PROPERTY_NAME_MESSAGESOURCE_USE_CODE_AS_DEFAULT_MESSAGE
			+ "}")
	private boolean msgCode;

	@Bean
	public DataSource dataSource() {
		BoneCPDataSource dataSource = new BoneCPDataSource();
		// mysql as db provider
		dataSource.setDriverClass(dbDriver);
		dataSource.setJdbcUrl(dbUrl);
		dataSource.setUsername(dbUser);
		dataSource.setPassword(dbPass);
		dataSource.setPartitionCount(boneCpPartCnt);
		dataSource.setMaxConnectionsPerPartition(boneCpMaxConnPerPart);
		return dataSource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory()
			throws ClassNotFoundException {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();

		entityManagerFactoryBean.setDataSource(dataSource());
		entityManagerFactoryBean.setPackagesToScan(entityPkgToScan);
		entityManagerFactoryBean
				.setPersistenceProviderClass(HibernatePersistenceProvider.class);

		Properties jpaProterties = new Properties();
		jpaProterties
				.put(Constants.PROPERTY_NAME_HIBERNATE_DIALECT, hibDialect);
		jpaProterties.put(Constants.PROPERTY_NAME_HIBERNATE_FORMAT_SQL,
				hibFormatSQL);
		jpaProterties.put(Constants.PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY,
				hibNameStrategy);
		jpaProterties.put(Constants.PROPERTY_NAME_HIBERNATE_SHOW_SQL, showSQL);

		jpaProterties
				.put(Constants.PROPERTY_NAME_QUERY_STATS, hibGenerateStats);

		if (!ddlAutoCreate.isEmpty()) {
			jpaProterties.put(Constants.PROPERTY_NAME_DDL_AUTOCREATE,
					ddlAutoCreate);
		}

		entityManagerFactoryBean.setJpaProperties(jpaProterties);
		return entityManagerFactoryBean;
	}

	@Bean
	public JpaTransactionManager transactionManager()
			throws ClassNotFoundException {
		JpaTransactionManager transactionManager = new JpaTransactionManager();

		transactionManager.setEntityManagerFactory(entityManagerFactory()
				.getObject());

		return transactionManager;
	}

	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename(msgBasename);
		messageSource.setUseCodeAsDefaultMessage(msgCode);
		return messageSource;
	}
}
