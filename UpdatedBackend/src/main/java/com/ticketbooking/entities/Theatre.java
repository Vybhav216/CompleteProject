package com.ticketbooking.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
public class Theatre {
	
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int theatreId;
//
//    @Column(nullable = false)
//    @NotBlank(message = "Theatre name cannot be blank.")
//    private String theatreName;
//
//    @Column(nullable = false)
//    @NotBlank(message = "Theatre city cannot be blank.")
//    private String theatreCity;
//
//    @Column(nullable = false)
//    @Positive(message = "Theatre capacity must be a positive integer.")
//    private int theatreCapacity;
//
//    @OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL)
//    private List<Seat> seats;
//
//    @Column(nullable = false)
//    @NotBlank(message = "Manager name cannot be blank.")
//    private String managerName;
//
//    @Column(nullable = false)
//    @NotBlank(message = "Manager contact cannot be blank.")
//    private String managerContact;
//
//
//	public int getTheatreId() {
//		return theatreId;
//	}
//
//	public void setTheatreId(int theatreId) {
//		this.theatreId = theatreId;
//	}
//
//	public String getTheatreName() {
//		return theatreName;
//	}
//
//	public void setTheatreName(String theatreName) {
//		this.theatreName = theatreName;
//	}
//
//	public String getTheatreCity() {
//		return theatreCity;
//	}
//
//	public void setTheatreCity(String theatreCity) {
//		this.theatreCity = theatreCity;
//	}
//
//	public int getTheatreCapacity() {
//		return theatreCapacity;
//	}
//
//	public void setTheatreCapacity(int theatreCapacity) {
//		this.theatreCapacity = theatreCapacity;
//	}
//
//	public List<Seat> getSeat() {
//		return seats;
//	}
//
//	public void setSeat(List<Seat> seats) {
//		seats = seats;
//	}
//
//	public String getManagerName() {
//		return managerName;
//	}
//
//	public void setManagerName(String managerName) {
//		this.managerName = managerName;
//	}
//
//	public String getManagerContact() {
//		return managerContact;
//	}
//
//	public void setManagerContact(String managerContact) {
//		this.managerContact = managerContact;
//	}
//	
//
//	public Theatre() {
//    	
//    }
//
//	public Theatre(int theatreId, String theatreName, String theatreCity, List<com.ticketbooking.entities.Seat> seats,
//			String managerName, String managerContact) {
//		super();
//		this.theatreId = theatreId;
//		this.theatreName = theatreName;
//		this.theatreCity = theatreCity;
//		this.seats = seats;
//		this.managerName = managerName;
//		this.managerContact = managerContact;
//	}
//
//	public Theatre(String theatreName, String theatreCity, int theatreCapacity, String managerName,
//			String managerContact) {
//		super();
//		this.theatreName = theatreName;
//		this.theatreCity = theatreCity;
//		this.theatreCapacity = theatreCapacity;
//		this.managerName = managerName;
//		this.managerContact = managerContact;
//	}
//	
	
	
	
	
	
	
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int theatreId;
	private String theatreDesc;
	private int theatrecapacity;
	private String theatreCity;
	private int managerNum;
	@OneToMany	
	private List<Seat> seats;
	public String getTheatreCity() {
		return theatreCity;
	}
	public void setTheatreCity(String theatreCity) {
		this.theatreCity = theatreCity;
	}
	public int getManagerNum() {
		return managerNum;
	}
	public void setManagerNum(int managerNum) {
		this.managerNum = managerNum;
	}
	public int getTheatreId() {
		return theatreId;
	}
	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
	}
	public String getTheatreDesc() {
		return theatreDesc;
	}
	public void setTheatreDesc(String theatreDesc) {
		this.theatreDesc = theatreDesc;
	}
	public int getTheatrecapacity() {
		return theatrecapacity;
	}
	public void setTheatrecapacity(int theatrecapacity) {
		this.theatrecapacity = theatrecapacity;
	}
	public List<Seat> getSeats() {
		return seats;
	}
	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

	
	
	
	

	
	
	
    
}
