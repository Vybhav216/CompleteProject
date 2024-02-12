//package com.ticketbooking.services;
//
//import org.modelmapper.ModelMapper;
//import org.modelmapper.TypeToken;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import com.ticketbooking.dto.MovieShowCheckDTO;
//import com.ticketbooking.dto.BookingDTO;
//import com.ticketbooking.entities.Booking;
//import com.ticketbooking.entities.MovieShow;
//import com.ticketbooking.repository.BookingRepository;
//
//import java.lang.reflect.Type;
//import java.util.List;
//
//@Service
//public class BookingServiceImplForTesting implements BookingService {
//
//    private final BookingRepository bookingRepository;
//    private final MovieShowService movieShowService;
//    private final UserService userService;
//    private ModelMapper modelMapper;
//
//    @Autowired
//    public BookingServiceImplForTesting(
//            BookingRepository bookingRepository,
//            MovieShowService movieShowService,
//            UserService userService,
//            ModelMapper modelMapper) {
//        this.bookingRepository = bookingRepository;
//        this.movieShowService = movieShowService;
//        this.userService = userService;
//        this.modelMapper = modelMapper;
//        
//    }
//
//    @Override
//    public void save(Booking booking) {
//        bookingRepository.save(booking);
//    }
//
//    @Override
//    public List<BookingDTO> getBookingList() {
//        List<Booking> bookings = bookingRepository.findAll();
//        Type targetType = new TypeToken<List<BookingDTO>>() {}.getType();
//        return modelMapper.map(bookings, targetType);
//    }
//
//    @Override
//    public List<BookingDTO> allUserBookingList(int id) {
//        List<Booking> bookings = bookingRepository.findByUser(userService.findById(id));
//        Type targetType = new TypeToken<List<BookingDTO>>() {}.getType();
//        return modelMapper.map(bookings, targetType);
//    }
//
//    @Override
//    public BookingDTO findById(int id) {
//        Booking booking = bookingRepository.getById(id);
//        return modelMapper.map(booking, BookingDTO.class);
//    }
//
//    @Override
//    public List<BookingDTO> allOccupiedBookingList(MovieShowCheckDTO movieShowCheckDTO) {
//        List<Booking> bookings = bookingRepository.findByMovieShowMovieShowIdAndShowDate(
//                movieShowCheckDTO.getMovieShowId(), movieShowCheckDTO.getDate());
//        Type targetType = new TypeToken<List<BookingDTO>>() {}.getType();
//        return modelMapper.map(bookings, targetType);
//    }
//
//    @Override
//    public void delete(int id) {
//        bookingRepository.deleteById(id);
//    }
//
//	@Override
//	public boolean isMovieShowExists(MovieShow movieShow) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean isSeatNoExists(String seatNo) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//}
//
