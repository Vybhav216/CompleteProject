package com.ticketbooking.dto;
 
//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.NotNull;
// 
//public class MovieDTO {
// 
//    private int movieId;
//    @NotBlank(message = "Movie name cannot be blank")
//    private String movieName;
//    @NotBlank(message = "Movie genre cannot be blank")
//    private String movieGenre;
//    @NotBlank(message = "Movie hours cannot be blank")
//    private String movieHours;
//    @NotBlank(message = "Movie Language cannot be blank")
//    private String movieLanguage;
//    @NotNull(message = "Movie year cannot be blank")
//    private int year;
//    @NotBlank(message = "Movie Descryption cannot be blank")
//    private String movieDescription;
// 
//    public MovieDTO() {
//        // Default constructor
//    }
// 
//    public MovieDTO(int movieId, String movieName, String movieGenre, String movieHours, String movieLanguage,
//                    int year, String movieDescription) {
//        this.movieId = movieId;
//        this.movieName = movieName;
//        this.movieGenre = movieGenre;
//        this.movieHours = movieHours;
//        this.movieLanguage = movieLanguage;
//        this.year = year;
//        this.movieDescription = movieDescription;
//    }
// 
//    // Getters and setters for all fields
// 
//    public int getMovieId() {
//        return movieId;
//    }
// 
//    public void setMovieId(int movieId) {
//        this.movieId = movieId;
//    }
// 
//    public String getMovieName() {
//        return movieName;
//    }
// 
//    public void setMovieName(String movieName) {
//        this.movieName = movieName;
//    }
// 
//    public String getMovieGenre() {
//        return movieGenre;
//    }
// 
//    public void setMovieGenre(String movieGenre) {
//        this.movieGenre = movieGenre;
//    }
// 
//    public String getMovieHours() {
//        return movieHours;
//    }
// 
//    public void setMovieHours(String movieHours) {
//        this.movieHours = movieHours;
//    }
// 
//    public String getMovieLanguage() {
//        return movieLanguage;
//    }
// 
//    public void setMovieLanguage(String movieLanguage) {
//        this.movieLanguage = movieLanguage;
//    }
// 
//    public int getYear() {
//        return year;
//    }
// 
//    public void setYear(int year) {
//        this.year = year;
//    }
// 
//    public String getMovieDescription() {
//        return movieDescription;
//    }
// 
//    public void setMovieDescription(String movieDescription) {
//        this.movieDescription = movieDescription;
//    }
//}


































import org.springframework.web.multipart.MultipartFile;

import com.ticketbooking.entities.Movie;

public class MovieDTO extends Movie {

	private MultipartFile photo;

	public MultipartFile getPhoto() {
		return photo;
	}

	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}
	
	
}