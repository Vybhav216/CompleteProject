package com.ticketbooking.services;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ticketbooking.dto.MovieShowCheckDTO;
import com.ticketbooking.dto.BookingDTO;
import com.ticketbooking.entities.Booking;
import com.ticketbooking.entities.MovieShow;
import com.ticketbooking.globalexception.InvalidEntityException;
import com.ticketbooking.repository.BookingRepository;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final MovieShowService movieShowService;
    private final UserService userService;
    private ModelMapper modelMapper;

    @Autowired
    public BookingServiceImpl(
            BookingRepository bookingRepository,
            MovieShowService movieShowService,
            UserService userService,
            ModelMapper modelMapper) {
        this.bookingRepository = bookingRepository;
        this.movieShowService = movieShowService;
        this.userService = userService;
        this.modelMapper = modelMapper;
        
        
        
        // Configure ModelMapper for custom mapping
        this.modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT)  // Use STRICT matching strategy
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
        
		

    }

    @Override
    public void save(BookingDTO dto) {
        //bookingRepository.save(booking);
    	Booking bk=new Booking();
    	bk.setBookDate(LocalDate.now());
		bk.setShowDate(dto.getShowDate());
		bk.setNoOfSeats(dto.getNoOfSeats());
		bk.setSeatNos(IntStream.of(dto.getSeatNums())
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(", ")));
		bk.setCost(dto.getCost());
		bk.setMovieShow(movieShowService.findById(dto.getMovieShowId()));
		bk.setUser(userService.findById(dto.getUserId()));
		bk.setState("Confirmed");
		bookingRepository.save(bk);
    }
    @Override
    public List<BookingDTO> getBookingList() {
        List<Booking> bookings = bookingRepository.findAll();
        Type targetType = new TypeToken<List<BookingDTO>>() {}.getType();
        return modelMapper.map(bookings, targetType);
    }

    @Override
    public List<BookingDTO> allUserBookingList(int id) {
        List<Booking> bookings = bookingRepository.findByUser(userService.findById(id));
        Type targetType = new TypeToken<List<BookingDTO>>() {}.getType();
        return modelMapper.map(bookings, targetType);
    }
    
    
    
    public List<Booking> listall(){
		return bookingRepository.findAll();
	}

    @Override
    public BookingDTO findById(int id) throws InvalidEntityException {
        Booking booking = bookingRepository.getById(id);
        return modelMapper.map(booking, BookingDTO.class);
    }
    
    

    @Override
    public List<BookingDTO> allOccupiedBookingList(MovieShowCheckDTO movieShowCheckDTO) {
        List<Booking> bookings = bookingRepository.findByMovieShowMovieShowIdAndShowDate(
                movieShowCheckDTO.getMovieShowId(), movieShowCheckDTO.getDate());
        Type targetType = new TypeToken<List<BookingDTO>>() {}.getType();
        return modelMapper.map(bookings, targetType);
    }

    @Override
    public void delete(int id) {
        bookingRepository.deleteById(id);
    }

	@Override
	public boolean isMovieShowExists(MovieShow movieShow) {
		return bookingRepository.existsByMovieShow(movieShow);
	}

	@Override
	public boolean isSeatNoExists(String seatNos) {
		return bookingRepository.existsBySeatNos(seatNos);
	}

	@Override
	public List<Booking> allOccupiedBooking(MovieShowCheckDTO dto) {
	
		return bookingRepository.findByMovieShowMovieShowIdAndShowDate(dto.getMovieShowId(), dto.getDate());
	}
}
