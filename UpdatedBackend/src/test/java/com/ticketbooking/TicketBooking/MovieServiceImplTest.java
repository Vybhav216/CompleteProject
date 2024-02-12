//package com.ticketbooking.TicketBooking;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.Mockito.*;
// 
//import java.util.Arrays;
//import java.util.List;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.modelmapper.ModelMapper;
// 
//import com.ticketbooking.dto.MovieDTO;
//import com.ticketbooking.entities.Movie;
//import com.ticketbooking.exception.MovieNotFoundException;
//import com.ticketbooking.repository.MovieRepository;
//import com.ticketbooking.services.MovieServiceImpl;
// 
//@ExtendWith(MockitoExtension.class)
//public class MovieServiceImplTest {
// 
//    @Mock
//    private MovieRepository movieRepository;
// 
//    @Mock
//    private ModelMapper modelMapper;
// 
//    @InjectMocks
//    private MovieServiceImpl movieService;
// 
//    @Test
//    public void testSave() {
//        Movie movie = new Movie();
//        movieService.save(movie);
//        verify(movieRepository, times(1)).save(movie);
//    }
// 
//    @Test
//    public void testListAll() {
//        List<Movie> movies = Arrays.asList(
//                new Movie(1, "Movie1", "Genre1", "2h", "English", 2022, "Description1"),
//                new Movie(2, "Movie2", "Genre2", "1h30m", "Spanish", 2021, "Description2")
//        );
// 
//        when(movieRepository.findAll()).thenReturn(movies);
// 
//        List<MovieDTO> movieDTOs = Arrays.asList(
//                new MovieDTO(1, "Movie1", "Genre1", "2h", "English", 2022, "Description1"),
//                new MovieDTO(2, "Movie2", "Genre2", "1h30m", "Spanish", 2021, "Description2")
//        );
// 
//        when(modelMapper.map(any(), eq(MovieDTO.class))).thenReturn(movieDTOs.get(0), movieDTOs.get(1));
// 
//        List<MovieDTO> result = movieService.listAll();
// 
//        assertEquals(2, result.size());
//        assertEquals("Movie1", result.get(0).getMovieName());
//        assertEquals("Genre2", result.get(1).getMovieGenre());
//    }
// 
//    
////	@Test
////    public void testFindById() {
////        int movieId = 1;
////        Movie movie = new Movie(movieId, "Movie1", "Genre1", "2h", "English", 2022, "Description1");
////
////        when(movieRepository.findById(movieId)).thenReturn(movie);
////
////        MovieDTO movieDTO = new MovieDTO(movieId, "Movie1", "Genre1", "2h", "English", 2022, "Description1");
////        when(modelMapper.map(movie, MovieDTO.class)).thenReturn(movieDTO);
////
////        MovieDTO result = movieService.findById(movieId);
////
////        assertEquals("Movie1", result.getMovieName());
////        assertEquals("Genre1", result.getMovieGenre());
////    }
// 
//	
//	@Test
//	public void testFindById() {
//	    int movieId = 1;
//	    Movie movie = new Movie(movieId, "Movie1", "Genre1", "2h", "English", 2022, "Description1");
// 
//	    // Adjust the stubbing to return a non-null Movie
//	    when(movieRepository.findById(movieId)).thenReturn(movie);
// 
//	    MovieDTO movieDTO = new MovieDTO(movieId, "Movie1", "Genre1", "2h", "English", 2022, "Description1");
//	    when(modelMapper.map(movie, MovieDTO.class)).thenReturn(movieDTO);
// 
//	    MovieDTO result = movieService.findById(movieId);
// 
//	    assertEquals("Movie1", result.getMovieName());
//	    assertEquals("Genre1", result.getMovieGenre());
//	}
// 
//    
//	@Test
//    public void testDeleteMovie() {
//        int movieId = 1;
//        Movie movie = new Movie(movieId, "Movie1", "Genre1", "2h", "English", 2022, "Description1");
// 
//        when(movieRepository.findById(movieId)).thenReturn(movie);
// 
//        movieService.deleteMovie(movieId);
// 
//        verify(movieRepository, times(1)).delete(movie);
//    }
// 
//    @Test
//    public void testConvertToEntity() {
//        MovieDTO movieDTO = new MovieDTO(1, "Movie1", "Genre1", "2h", "English", 2022, "Description1");
// 
//        Movie movie = new Movie(1, "Movie1", "Genre1", "2h", "English", 2022, "Description1");
// 
//        when(modelMapper.map(movieDTO, Movie.class)).thenReturn(movie);
// 
//        Movie result = movieService.convertToEntity(movieDTO);
// 
//        assertEquals("Movie1", result.getMovieName());
//        assertEquals("Genre1", result.getMovieGenre());
//    }
//
//	@Test
//    public void testFindByIdInvalidMovieId() {
//        int invalidMovieId = 999;
//        when(movieRepository.findById(invalidMovieId)).thenReturn(null);
// 
//        assertThrows(MovieNotFoundException.class, () -> movieService.findById(invalidMovieId));
//    }
// 
//    
//	@Test
//    public void testDeleteMovieInvalidMovieId() {
//        int invalidMovieId = 999;
//        when(movieRepository.findById(invalidMovieId)).thenReturn(null);
// 
//        assertThrows(MovieNotFoundException.class, () -> movieService.deleteMovie(invalidMovieId));
// 
//        // Ensure delete method is not called when the movie is not found
//        verify(movieRepository, never()).delete(any());
//    }
// 
//    @Test
//    public void testConvertToEntityInvalidDTO() {
//        MovieDTO invalidDTO = new MovieDTO(); // Invalid DTO without required fields
// 
//        assertThrows(IllegalArgumentException.class, () -> movieService.convertToEntity(invalidDTO));
// 
//        // Ensure map method is not called when the DTO is invalid
//        verify(modelMapper, never()).map(any(), eq(Movie.class));
//    }
//}