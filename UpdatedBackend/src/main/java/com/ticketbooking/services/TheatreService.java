package com.ticketbooking.services;

import java.util.List;

import com.ticketbooking.dto.SeatDTO;
import com.ticketbooking.entities.Theatre;
import com.ticketbooking.globalexception.InvalidEntityException;

public interface TheatreService {

   // void saveSeat(SeatDTO seatDTO) throws InvalidEntityException;
	
	void saveCapacity(SeatDTO seatDTO);

    void deleteSeat(int id) throws InvalidEntityException;

    void saveTheatre(Theatre theatre) throws InvalidEntityException;

    List<Theatre> listAllTheatres() throws InvalidEntityException;

    Theatre findTheatreById(int id) throws InvalidEntityException;

    //void updateTheatre(TheatreDTO theatreDTO) throws InvalidEntityException;

    void deleteTheatre(int id) throws InvalidEntityException;

    Theatre findById(int theatreId);
    
//    boolean isTheatreCityExists(String theatreCity);
//    
//    boolean isTheatreNameExists (String theatreName);
}
