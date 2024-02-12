package com.ticketbooking.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.ticketbooking.dto.SeatDTO;
import com.ticketbooking.entities.Theatre;
import com.ticketbooking.services.TheatreService;

import jakarta.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api/theatres")
@Validated
public class TheatreController {

    @Autowired
    private TheatreService theatreService;

    @PostMapping("/seats")
    public ResponseEntity<?> saveTheatreSeats(@RequestBody SeatDTO seatDTO) {
        theatreService.saveCapacity(seatDTO);
        return ResponseEntity.ok().body("Theatre seats capacity saved successfully");
    }

    @DeleteMapping("/seats/{id}")
    public ResponseEntity<?> deleteSeat(@PathVariable("id") int id) {
        theatreService.deleteSeat(id);
        return ResponseEntity.ok("Seat deleted successfully");
    }

    @PostMapping
    public ResponseEntity<?> saveTheatre(@Valid @RequestBody Theatre theatre) {
    	
//    	if (theatreService.isTheatreNameExists(theatre.getTheatreName()) && theatreService.isTheatreCityExists(theatre.getTheatreCity())){
//        	Map<String, String> error = new HashMap<>();
//            error.put("theatreName", "theatre with this theatre name and city already exists");
//            return ResponseEntity.badRequest().body(error);
//        }

        theatreService.saveTheatre(theatre);
        return ResponseEntity.ok().body("Theatre saved successfully");
    }

    @GetMapping
    public ResponseEntity<?> listAllTheatres() {
        return ResponseEntity.ok(theatreService.listAllTheatres());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTheatre(@PathVariable("id") int id) {
        theatreService.deleteTheatre(id);
        return ResponseEntity.ok("Theatre deleted successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findTheatreDetails(@PathVariable("id") int id) {
        return ResponseEntity.ok().body(theatreService.findTheatreById(id));
    }

//    @PutMapping("/update")
//    public ResponseEntity<?> updateTheatre(@RequestBody TheatreDTO theatreDTO) {
//        theatreService.updateTheatre(theatreDTO);
//        return ResponseEntity.ok("Theatre updated successfully");
//    }
}
