package com.formacion.administrativeBooksApp.persistence.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.formacion.administrativeBooksApp.persistence.entities.enums.Language;

@Entity
@Table(name="books")
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	private String title;
	private Date publicationDate;
	private long ISBN10;
	private long ISBN13;
	private int numPage;
	private String format;
	private String edition;
	
	@Enumerated(EnumType.STRING)
	private Language publicationLanguage;
	@Enumerated(EnumType.STRING)
	private Language translateLanguage;
	private String imgUrl;
	
	@OneToOne (cascade = CascadeType.PERSIST)
	@JoinColumn(name="iddescription")
	private Description description;
	
	@OneToOne (cascade = CascadeType.PERSIST)
	@JoinColumn(name="idrating")
	private Rating rating;
	
	@ManyToOne (cascade = CascadeType.PERSIST)
	@JoinColumn(name="idpublisher")
	private Publisher publisher;
	
	@ManyToMany(cascade = {
	        CascadeType.MERGE 
	    }, fetch = FetchType.EAGER)
	@JoinTable(
			name = "writebook", 
			joinColumns = @JoinColumn(name = "idbook"), 
			inverseJoinColumns = @JoinColumn(name = "idauthor")
			)
	private Set<Author> authors;
	
	@ManyToMany(cascade = {
	        CascadeType.MERGE 
	    }, fetch = FetchType.EAGER)
	@JoinTable(
			name = "bookgroupcategory", 
			joinColumns = @JoinColumn(name = "idbook"), 
			inverseJoinColumns = @JoinColumn(name = "idcategory"))
	private Set<Category> categories;

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

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
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

	public Description getDescription() {
		return description;
	}

	public void setDescription(Description description) {
		this.description = description;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", publicationDate=" + publicationDate + ", ISBN10=" + ISBN10
				+ ", ISBN13=" + ISBN13 + ", authors=" + authors + "]";
	}
}