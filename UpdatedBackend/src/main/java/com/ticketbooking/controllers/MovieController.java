package com.ticketbooking.controllers;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.ticketbooking.dto.MovieDTO;
import com.ticketbooking.entities.Movie;
import com.ticketbooking.services.MovieService;
 
import jakarta.validation.Valid;
 
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/movies")
public class MovieController {
 
    @Autowired
    private MovieService movieService;
 
//    @PostMapping
//    public ResponseEntity<?> saveMovie(@RequestBody MovieDTO movieDTO) {
//        Movie movie = movieService.convertToEntity(movieDTO);
//        movieService.save(movie);
//        return ResponseEntity.ok().body("Movie saved successfully");
//    }
//    @PostMapping
//    public ResponseEntity<?> saveMovie(@Valid @RequestBody MovieDTO movieDTO, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            Map<String, String> errors = new HashMap<>();
//            for (FieldError error : bindingResult.getFieldErrors()) {
//                errors.put(error.getField(), error.getDefaultMessage());
//            }
//            return ResponseEntity.badRequest().body(errors);
//        }
//        if (movieService.isMovieNameExists(movieDTO.getMovieName())) {
//            Map<String, String> error = new HashMap<>();
//            error.put("movieName", "Movie with this name already exists");
//            return ResponseEntity.badRequest().body(error);
//        }
// 
//        Movie movie = movieService.convertToEntity(movieDTO);
//        movieService.save(movie);
//        return ResponseEntity.ok().body("Movie saved successfully");
//    }
//    @GetMapping("/name/{movieName}")
//    public ResponseEntity<?> findMovieByName(@PathVariable("movieName") String movieName) {
//        MovieDTO movieDTO = movieService.findByMovieName(movieName);
//        if (movieDTO != null) {
//            return ResponseEntity.ok(movieDTO);
//        } else {
//            //return ResponseEntity.notFound().build(); 
//        	return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Movie not found");
//        }
//    }
//
//
// 
//    @GetMapping
//    public ResponseEntity<List<MovieDTO>> listAllMovies() {
//        List<MovieDTO> movieDTOs = movieService.listAll();
//        return ResponseEntity.ok(movieDTOs);
//    }
// 
//    @DeleteMapping("{id}")
//    public ResponseEntity<?> deleteMovie(@PathVariable("id") int id) {
//        if (!(movieService.findById(id).equals(null))) {
//            movieService.deleteMovie(id);
//            return ResponseEntity.ok("Movie deleted successfully");
//        }else {  
//        	return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Movie not found"); 
//        }
//    }
//    @GetMapping("{id}")
//    public ResponseEntity<MovieDTO> findMovieDetails(@PathVariable("id") int id) {
//        MovieDTO movieDTO = movieService.findById(id);
//        return ResponseEntity.ok(movieDTO);
//    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @PostMapping
    public ResponseEntity<?> saveMovie(Movie movie,@RequestPart(required = false) MultipartFile photo){
    	
    	if (movieService.isMovieNameExists(movie.getMovieName())) {
            Map<String, String> error = new HashMap<>();
            error.put("movieName", "Movie with this name already exists");
            return ResponseEntity.badRequest().body(error);
        }
        movieService.save(movie,photo);
        return ResponseEntity.ok().body("Movie saved successfully");
    }

    @GetMapping
    public ResponseEntity<?> listall(){
        return ResponseEntity.ok(movieService.listall());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable("id") int id) {
        if (!(movieService.findById(id).equals(null))) {
            movieService.deleteMovie(id);
            return ResponseEntity.ok("Movie deleted successfully");
        }else {  
        	return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Movie not found"); 
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findDetails(@PathVariable("id") int id){
        return ResponseEntity.ok().body(movieService.findById(id));
    }
    
}