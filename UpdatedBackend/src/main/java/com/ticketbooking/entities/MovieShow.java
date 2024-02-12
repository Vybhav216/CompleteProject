package com.ticketbooking.entities;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Positive;

@Entity
public class MovieShow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movieShowId;

    @Column(nullable = false)
    @FutureOrPresent(message = "Movie show start date must be in the present or future.")
    private LocalDate movieShowStartDate;

    @FutureOrPresent(message = "Movie show end date must be in the present or future.")
    private LocalDate movieShowEndDate;

    @Positive(message = "Slot must be a positive integer.")
    private int slot;

    @Positive(message = "Price must be a positive value.")
    private int price;

    @ManyToOne
    @JoinColumn(name = "theatre_id")
    private Theatre theatre;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

	public MovieShow() {
		super();
	}



	public MovieShow(int movieShowId, LocalDate movieShowStartDate, LocalDate movieShowEndDate, int slot, int price,
			Theatre theatre, Movie movie) {
		super();
		this.movieShowId = movieShowId;
		this.movieShowStartDate = movieShowStartDate;
		this.movieShowEndDate = movieShowEndDate;
		this.slot = slot;
		this.price = price;
		this.theatre = theatre;
		this.movie = movie;
	}
	
	public MovieShow(LocalDate movieShowStartDate, LocalDate movieShowEndDate, int slot, int price,
			Theatre theatre, Movie movie) {
		super();
		this.movieShowStartDate = movieShowStartDate;
		this.movieShowEndDate = movieShowEndDate;
		this.slot = slot;
		this.price = price;
		this.theatre = theatre;
		this.movie = movie;
	}



	public int getMovieShowId() {
		return movieShowId;
	}

	public void setMovieShowId(int movieShowId) {
		this.movieShowId = movieShowId;
	}

	public LocalDate getMovieShowStartDate() {
		return movieShowStartDate;
	}

	public void setMovieShowStartDate(LocalDate movieShowStartDate) {
		this.movieShowStartDate = movieShowStartDate;
	}

	public LocalDate getMovieShowEndDate() {
		return movieShowEndDate;
	}

	public void setMovieShowEndDate(LocalDate movieShowEndDate) {
		this.movieShowEndDate = movieShowEndDate;
	}

	public Theatre getTheatre() {
		return theatre;
	}

	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public int getSlot() {
		return slot;
	}

	public void setSlot(int slot) {
		this.slot = slot;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
    
}

