package com.formacion.administrativeBooksApp.presentation.dtos;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class BookForm {
	
	private int id;
	@NotEmpty (message = "The book must have a title") 
	@Size(min=2, max=255)
	private String title;
	@DateTimeFormat(pattern="dd-MM-yyyy") 
	@Past(message = "The book must have a past date")
	private Date publicationDate;
	@Digits(integer=10, fraction=0) 
	private long ISBN10;
	@Digits(integer=13, fraction=0) 
	private long ISBN13;
	private int numPage;
	@NotEmpty (message = "The book must have format") 
	private String format;
	private String publicationLanguage;
	private String translateLanguage;
	private String imgUrl;
	
	private int descriptionId;
	private String descriptionCoreConcept;
	private String descriptionEndoresement;
	private String descriptionBackCover;
	
	private int publisherId;
	private String newPublisherName; //
	private List<Integer> authorsId;
	
	private List<String> newAuthorsName;
	private List<String> newAuthorsLastName; //Hay que implementar en el formulario
	
	private List<Integer> categoriesId; 
	private List<String> newCategoriesName; //Hay que implementar en el formulario
	
	private int ratingProvisionalValue;
	
	public int getId() {
		return id;
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
	public String getPublicationLanguage() {
		return publicationLanguage;
	}
	public void setPublicationLanguage(String publicationLanguage) {
		this.publicationLanguage = publicationLanguage;
	}
	public String getTranslateLanguage() {
		return translateLanguage;
	}
	public void setTranslateLanguage(String translateLanguage) {
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
	public String getDescriptionCoreConcept() {
		return descriptionCoreConcept;
	}
	public void setDescriptionCoreConcept(String descriptionCoreConcept) {
		this.descriptionCoreConcept = descriptionCoreConcept;
	}
	public String getDescriptionEndoresement() {
		return descriptionEndoresement;
	}
	public void setDescriptionEndoresement(String descriptionEndoresement) {
		this.descriptionEndoresement = descriptionEndoresement;
	}
	public String getDescriptionBackCover() {
		return descriptionBackCover;
	}
	public void setDescriptionBackCover(String descriptionBackCover) {
		this.descriptionBackCover = descriptionBackCover;
	}
	public int getPublisherId() {
		return publisherId;
	}
	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
	}
	public String getNewPublisherName() {
		return newPublisherName;
	}
	public void setNewPublisherName(String newPublisherName) {
		this.newPublisherName = newPublisherName;
	}
	public List<Integer> getAuthorsId() {
		return authorsId;
	}
	public void setAuthorsId(List<Integer> authorsId) {
		this.authorsId = authorsId;
	}
	public List<Integer> getCategoriesId() {
		return categoriesId;
	}
	public void setCategoriesId(List<Integer> categoriesId) {
		this.categoriesId = categoriesId;
	}
	public int getRatingProvisionalValue() {
		return ratingProvisionalValue;
	}
	public void setRatingProvisionalValue(int ratingProvisionalValue) {
		this.ratingProvisionalValue = ratingProvisionalValue;
	}
	public List<String> getNewAuthorsName() {
		return newAuthorsName;
	}
	public void setNewAuthorsName(List<String> newAuthorsName) {
		this.newAuthorsName = newAuthorsName;
	}
	public List<String> getNewCategoriesName() {
		return newCategoriesName;
	}
	public void setNewCategoriesName(List<String> newCategoriesName) {
		this.newCategoriesName = newCategoriesName;
	}
	@Override
	public String toString() {
		return "BookForm [id=" + id + ", title=" + title + ", publicationDate=" + publicationDate + ", ISBN10=" + ISBN10
				+ ", ISBN13=" + ISBN13 + ", numPage=" + numPage + ", format=" + format + ", publicationLanguage="
				+ publicationLanguage + ", translateLanguage=" + translateLanguage + ", imgUrl=" + imgUrl
				+ ", descriptionId=" + descriptionId + ", descriptionCoreConcept=" + descriptionCoreConcept
				+ ", descriptionEndoresement=" + descriptionEndoresement + ", descriptionBackCover="
				+ descriptionBackCover + ", publisherId=" + publisherId + ", newPublisherName=" + newPublisherName
				+ ", authorsId=" + authorsId + ", newAuthorsName=" + newAuthorsName + ", categoriesId=" + categoriesId
				+ ", newCategoriesName=" + newCategoriesName + ", ratingProvisionalValue=" + ratingProvisionalValue
				+ "]";
	}
	public List<String> getNewAuthorsLastName() {
		return newAuthorsLastName;
	}
	public void setNewAuthorsLastName(List<String> newAuthorsLastName) {
		this.newAuthorsLastName = newAuthorsLastName;
	}
}
