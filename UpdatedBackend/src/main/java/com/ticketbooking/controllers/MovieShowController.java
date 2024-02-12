package com.ticketbooking.controllers;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.ticketbooking.dto.MovieShowDTO;
import com.ticketbooking.dto.SearchDTO;
import com.ticketbooking.entities.MovieShow;
import com.ticketbooking.services.MovieShowService;

import jakarta.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api/movieShows")
@Validated
public class MovieShowController {

    @Autowired
    private MovieShowService movieShowService;

    @PostMapping
    public ResponseEntity<?> saveMovieShow(@RequestBody MovieShowDTO movieShowDTO) {
		/*
		 * if (movieShowService.isTheatreExists(movieShow.getTheatre()) &&
		 * movieShowService.isSlotExists(movieShow.getSlot())) { Map<String, String>
		 * error = new HashMap<>(); error.put("Show Exists",
		 * "The Slot is not available"); return ResponseEntity.badRequest().body(error);
		 * }
		 */
    	
        movieShowService.save(movieShowDTO);
        return ResponseEntity.ok().body("Movie show saved successfully");
    }

    @GetMapping
    public ResponseEntity<?> listAllMovieShows() {
        return ResponseEntity.ok(movieShowService.listAll());
    }

    @GetMapping("todays")
    public ResponseEntity<?> todayMovieShows() {
        return ResponseEntity.ok(movieShowService.todayShows());
    }
    @GetMapping("/byDate")
    public ResponseEntity<?> getMovieShowsByDate(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        List<MovieShowDTO> movieShows = movieShowService.getMovieShowsByDate(date);

        if (movieShows.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(movieShows);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMovieShow(@PathVariable("id") int id) {
        movieShowService.deleteMovieShow(id);
        return ResponseEntity.ok("Movie show deleted successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findMovieShowDetails(@PathVariable("id") int id) {
        return ResponseEntity.ok().body(movieShowService.findById(id));
    }
    @GetMapping("search")
    public ResponseEntity<?> searchShows(SearchDTO searchDTO){
    	return ResponseEntity.ok(movieShowService.searchShows(searchDTO));
    }
}
