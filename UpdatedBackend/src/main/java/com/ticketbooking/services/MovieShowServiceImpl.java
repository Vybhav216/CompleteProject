package com.ticketbooking.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ticketbooking.dto.MovieShowDTO;
import com.ticketbooking.dto.SearchDTO;
import com.ticketbooking.entities.MovieShow;
import com.ticketbooking.entities.Theatre;
import com.ticketbooking.repository.MovieShowRepository;

@Service
@Transactional
public class MovieShowServiceImpl implements MovieShowService {

    private final MovieShowRepository movieShowRepository;
    private final ModelMapper modelMapper;
    private final TheatreService theatreService;
    private final MovieService movieService;
    private final SearchSpecificationService searchSpecificationService;

    @Autowired
    public MovieShowServiceImpl(MovieShowRepository movieShowRepository, ModelMapper modelMapper,TheatreService theatreService,MovieService movieService,SearchSpecificationService searchSpecificationService) {
        this.movieShowRepository = movieShowRepository;
        this.modelMapper = modelMapper;
		this.theatreService = theatreService;
		this.movieService = movieService;
		this.searchSpecificationService = searchSpecificationService;
        configureModelMapper();  // Call the method to configure ModelMapper
    }

    // Method to configure ModelMapper for date conversion
    private void configureModelMapper() {
        modelMapper.addConverter(context -> {
            if (context.getSource() != null && context.getSource() instanceof String) {
                String dateString = (String) context.getSource();
                return dateString.isEmpty() ? null : LocalDate.parse(dateString);
            }
            return null;
        }, String.class, LocalDate.class);
    }

    @Override
    public void save(MovieShowDTO movieShowDTO) {
    	MovieShow movieShow = new MovieShow();
    	BeanUtils.copyProperties(movieShowDTO, movieShow);
    	movieShow.setTheatre(theatreService.findById(movieShowDTO.getTheatreId()));
    	movieShow.setMovie(movieService.findById(movieShowDTO.getMovieId()));
        movieShowRepository.save(movieShow);
    }

    @Override
    public List<MovieShowDTO> listAll() {
        List<MovieShow> movieShows = movieShowRepository.findAll();
        return movieShows.stream()
                .map(movieShow -> modelMapper.map(movieShow, MovieShowDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<MovieShowDTO> todayShows() {
        LocalDate currentDate = LocalDate.now();
        List<MovieShow> todayShows = movieShowRepository.todaysShow(currentDate);
        return todayShows.stream()
                .map(movieShow -> modelMapper.map(movieShow, MovieShowDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public MovieShowDTO findById(int id) {
        MovieShow movieShow = movieShowRepository.getById(id);
        return modelMapper.map(movieShow, MovieShowDTO.class);
    }

    @Override
    public void deleteMovieShow(int id) {
        movieShowRepository.deleteById(id);
    }

    @Override
    public List<MovieShowDTO> findByDate(String date) {
        List<MovieShow> movieShows = movieShowRepository.findByDate(date);
        return movieShows.stream()
                .map(movieShow -> modelMapper.map(movieShow, MovieShowDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<MovieShowDTO> findAllWithSpec(Specification<MovieShow> spec) {
        List<MovieShow> movieShows = movieShowRepository.findAll(spec);
        return movieShows.stream()
                .map(movieShow -> modelMapper.map(movieShow, MovieShowDTO.class))
                .collect(Collectors.toList());
    }
    public List<MovieShowDTO> getMovieShowsByDate(LocalDate date) {
        List<MovieShow> movieShows = movieShowRepository.findByMovieShowStartDateBetween(date, date);
        return movieShows.stream()
                .map(movieShow -> modelMapper.map(movieShow, MovieShowDTO.class))
                .collect(Collectors.toList());
    }
    private MovieShow convertToEntity(MovieShowDTO movieShowDTO) {
        return modelMapper.map(movieShowDTO, MovieShow.class);
    }

	@Override
	public boolean isTheatreExists(Theatre theatre) {
		return movieShowRepository.existsByTheatre(theatre);
	}

	@Override
	public boolean isSlotExists(int slot) {
		return movieShowRepository.existsBySlot(slot);
	}

	@Override
	public List<MovieShow> searchShows(SearchDTO searchDTO) {
		return movieShowRepository.findAll(searchSpecificationService.getfilteredShows(searchDTO));
	}
}
