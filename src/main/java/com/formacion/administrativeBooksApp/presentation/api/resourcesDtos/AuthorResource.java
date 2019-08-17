package com.formacion.administrativeBooksApp.presentation.api.resourcesDtos;

import java.util.Date;
import java.util.Set;

import org.springframework.hateoas.ResourceSupport;

import com.formacion.administrativeBooksApp.persistence.entities.enums.Gender;

public class AuthorResource extends ResourceSupport{
	private int authorId;
	private String name;
	private String lastname;
	private Date birthdate;
	private Gender gender;
	private String nationality;
	private String shortBiography;
	private Set<Integer> booksId;
	
	public AuthorResource() {
		super();
	}
	
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender string) {
		this.gender = string;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getShortBiography() {
		return shortBiography;
	}
	public void setShortBiography(String shortBiography) {
		this.shortBiography = shortBiography;
	}
	public Set<Integer> getBooksId() {
		return booksId;
	}
	public void setBooksId(Set<Integer> booksId) {
		this.booksId = booksId;
	}
	
	
}
