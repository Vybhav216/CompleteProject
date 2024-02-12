package com.ticketbooking.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ticketbooking.entities.Booking;
import com.ticketbooking.entities.MovieShow;
import com.ticketbooking.entities.User;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Integer>{
	
	List<Booking> findByUser(User user);
    List<Booking> findByMovieShowMovieShowIdAndShowDate(int movieShowId, LocalDate Date);
    boolean existsByMovieShow(MovieShow movieShow);
    boolean existsBySeatNos(String seatNos);
}

