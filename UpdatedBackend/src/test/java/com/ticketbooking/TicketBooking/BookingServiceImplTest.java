//package com.ticketbooking.TicketBooking;
//
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.Mockito.*;
//
//import org.junit.jupiter.api.Test;
//import org.modelmapper.ModelMapper;
//
//import com.ticketbooking.dto.BookingDTO;
//import com.ticketbooking.dto.MovieShowCheckDTO;
//import com.ticketbooking.entities.Booking;
//import com.ticketbooking.entities.User;
//import com.ticketbooking.repository.BookingRepository;
//import com.ticketbooking.services.BookingServiceImpl;
//import com.ticketbooking.services.BookingServiceImplForTesting;
//import com.ticketbooking.services.MovieShowService;
//import com.ticketbooking.services.UserService;
//
//import java.time.LocalDate;
//import java.util.Collections;
//import java.util.List;
//import java.util.Optional;
//
//public class BookingServiceImplTest {
//
//    private final BookingRepository bookingRepository = mock(BookingRepository.class);
//    private final MovieShowService movieShowService = mock(MovieShowService.class);
//    private final UserService userService = mock(UserService.class);
//    private final ModelMapper modelMapper = mock(ModelMapper.class);
//
//    private final BookingServiceImplForTesting bookingService = new BookingServiceImplForTesting(
//            bookingRepository, movieShowService, userService, modelMapper);
//
//    @Test
//    public void testSaveBooking() {
//        Booking booking = new Booking();
//        bookingService.save(booking);
//        verify(bookingRepository, times(1)).save(booking);
//    }
//
//
//    @Test
//    public void testDelete() {
//        int bookingId = 1;
//        bookingService.delete(bookingId);
//
//        verify(bookingRepository, times(1)).deleteById(bookingId);
//    }
//
//    @Test
//    public void testSaveBookingWithNullBooking() {
//        assertThrows(IllegalArgumentException.class, () -> {
//            bookingService.save(null);
//        });
//        // Ensure that the save method is not called when the input is null
//        verify(bookingRepository, never()).save(any());
//    }
//
//    @Test
//    public void testDeleteWithInvalidBookingId() {
//        int invalidBookingId = -1;
//        assertThrows(IllegalArgumentException.class, () -> {
//            bookingService.delete(invalidBookingId);
//        });
//        // Ensure that the deleteById method is not called with an invalid bookingId
//        verify(bookingRepository, never()).deleteById(invalidBookingId);
//    }
//}
