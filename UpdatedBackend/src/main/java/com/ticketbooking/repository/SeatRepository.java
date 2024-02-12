package com.ticketbooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ticketbooking.entities.Seat;
import com.ticketbooking.entities.Theatre;

@Repository
public interface SeatRepository extends JpaRepository<Seat,Integer>{
	List<Seat> findByTheatre(Theatre theatre);
}
