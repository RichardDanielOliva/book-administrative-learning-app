package com.formacion.administrativeBooksApp.persistence.entities;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="publishers")
public class Publisher {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	private String founder;
	private String name;
	private String website;
	private String location;
	@Transient
	private Publisher group;
	@Column(name="datefounder")
	private Date dateFounder;
	@OneToMany(mappedBy="publisher", fetch=FetchType.EAGER) //fetch: cada vez que se haga un consulta en Book tambien se generar el pubisher corespondiente
	private Set<Book> books;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFounder() {
		return founder;
	}
	public void setFounder(String founder) {
		this.founder = founder;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Publisher getGroup() {
		return group;
	}
	public void setGroup(Publisher group) {
		this.group = group;
	}
	public Date getDateFounder() {
		return dateFounder;
	}
	public void setDateFounder(Date dateFounder) {
		this.dateFounder = dateFounder;
	}
	private Set<Book> getBooks() {
		return books;
	}
	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Publisher [id=" + id + ", founder=" + founder + ", name=" + name + ", website=" + website
				+ ", location=" + location + ", dateFounder=" + dateFounder + "]";
	}
	
	
}
