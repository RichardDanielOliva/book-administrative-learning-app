package com.formacion.administrativeBooksApp.presentation.dtos;

import java.util.Date;
import java.util.Set;

import javax.validation.constraints.Pattern;

import com.formacion.administrativeBooksApp.persistence.entities.enums.Gender;

public class AuthorBean {
	private int id;
	@Pattern(regexp = "[a-z-A-Z]*", message = "First name of the author has invalid characters")
	private String name;
	@Pattern(regexp = "[a-z-A-Z]*", message = "Last name of the author has invalid characters")
	private String lastname;
	private Date birthdate;
	private Gender gender;
	private String nationality;
	private String shortBiography;
	private Set<Integer> booksId;
	private String fullNameAuthor = name + " " + lastname;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public void setGender(Gender gender) {
		this.gender = gender;
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
	public String getFullNameAuthor() {
		return fullNameAuthor;
	}
	public void setFullNameAuthor(String fullNameAuthor) {
		this.fullNameAuthor = name + " " + lastname;
	}
	public Set<Integer> getBooksId() {
		return booksId;
	}
	public void setBooksId(Set<Integer> booksId) {
		this.booksId = booksId;
	}
	
	
}
