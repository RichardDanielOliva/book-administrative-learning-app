package com.formacion.administrativeBooksApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc 
@ComponentScan(basePackages  = {
		"com.formacion.administrativeBooksApp.presentation.controllers",
		"com.formacion.administrativeBooksApp.presentation.api.controllers"
})
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
public class AppConfig implements WebMvcConfigurer {
	  
	  @Bean
	   public InternalResourceViewResolver getInternalResourceViewResolver() {  
	   InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	   resolver.setPrefix("/WEB-INF/jsp/");
	   resolver.setSuffix(".jsp");
	   return resolver;
	  }
	  
	  @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry
	          .addResourceHandler("/resources/**")
	          .addResourceLocations("/resources/"); 	        
	    }
	  
	  @Bean
	    public MultipartResolver multipartResolver() {
	        return new StandardServletMultipartResolver();
	    }	  
}