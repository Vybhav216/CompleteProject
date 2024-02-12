package com.ticketbooking.services;

import java.util.List;

import com.ticketbooking.dto.MovieShowCheckDTO;
import com.ticketbooking.dto.BookingDTO;  // Import the BookingDTO
import com.ticketbooking.entities.Booking;
import com.ticketbooking.entities.MovieShow;
import com.ticketbooking.globalexception.InvalidEntityException;

public interface BookingService {

    BookingDTO findById(int id) throws InvalidEntityException;

    void save(BookingDTO booking)throws InvalidEntityException;

    List<BookingDTO> getBookingList()throws InvalidEntityException;

    List<BookingDTO> allUserBookingList(int id)throws InvalidEntityException;

    List<BookingDTO> allOccupiedBookingList(MovieShowCheckDTO dto)throws InvalidEntityException;

    void delete(int id)throws InvalidEntityException;

	boolean isMovieShowExists(MovieShow movieShow);

	boolean isSeatNoExists(String seatNo);

	List<Booking> listall();

	List<Booking> allOccupiedBooking(MovieShowCheckDTO dto);
}
