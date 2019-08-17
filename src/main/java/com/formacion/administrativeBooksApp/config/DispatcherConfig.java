package com.formacion.administrativeBooksApp.config;

import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import java.util.Arrays;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.cache.transaction.TransactionAwareCacheManagerProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jndi.JndiTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.formacion.administrativeBooksApp.persistence.repositories")
@ComponentScan(basePackages = {
		"com.formacion.administrativeBooksApp.business.services",
		"com.formacion.administrativeBooksApp.business.facades",
		"com.formacion.administrativeBooksApp.persistence.facades",
		"com.formacion.administrativeBooksApp.business.util",
		"com.formacion.administrativeBooksApp.business.api"
		} )
public class DispatcherConfig {
	@Autowired
	private Environment env;
	 
	 @Bean 
	 public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws NamingException {
	      LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
	      em.setDataSource(dataSource()); 
	      em.setPackagesToScan(new String[] {"com.formacion.administrativeBooksApp.persistence.entities"}); 
	 
	      JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	      em.setJpaVendorAdapter(vendorAdapter); 
	      em.setJpaProperties(additionalProperties());
	 
	      return em;
	}
	 
	private Properties additionalProperties() {
		    Properties properties = new Properties();

		  	properties.setProperty("hibernate.dialect", env.getProperty("postgreSQL.dialect"));
		    properties.setProperty("hibernate.show_sql", "true"); 
		    properties.setProperty("jpa.generateDdl", "false"); 

		    return properties;
	}
	
	@Bean 
	public DataSource dataSource() throws NamingException{
		
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setDriverClassName(env.getProperty("database.driverClassName"));
	    dataSource.setUrl(env.getProperty("database.url"));
	    dataSource.setUsername(env.getProperty("database.username"));
	    dataSource.setPassword(env.getProperty("database.password"));
	    return dataSource;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
	    JpaTransactionManager transactionManager = new JpaTransactionManager();
	    transactionManager.setEntityManagerFactory(emf);
	 
	    return transactionManager;
	}
}
