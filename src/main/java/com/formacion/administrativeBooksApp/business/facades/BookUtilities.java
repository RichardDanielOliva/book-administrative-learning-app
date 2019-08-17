package com.formacion.administrativeBooksApp.business.facades;

import org.modelmapper.ModelMapper;

import com.formacion.administrativeBooksApp.business.util.ConvertAuthorUtil;
import com.formacion.administrativeBooksApp.business.util.ConvertBookUtil;
import com.formacion.administrativeBooksApp.business.util.ConvertCategoryUtil;
import com.formacion.administrativeBooksApp.business.util.FilterBookUtil;
import com.formacion.administrativeBooksApp.business.util.ImageUtil;
import com.formacion.administrativeBooksApp.persistence.entities.Book;
import com.formacion.administrativeBooksApp.presentation.dtos.BookForm;

public interface BookUtilities {
	Book convertBookDtoFormToEntity(BookForm book);
	Book convertBookDtoFormToEntityRest(BookForm book);
	
	ConvertBookUtil getConvert();
	void setConvert(ConvertBookUtil convert);
	ConvertCategoryUtil getConvertCategories();
	void setConvertCategories(ConvertCategoryUtil convertCategories);
	ConvertAuthorUtil getConvertAuthors();
	void setConvertAuthors(ConvertAuthorUtil convertAuthors);
	
	FilterBookUtil getFilter();
	void setFilter(FilterBookUtil filter);
	
	ImageUtil getImageUtil();
	void setImageUtil(ImageUtil imageUtil);
}
