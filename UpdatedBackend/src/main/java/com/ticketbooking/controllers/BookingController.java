package com.ticketbooking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.ticketbooking.entities.Booking;
import com.ticketbooking.dto.BookingDTO;
import com.ticketbooking.dto.MovieShowCheckDTO;
import com.ticketbooking.services.BookingService;
import jakarta.validation.Valid;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/bookings")
//@Validated
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController(@Qualifier("bookingServiceImpl") BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public ResponseEntity<?> saveBooking(@RequestBody BookingDTO bookingDTO) {
		/*
		 * if (bookingService.isMovieShowExists(booking.getMovieShow()) &&
		 * bookingService.isSeatNoExists(booking.getSeatNo())) { Map<String, String>
		 * error = new HashMap<>(); error.put("Booking Exists",
		 * "The Seats are not available"); return
		 * ResponseEntity.badRequest().body(error); }
		 */
        bookingService.save(bookingDTO);
        return ResponseEntity.ok().body("Booking saved successfully");
    }

    @GetMapping
    public ResponseEntity<?> listAllBookings(@RequestParam(value = "userid", required = false) Integer userid) {
        if (userid != null) {
            List<BookingDTO> userBookings = bookingService.allUserBookingList(userid);
            return ResponseEntity.ok(userBookings);
        } else {
            List<BookingDTO> allBookings = bookingService.getBookingList();
            return ResponseEntity.ok(allBookings);
        }
    }
    
    
	/*
	 * @GetMapping public ResponseEntity<?> listall(@RequestParam(value = "userid",
	 * required = false) Integer userid){ if(userid!=null) return
	 * ResponseEntity.ok(bookingService.allUserBookingList(userid)); return
	 * ResponseEntity.ok(bookingService.listall()); }
	 */
    
    
    
    
    

    @DeleteMapping("/{id}")
    public ResponseEntity<?> cancelBooking(@PathVariable("id") int id) {
        bookingService.delete(id);
        return ResponseEntity.ok("Booking canceled successfully");
    }

//    @GetMapping("{id}")
//    public ResponseEntity<?> findBookingDetails(@PathVariable("id") int id) {
//        BookingDTO bookingDTO = bookingService.findById(id);
//        return ResponseEntity.ok(bookingDTO);
//    }
    
    @GetMapping("check")
    public ResponseEntity<?> findByShow(MovieShowCheckDTO dto){
        return ResponseEntity.ok().body(bookingService.allOccupiedBooking(dto));
    }
}
