package com.formacion.administrativeBooksApp.config;

import java.util.Arrays;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.cache.transaction.TransactionAwareCacheManagerProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CachingConfig {
	
	@Bean
	public CacheManager cacheManager() {

	        SimpleCacheManager cacheManager = new SimpleCacheManager();
	        cacheManager.setCaches(Arrays.asList(
	          new ConcurrentMapCache("booksForm"), 
	          new ConcurrentMapCache("booksBean"),
	          new ConcurrentMapCache("bookCache"),
	          new ConcurrentMapCache("booksFormCategories"),
	          new ConcurrentMapCache("booksFormAuthors")));
	        
	        cacheManager.initializeCaches();
	        
	     return new TransactionAwareCacheManagerProxy(cacheManager);
	}
}
