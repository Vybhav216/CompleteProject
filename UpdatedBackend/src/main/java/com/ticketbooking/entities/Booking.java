package com.ticketbooking.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.persistence.JoinColumn;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;
    
    //@NotNull(message = "Booking Date can't be null")
    private LocalDate bookDate;

//    @NotNull(message = "Show Date can't be null")
    @FutureOrPresent(message = "Show Date can't be in past")
    private LocalDate showDate;

    //@NotBlank
    private String state;

   // @NotBlank(message = "Seat number can't be null")
    private String seatNos;

    //@Positive(message = "No of seats can't be negative")
    private int noOfSeats;

    @Positive(message = "Cost can't be negative")
    private float cost;

    //@Positive(message = "Charges can't be negative")
    private float cancelCharges;

    @ManyToOne
    @JoinColumn(name = "movie_show_id")
    private MovieShow movieShow;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

	public Booking() {
		super();
	}

	public Booking(int bookingId, LocalDate bookDate, LocalDate showDate, String state, String seatNos, int noOfSeats,
			float cost, float cancelCharges, MovieShow movieShow, User user) {
		super();
		this.bookingId = bookingId;
		this.bookDate = bookDate;
		this.showDate = showDate;
		this.state = state;
		this.seatNos = seatNos;
		this.noOfSeats = noOfSeats;
		this.cost = cost;
		this.cancelCharges = cancelCharges;
		this.movieShow = movieShow;
		this.user = user;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public LocalDate getBookDate() {
		return bookDate;
	}

	public void setBookDate(LocalDate bookDate) {
		this.bookDate = bookDate;
	}

	public LocalDate getShowDate() {
		return showDate;
	}

	public void setShowDate(LocalDate showDate) {
		this.showDate = showDate;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	

	public String getSeatNos() {
		return seatNos;
	}

	public void setSeatNos(String seatNos) {
		this.seatNos = seatNos;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public float getCancelCharges() {
		return cancelCharges;
	}

	public void setCancelCharges(float cancelCharges) {
		this.cancelCharges = cancelCharges;
	}

	public MovieShow getMovieShow() {
		return movieShow;
	}

	public void setMovieShow(MovieShow movieShow) {
		this.movieShow = movieShow;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
 
}

