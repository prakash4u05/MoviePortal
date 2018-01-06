package com.applesample.SpringMoviePortal.Beans;

import java.time.LocalDate;

import javax.xml.bind.annotation.XmlRootElement;


public class Movies {
	
	private String movieTitle;
	private int moviePrice;
	//private LocalDate dateIssued;
	
	public Movies(){}
	public String getMovieTitle() {
		return movieTitle;
	}
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	public Movies(String movieTitle, int moviePrice){//, LocalDate dateIssued) {
		super();
		this.movieTitle = movieTitle;
		this.moviePrice = moviePrice;
		//this.dateIssued = dateIssued;
		
	}
	public int getMoviePrice() {
		return moviePrice;
	}
	public void setMoviePrice(int moviePrice) {
		this.moviePrice = moviePrice;
	}
//	public LocalDate getDateIssued() {
//		return dateIssued;
//	}
//	public void setDateIssued(LocalDate dateIssued) {
//		this.dateIssued = dateIssued;
//	}
	//public LocalDate getCurrentDate() {
		//return LocalDate.now();
	//}
	
	

}
