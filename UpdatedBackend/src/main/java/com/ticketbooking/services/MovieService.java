package com.ticketbooking.services;
 
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ticketbooking.dto.MovieDTO;
import com.ticketbooking.entities.Movie;
import com.ticketbooking.globalexception.InvalidEntityException;
 
public interface MovieService {
 
//	Movie convertToEntity(MovieDTO movieDTO)throws InvalidEntityException;
//	
//    void save(Movie movie,MultipartFile photo)throws InvalidEntityException;
// 
//    List<MovieDTO> listAll()throws InvalidEntityException;
// 
//    MovieDTO findById(int id)throws InvalidEntityException;
// 
//    void deleteMovie(int id)throws InvalidEntityException;
//    
//    boolean isMovieNameExists(String movieName);
//    
//    MovieDTO findByMovieName(String movieName);
	
	
	
	
	void save(Movie movie,MultipartFile photo)throws InvalidEntityException;
	
	List<Movie> listall();
	
	Movie findById(int id);
	
	void deleteMovie(int id);
	
	boolean isMovieNameExists(String movieName);
	
	
	
}