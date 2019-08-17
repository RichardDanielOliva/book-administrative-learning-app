package com.formacion.administrativeBooksApp.presentation.dtos;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.formacion.administrativeBooksApp.persistence.entities.enums.Language;

public class BookBean {
	private int id;
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
	private String descriptionCoreConcept;
	private String descriptionEndoresement;
	private String descriptionBackCover;
	private int publisherId;
	private String publisherName;
	private List<Integer> idAuthors;
	private List<String> fullNameAuthors;
	private List<Integer> categoriesId;
	private List<String> categoriesTitle;
	//private int rating;

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

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	/**public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}*/

	public List<Integer> getIdAuthors() {
		return idAuthors;
	}

	public void setIdAuthors(List<Integer> idAuthors) {
		this.idAuthors = idAuthors;
	}

	public List<String> getFullNameAuthors() {
		return fullNameAuthors;
	}

	public void setFullNameAuthors(List<String> fullNameAuthors) {
		this.fullNameAuthors = fullNameAuthors;
	}
	public List<Integer> getCategoriesId() {
		return categoriesId;
	}

	public void setCategoriesId(List<Integer> categoriesId) {
		this.categoriesId = categoriesId;
	}

	public List<String> getCategoriesTitle() {
		return categoriesTitle;
	}

	public void setCategoriesTitle(List<String> categoriesTitle) {
		this.categoriesTitle = categoriesTitle;
	}

	@Override
	public String toString() {
		return "BookBean [id=" + id + ", title=" + title + ", publicationDate=" + publicationDate + ", ISBN10=" + ISBN10
				+ ", ISBN13=" + ISBN13 + ", numPage=" + numPage + ", format=" + format + ", publicationLanguage="
				+ publicationLanguage + ", translateLanguage=" + translateLanguage + ", imgUrl=" + imgUrl
				+ ", descriptionId=" + descriptionId + ", descriptionCoreConcept=" + descriptionCoreConcept
				+ ", descriptionEndoresement=" + descriptionEndoresement + ", descriptionBackCover="
				+ descriptionBackCover + ", publisherId=" + publisherId + ", publisherName=" + publisherName
				+ ", idAuthors=" + idAuthors + ", fullNameAuthors=" + fullNameAuthors + ", categoriesId=" + categoriesId
				+ ", categoriesTitle=" + categoriesTitle + "]";
	}
}

