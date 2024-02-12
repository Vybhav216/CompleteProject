package com.ticketbooking.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.ticketbooking.dto.MovieShowDTO;
import com.ticketbooking.dto.SearchDTO;
import com.ticketbooking.entities.MovieShow;
import com.ticketbooking.entities.Theatre;
import com.ticketbooking.globalexception.InvalidEntityException;

public interface MovieShowService {

    void save(MovieShowDTO movieShowDTO) throws InvalidEntityException;

    List<MovieShowDTO> listAll() throws InvalidEntityException;

    List<MovieShowDTO> todayShows() throws InvalidEntityException;

    MovieShowDTO findById(int id) throws InvalidEntityException;

    void deleteMovieShow(int id) throws InvalidEntityException;

    List<MovieShowDTO> findByDate(String date) throws InvalidEntityException;

    List<MovieShowDTO> findAllWithSpec(Specification<MovieShow> spec) throws InvalidEntityException;

	List<MovieShowDTO> getMovieShowsByDate(LocalDate date);

	boolean isTheatreExists(Theatre theatre);

	boolean isSlotExists(int slot);

	List<MovieShow> searchShows(SearchDTO searchDTO);
}
