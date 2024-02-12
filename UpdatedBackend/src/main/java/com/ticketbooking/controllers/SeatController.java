//package com.ticketbooking.controllers;
//
//import com.ticketbooking.dto.SeatDTO;
//import com.ticketbooking.services.SeatService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@CrossOrigin
//@RestController
//@RequestMapping("/api/seats")
//public class SeatController {
//
//    private final SeatService seatService;
//
//    @Autowired
//    public SeatController(SeatService seatService) {
//        this.seatService = seatService;
//    }
//
//    @PostMapping("/book")
//    public ResponseEntity<SeatDTO> bookSeat(@RequestBody SeatDTO seatDTO) {
//        SeatDTO bookedSeat = seatService.bookSeat(seatDTO);
//        return new ResponseEntity<>(bookedSeat, HttpStatus.CREATED);
//    }
//
//    @PostMapping("/cancel")
//    public ResponseEntity<SeatDTO> cancelSeatBooking(@RequestBody SeatDTO seatDTO) {
//        SeatDTO canceledSeat = seatService.cancelSeatBooking(seatDTO);
//        return new ResponseEntity<>(canceledSeat, HttpStatus.OK);
//    }
//
//    @PostMapping("/block")
//    public ResponseEntity<SeatDTO> blockSeat(@RequestBody SeatDTO seatDTO) {
//        SeatDTO blockedSeat = seatService.blockSeat(seatDTO);
//        return new ResponseEntity<>(blockedSeat, HttpStatus.OK);
//    }
//
//    // Additional methods or endpoints as needed
//
//}
