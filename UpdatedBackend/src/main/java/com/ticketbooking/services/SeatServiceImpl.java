//package com.ticketbooking.services;
//
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.ticketbooking.entities.Seat;
//import com.ticketbooking.dto.SeatDTO;
//
//@Service
//@Transactional
//public class SeatServiceImpl implements SeatService {
//
//    private final ModelMapper modelMapper;
//
//    @Autowired
//    public SeatServiceImpl(ModelMapper modelMapper) {
//        this.modelMapper = modelMapper;
//    }
//
//    @Override
//    public SeatDTO bookSeat(SeatDTO seatDTO) {
//        // Implement logic for booking seat, update seat status, etc.
//        // You can use seatRepository to interact with the database if needed
//        Seat bookedSeat = convertToEntity(seatDTO);
//        // Perform the necessary operations for booking the seat
//
//        return convertToDTO(bookedSeat);
//    }
//
//    @Override
//    public SeatDTO cancelSeatBooking(SeatDTO seatDTO) {
//        // Implement logic for canceling seat booking, update seat status, etc.
//        // You can use seatRepository to interact with the database if needed
//        Seat canceledSeat = convertToEntity(seatDTO);
//        // Perform the necessary operations for canceling the seat booking
//
//        return convertToDTO(canceledSeat);
//    }
//
//    @Override
//    public SeatDTO blockSeat(SeatDTO seatDTO) {
//        // Implement logic for blocking seat, update seat status, etc.
//        // You can use seatRepository to interact with the database if needed
//        Seat blockedSeat = convertToEntity(seatDTO);
//        // Perform the necessary operations for blocking the seat
//
//        return convertToDTO(blockedSeat);
//    }
//
//    // Additional methods or helper methods as needed
//
//    private SeatDTO convertToDTO(Seat seat) {
//        return modelMapper.map(seat, SeatDTO.class);
//    }
//
//    private Seat convertToEntity(SeatDTO seatDTO) {
//        return modelMapper.map(seatDTO, Seat.class);
//    }
//}
