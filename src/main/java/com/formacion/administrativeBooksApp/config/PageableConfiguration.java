package com.formacion.administrativeBooksApp.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;

@Configuration
public class PageableConfiguration extends WebMvcConfigurerAdapter{
    static final Sort BOOK_SORT = Sort.by("title").and(Sort.by("publicationDate"));
    static final Pageable DEFAULT_PAGE_REQUEST = new PageRequest(0, 4,BOOK_SORT);


    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        PageableHandlerMethodArgumentResolver resolver = new PageableHandlerMethodArgumentResolver();
        resolver.setFallbackPageable(DEFAULT_PAGE_REQUEST);
        argumentResolvers.add(resolver);
        super.addArgumentResolvers(argumentResolvers);
    }
}
