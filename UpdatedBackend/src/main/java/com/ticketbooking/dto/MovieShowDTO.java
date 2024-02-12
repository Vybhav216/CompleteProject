package com.ticketbooking.dto;

import java.time.LocalDate;

import com.ticketbooking.entities.MovieShow;

public class MovieShowDTO extends MovieShow {

//    private int movieShowId;
//    private LocalDate movieShowStartDate;
//    private LocalDate movieShowEndDate;
//    private int slot;
//    private int price;
//    private int theatreId; // ID of the associated Theatre
//    private int movieId;   // ID of the associated Movie
//
//    public MovieShowDTO() {
//        // Default constructor
//    }
//
//    public MovieShowDTO(int movieShowId, LocalDate movieShowStartDate, LocalDate movieShowEndDate, int slot, int price,
//                        int theatreId, int movieId) {
//        this.movieShowId = movieShowId;
//        this.movieShowStartDate = movieShowStartDate;
//        this.movieShowEndDate = movieShowEndDate;
//        this.slot = slot;
//        this.price = price;
//        this.theatreId = theatreId;
//        this.movieId = movieId;
//    }
//
//    // Getters and setters for all fields
//
//    public int getMovieShowId() {
//        return movieShowId;
//    }
//
//    public void setMovieShowId(int movieShowId) {
//        this.movieShowId = movieShowId;
//    }
//
//    public LocalDate getMovieShowStartDate() {
//        return movieShowStartDate;
//    }
//
//    public void setMovieShowStartDate(LocalDate movieShowStartDate) {
//        this.movieShowStartDate = movieShowStartDate;
//    }
//
//    public LocalDate getMovieShowEndDate() {
//        return movieShowEndDate;
//    }
//
//    public void setMovieShowEndDate(LocalDate movieShowEndDate) {
//        this.movieShowEndDate = movieShowEndDate;
//    }
//
//    public int getSlot() {
//        return slot;
//    }
//
//    public void setSlot(int slot) {
//        this.slot = slot;
//    }
//
//    public int getPrice() {
//        return price;
//    }
//
//    public void setPrice(int price) {
//        this.price = price;
//    }
//
//    public int getTheatreId() {
//        return theatreId;
//    }
//
//    public void setTheatreId(int theatreId) {
//        this.theatreId = theatreId;
//    }
//
//    public int getMovieId() {
//        return movieId;
//    }
//
//    public void setMovieId(int movieId) {
//        this.movieId = movieId;
//    }
	
	
	private int theatreId;
	private int movieId;
	
	
	public int getTheatreId() {
		return theatreId;
	}
	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
