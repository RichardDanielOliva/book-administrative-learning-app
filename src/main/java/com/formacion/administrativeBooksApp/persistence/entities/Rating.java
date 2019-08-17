package com.formacion.administrativeBooksApp.persistence.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="ratings")
public class Rating {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private double globalRating;
	@Transient
	private double amazonBestSellerRank;
	private double goodreads;
	private boolean bestseller;
	private String awardWinner;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getGlobalRating() {
		return globalRating;
	}
	public void setGlobalRating(double globalRating) {
		this.globalRating = globalRating;
	}
	public double getAmazonBestSellerRank() {
		return amazonBestSellerRank;
	}
	public void setAmazonBestSellerRank(double amazonBestSellerRank) {
		this.amazonBestSellerRank = amazonBestSellerRank;
	}
	public double getGoodreads() {
		return goodreads;
	}
	public void setGoodreads(double goodreads) {
		this.goodreads = goodreads;
	}
	public boolean isBestseller() {
		return bestseller;
	}
	public void setBestseller(boolean bestseller) {
		this.bestseller = bestseller;
	}
	public String getAwardWinner() {
		return awardWinner;
	}
	public void setAwardWinner(String awardWinner) {
		this.awardWinner = awardWinner;
	}
	
}
