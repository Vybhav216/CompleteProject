package com.ticketbooking.dto;

import java.time.LocalDate;

public class MovieShowCheckDTO {
	private int movieShowId;
	private LocalDate date;
	public int getMovieShowId() {
		return movieShowId;
	}
	public void setMovieShowId(int movieShowId) {
		this.movieShowId = movieShowId;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	

}
