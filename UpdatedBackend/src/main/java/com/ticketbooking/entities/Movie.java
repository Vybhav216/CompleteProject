//package com.ticketbooking.entities;
// 
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
// 
// 
//@Entity
//public class Movie {
// 
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int movieId;
// 
//    @Column(nullable = false)
//    private String movieName;
//    private String movieGenre;
//    private String movieHours;
//    private String movieLanguage;
//    private int year;
// 
//    @Column(length = 200)
//    private String movieDescription;
//	/*
//	 * @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL) private
//	 * List<Booking> bookingList;
//	 * 
//	 * @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL) private
//	 * List<Ticket> tickets;
//	 * 
//	 * @ManyToOne
//	 * 
//	 * @JoinColumn(name = "theatreId") // Assuming you have a column named
//	 * "theatre_id" in Movie private Theatre theatre;
//	 */
// 
//	public Movie() {
//		super();
//	}
// 
//	
// 
//	public Movie(int movieId, String movieName, String movieGenre, String movieHours, String movieLanguage, int year,
//			String movieDescription) {
//		super();
//		this.movieId = movieId;
//		this.movieName = movieName;
//		this.movieGenre = movieGenre;
//		this.movieHours = movieHours;
//		this.movieLanguage = movieLanguage;
//		this.year = year;
//		this.movieDescription = movieDescription;
//	}
// 
// 
//	public int getMovieId() {
//		return movieId;
//	}
// 
//	public void setMovieId(int movieId) {
//		this.movieId = movieId;
//	}
// 
//	public String getMovieName() {
//		return movieName;
//	}
// 
//	public void setMovieName(String movieName) {
//		this.movieName = movieName;
//	}
// 
//	public String getMovieGenre() {
//		return movieGenre;
//	}
// 
//	public void setMovieGenre(String movieGenre) {
//		this.movieGenre = movieGenre;
//	}
// 
//	public String getMovieHours() {
//		return movieHours;
//	}
// 
//	public void setMovieHours(String movieHours) {
//		this.movieHours = movieHours;
//	}
// 
//	public String getMovieLanguage() {
//		return movieLanguage;
//	}
// 
//	public void setMovieLanguage(String movieLanguage) {
//		this.movieLanguage = movieLanguage;
//	}
// 
//	public String getMovieDescription() {
//		return movieDescription;
//	}
// 
//	public void setMovieDescription(String movieDescription) {
//		this.movieDescription = movieDescription;
//	}
// 
// 
//	public int getYear() {
//		return year;
//	}
// 
// 
//	public void setYear(int year) {
//		this.year = year;
//	}
// 
//    
//}















































package com.ticketbooking.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int movieId;
	@Column(nullable = false)
	private String movieName;
	private String poster;
	private String actor;
	private String actress;
	private String director;
	private String description;
	private int year;
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getActress() {
		return actress;
	}
	public void setActress(String actress) {
		this.actress = actress;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	
	
}