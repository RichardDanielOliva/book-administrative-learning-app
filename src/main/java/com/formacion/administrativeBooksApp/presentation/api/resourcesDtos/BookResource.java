package com.formacion.administrativeBooksApp.presentation.api.resourcesDtos;

import java.util.Date;
import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.hateoas.ResourceSupport;

import com.formacion.administrativeBooksApp.persistence.entities.enums.Language;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

public class BookResource extends ResourceSupport{
	private int bookId;
	
	@ApiModelProperty(required = true)
	@NotEmpty (message = "The book must have a title")
	private String title;
	
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date publicationDate;
	
	private long ISBN10;
	private long ISBN13;
	private int numPage;
	private String format;
	private Language publicationLanguage;
	private Language translateLanguage;
	private String imgUrl;
	private int descriptionId;
	private int publisherId;
	private List<Integer> idAuthors;
	private List<Integer> categoriesId;
	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getPublicationDate() {
		return publicationDate;
	}
	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}
	public long getISBN10() {
		return ISBN10;
	}
	public void setISBN10(long iSBN10) {
		ISBN10 = iSBN10;
	}
	public long getISBN13() {
		return ISBN13;
	}
	public void setISBN13(long iSBN13) {
		ISBN13 = iSBN13;
	}
	public int getNumPage() {
		return numPage;
	}
	public void setNumPage(int numPage) {
		this.numPage = numPage;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}

	public Language getPublicationLanguage() {
		return publicationLanguage;
	}
	public void setPublicationLanguage(Language publicationLanguage) {
		this.publicationLanguage = publicationLanguage;
	}
	public Language getTranslateLanguage() {
		return translateLanguage;
	}
	public void setTranslateLanguage(Language translateLanguage) {
		this.translateLanguage = translateLanguage;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public int getDescriptionId() {
		return descriptionId;
	}
	public void setDescriptionId(int descriptionId) {
		this.descriptionId = descriptionId;
	}
	public int getPublisherId() {
		return publisherId;
	}
	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
	}
	public List<Integer> getIdAuthors() {
		return idAuthors;
	}
	public void setIdAuthors(List<Integer> idAuthors) {
		this.idAuthors = idAuthors;
	}
	public List<Integer> getCategoriesId() {
		return categoriesId;
	}
	public void setCategoriesId(List<Integer> categoriesId) {
		this.categoriesId = categoriesId;
	}

	
}

