package com.formacion.administrativeBooksApp.persistence.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
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
import javax.persistence.Table;
import javax.persistence.Transient;

import com.formacion.administrativeBooksApp.persistence.entities.enums.Gender;

@Entity
@Table(name="authors")
public class Author {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE) //forma en la cual se va a generar la clave primaria
	private int id;
	//@Column(name="titulo",length=250,nullable=false)
	private String name;
	private String lastname;
	private Date birthdate;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	private String nationality;
	private String shortBiography;
	
	@ManyToMany(mappedBy = "authors", fetch = FetchType.EAGER)
	private Set<Book> books;
	@Transient
	private String fullNameAuthor;
	
	
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
	
	public Set<Book> getBooks() {
		return books;
	}
	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", lastname=" + lastname;
	}
	public String getFullNameAuthor() {
		return name + " " + lastname;
	}
	
}
