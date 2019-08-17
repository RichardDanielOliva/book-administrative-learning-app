package com.formacion.administrativeBooksApp.presentation.dtos;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;


public class BookSearch {
	private int id;
	private String title;
	private String author;
	//@NotEmpty (message = "The search must have at least one Category")
	private String category;
	private long ISBN13;
	//@NotEmpty (message = "The search must have a Rating value")
	private List<Integer> searchRating;
	//@NotEmpty  (message = "The search must have at least one language")
	private List<String> searchLanguages;
	//@NotEmpty (message = "The search must have a Rating value")
	private List<Integer> categoriesId;
	private boolean administrativeSearch = false;
	private List<String> displayRating;
	@DateTimeFormat(pattern="dd-MM-yyyy")
	@Past(message = "The book must have a past date")
	private Date publicationDate;
	private int publicationDateBeforeAfter;

	public int getId() {
		return id + 1;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<Integer> getSearchRating() {
		return searchRating;
	}

	public void setSearchRating(List<Integer> searchRating) {
		this.searchRating = searchRating;
	}

	public List<String> getSearchLanguages() {
		return searchLanguages;
	}

	public void setSearchLanguages(List<String> searchLanguages) {
		this.searchLanguages = searchLanguages;
	}

	public List<String> getDisplayRating() {
		return displayRating;
	}

	public void setDisplayRating(List<String> displayRating) {
		this.displayRating = displayRating;
	}
	public long getISBN13() {
		return ISBN13;
	}
	public void setISBN13(long iSBN13) {
		ISBN13 = iSBN13;
	}
	public boolean isAdministrativeSearch() {
		return administrativeSearch;
	}
	public void setAdministrativeSearch(boolean administrativeSearch) {
		this.administrativeSearch = administrativeSearch;
	}
	public List<Integer> getCategoriesId() {
		return categoriesId;
	}
	public void setCategoriesId(List<Integer> categoryId) {
		this.categoriesId = categoryId;
	}
	public Date getPublicationDate() {
		return publicationDate;
	}
	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}
	public int getPublicationDateBeforeAfter() {
		return publicationDateBeforeAfter;
	}
	public void setPublicationDateBeforeAfter(int publicationDateBeforeAfter) {
		this.publicationDateBeforeAfter = publicationDateBeforeAfter;
	}
}
