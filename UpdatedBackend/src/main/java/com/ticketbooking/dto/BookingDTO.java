package com.ticketbooking.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ticketbooking.entities.Booking;


public class BookingDTO extends Booking {

    //private int bookingId;
//    private LocalDate bookDate;
//    private LocalDate showDate;
//    private String state;
//    private String seatNo;
//    private int noOfSeats;
//    private float cost;
//    private float cancelCharges;
    @JsonProperty("movieShowId")
    private Integer movieShowId;  // ID of the associated MovieShow
    @JsonProperty("userId")
    private Integer userId;       // ID of the associated User
    private int[] seatNums;

//    public BookingDTO() {
//        // Default constructor
//    }
//
//    public BookingDTO(int bookingId, LocalDate bookDate, LocalDate showDate, String state, String seatNo, int noOfSeats,
//                      float cost, float cancelCharges, int movieShowId, int userId) {
//        this.bookingId = bookingId;
//        this.bookDate = bookDate;
//        this.showDate = showDate;
//        this.state = state;
//        this.seatNo = seatNo;
//        this.noOfSeats = noOfSeats;
//        this.cost = cost;
//        this.cancelCharges = cancelCharges;
//        this.movieShowId = movieShowId;
//        this.userId = userId;
//    }

    // Getters and setters for all fields
//
//    public int getBookingId() {
//        return bookingId;
//    }
//
//    public void setBookingId(int bookingId) {
//        this.bookingId = bookingId;
//    }
//
//    public LocalDate getBookDate() {
//        return bookDate;
//    }
//
//    public void setBookDate(LocalDate bookDate) {
//        this.bookDate = bookDate;
//    }
//
//    public LocalDate getShowDate() {
//        return showDate;
//    }
//
//    public void setShowDate(LocalDate showDate) {
//        this.showDate = showDate;
//    }
//
//    public String getState() {
//        return state;
//    }
//
//    public void setState(String state) {
//        this.state = state;
//    }
//
//    public String getSeatNo() {
//        return seatNo;
//    }
//
//    public void setSeatNo(String seatNo) {
//        this.seatNo = seatNo;
//    }
//
//    public int getNoOfSeats() {
//        return noOfSeats;
//    }
//
//    public void setNoOfSeats(int noOfSeats) {
//        this.noOfSeats = noOfSeats;
//    }
//
//    public float getCost() {
//        return cost;
//    }
//
//    public void setCost(float cost) {
//        this.cost = cost;
//    }
//
//    public float getCancelCharges() {
//        return cancelCharges;
//    }
//
//    public void setCancelCharges(float cancelCharges) {
//        this.cancelCharges = cancelCharges;
//    }

    

	public Integer getMovieShowId() {
		return movieShowId;
	}

	public void setMovieShowId(Integer movieShowId) {
		this.movieShowId = movieShowId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public int[] getSeatNums() {
		return seatNums;
	}

	public void setSeatNums(int[] seatNums) {
		this.seatNums = seatNums;
	}

	
}
