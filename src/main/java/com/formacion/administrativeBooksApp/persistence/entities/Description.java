package com.formacion.administrativeBooksApp.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="descriptions")
public class Description {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	@Column(name="coreconcept")
	private String coreConcept;
	private String endoresement;
	@Column(name="backcover")
	private String backCover;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCoreConcept() {
		return coreConcept;
	}
	public void setCoreConcept(String coreConcept) {
		this.coreConcept = coreConcept;
	}
	public String getEndoresement() {
		return endoresement;
	}
	public void setEndoresement(String endoresement) {
		this.endoresement = endoresement;
	}
	public String getBackCover() {
		return backCover;
	}
	public void setBackCover(String backCover) {
		this.backCover = backCover;
	}
	@Override
	public String toString() {
		return "Description [id=" + id + ", coreConcept=" + coreConcept + ", endoresement=" + endoresement
				+ ", backCover=" + backCover + "]";
	}
	
	
}
