package com.formacion.administrativeBooksApp.business.util;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.formacion.administrativeBooksApp.persistence.entities.Category;
import com.formacion.administrativeBooksApp.presentation.dtos.CategoryBean;

@Component
public class ConvertCategoryUtil extends ModelMapper{
	
	public CategoryBean categoriesEntityToDtoBean(Category category){
		return map(category, CategoryBean.class);
	}
}
