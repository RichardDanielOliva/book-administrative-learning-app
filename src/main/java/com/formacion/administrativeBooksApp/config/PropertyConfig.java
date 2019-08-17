package com.formacion.administrativeBooksApp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySources({
    @PropertySource("classpath:dataSource.properties")
})
public class PropertyConfig {
	
	public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
	    PropertySourcesPlaceholderConfigurer properties = new PropertySourcesPlaceholderConfigurer();
	    return properties;
	}
	
}
