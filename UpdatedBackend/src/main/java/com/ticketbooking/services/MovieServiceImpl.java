package com.ticketbooking.services;
 
import java.util.List;
import java.util.Optional;
 
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ticketbooking.dto.MovieDTO;
import com.ticketbooking.entities.Movie;
import com.ticketbooking.globalexception.InvalidEntityException;
import com.ticketbooking.repository.MovieRepository;
import com.ticketbooking.utils.StorageService;

import java.util.stream.Collectors;
 
@Service
public class MovieServiceImpl implements MovieService {
 
//	@Autowired private StorageService storage;
//    private final MovieRepository movieRepository;
//    private final ModelMapper modelMapper;
// 
//    @Autowired
//    public MovieServiceImpl(MovieRepository movieRepository, ModelMapper modelMapper) {
//        this.movieRepository = movieRepository;
//        this.modelMapper = modelMapper;
//    }
// 
////    @Override
////    public void save(Movie movie) {
////        movieRepository.save(movie);
////    }
//    
//    
//    
//    
//    @Override
//    public void save(Movie movie, MultipartFile photo) {
//		System.out.println("movie id"+movie.getMovieId());
//		if(movie.getMovieId()==0) {
//			String poster=storage.store(photo);
//			movie.setPoster(poster);
//		}else {
//			if(photo!=null) {
//				String poster=storage.store(photo);
//				movie.setPoster(poster);				
//			}else {
//				Movie mm=movieRepository.findById(movie.getMovieId()).get();
//				movie.setPoster(mm.getPoster());
//			}
//		}
//		movieRepository.save(movie);
//	}
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
// 
//    @Override
//    public List<MovieDTO> listAll() {
//        List<Movie> movies = movieRepository.findAll();
//        return movies.stream()
//                .map(movie -> modelMapper.map(movie, MovieDTO.class))
//                .collect(Collectors.toList());
//    }
// 
//    @Override
//    public MovieDTO findById(int id) {
//        Movie movie = movieRepository.getById(id);
//        return modelMapper.map(movie, MovieDTO.class);
//    }
//    @Override
//    public MovieDTO findByMovieName(String movieName) {
//        Optional<Movie> movie = movieRepository.findByMovieName(movieName);
//        return movie.map(m -> modelMapper.map(m, MovieDTO.class)).orElse(null);
//    }
// 
//    @Override
//    public void deleteMovie(int id) {
//        movieRepository.delete(movieRepository.getById(id));
//    }
// 
//    @Override
//    public Movie convertToEntity(MovieDTO movieDTO) {
//        return modelMapper.map(movieDTO, Movie.class);
//    }
//    public boolean isMovieNameExists(String movieName) {
//        return movieRepository.existsByMovieName(movieName);
//    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Autowired private MovieRepository repo;
	@Autowired private StorageService storage;
	
	public void save(Movie movie,MultipartFile photo) {
		System.out.println("movie id"+movie.getMovieId());
		if(movie.getMovieId()==0) {
			String poster=storage.store(photo);
			movie.setPoster(poster);
		}else {
			if(photo!=null) {
				String poster=storage.store(photo);
				movie.setPoster(poster);				
			}else {
				Movie mm=repo.findById(movie.getMovieId()).get();
				movie.setPoster(mm.getPoster());
			}
		}
		repo.save(movie);
	}
	
	public List<Movie> listall(){
		return repo.findAll();
	}
	
	public Movie findById(int id) {
		return repo.getById(id);
	}
	
	public void deleteMovie(int id) {
		repo.delete(repo.getById(id));
	}
    public boolean isMovieNameExists(String movieName) {
     return repo.existsByMovieName(movieName);
    }

}