package com.formacion.administrativeBooksApp.business.facades;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.formacion.administrativeBooksApp.business.util.ConvertAuthorUtil;
import com.formacion.administrativeBooksApp.business.util.ConvertBookUtil;
import com.formacion.administrativeBooksApp.business.util.ConvertCategoryUtil;
import com.formacion.administrativeBooksApp.business.util.FilterBookUtil;
import com.formacion.administrativeBooksApp.business.util.ImageUtil;
import com.formacion.administrativeBooksApp.persistence.entities.Book;
import com.formacion.administrativeBooksApp.persistence.facades.Repositories;
import com.formacion.administrativeBooksApp.presentation.dtos.BookForm;

@Component
public class BookUtilitiesImp implements BookUtilities{
	@Autowired
	private ConvertBookUtil convert;
	@Autowired
	private ConvertCategoryUtil convertCategories;
	@Autowired
	private ConvertAuthorUtil convertAuthors;
	
	@Autowired
	private FilterBookUtil filter;
	
	@Autowired
	private ImageUtil imageUtil;
	
	@Autowired
	private Repositories repositories;
	
	
	@Override
	public Book convertBookDtoFormToEntity(BookForm book) {
		if(book.getNewAuthorsName() != null && !book.getNewAuthorsName().isEmpty()) {
			repositories.insertAuthorFromBookForm(book.getNewAuthorsName(), book.getNewAuthorsLastName());
			book.setAuthorsId(repositories.getAuthorsIdsByNameAndLastName(book));
		}
		return convert.bookDtoFormToEntity(book, repositories.getAuthors().findAll(), repositories.getCategories().findAll());
	}
	
	@Override
	public Book convertBookDtoFormToEntityRest(BookForm book) {
		return convert.bookDtoFormToEntity(book);
	}
	
	@Override
	public ConvertBookUtil getConvert() {
		return convert;
	}
	@Override
	public void setConvert(ConvertBookUtil convert) {
		this.convert = convert;
	}
	@Override
	public FilterBookUtil getFilter() {
		return filter;
	}
	@Override
	public void setFilter(FilterBookUtil filter) {
		this.filter = filter;
	}
	@Override
	public ConvertCategoryUtil getConvertCategories() {
		return convertCategories;
	}
	@Override
	public void setConvertCategories(ConvertCategoryUtil convertCategories) {
		this.convertCategories = convertCategories;
	}
	@Override
	public ConvertAuthorUtil getConvertAuthors() {
		return convertAuthors;
	}
	@Override
	public void setConvertAuthors(ConvertAuthorUtil convertAuthors) {
		this.convertAuthors = convertAuthors;
	}
	@Override
	public ImageUtil getImageUtil() {
		return imageUtil;
	}
	@Override
	public void setImageUtil(ImageUtil imageUtil) {
		this.imageUtil = imageUtil;
	}

}
