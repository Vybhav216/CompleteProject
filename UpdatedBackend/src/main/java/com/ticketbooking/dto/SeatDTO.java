package com.ticketbooking.dto;

import com.ticketbooking.entities.Seat;

public class SeatDTO extends Seat{

    private int seatTypeId;
    private int theatreId; 

    public SeatDTO() {
        // Default constructor
    }

    public SeatDTO(int seatTypeId,int theatreId) {
        this.seatTypeId = seatTypeId;
        //this.seatCount = seatCount;
        this.theatreId = theatreId;
    }

    public int getSeatTypeId() {
        return seatTypeId;
    }

    public void setSeatTypeId(int seatTypeId) {
        this.seatTypeId = seatTypeId;
    }

//    public int getSeatCount() {
//        return seatCount;
//    }
//
//    public void setSeatCount(int seatCount) {
//        this.seatCount = seatCount;
//    }

    public int getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(int theatreId) {
        this.theatreId = theatreId;
    }

}
