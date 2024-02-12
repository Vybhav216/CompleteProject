package com.ticketbooking.TicketBooking;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import com.ticketbooking.dto.MovieShowDTO;
import com.ticketbooking.entities.MovieShow;
import com.ticketbooking.repository.MovieShowRepository;
import com.ticketbooking.services.MovieShowServiceImpl;

import jakarta.persistence.EntityNotFoundException;

@ExtendWith(MockitoExtension.class)
class MovieShowServiceImplTest {

    @Mock
    private MovieShowRepository movieShowRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private MovieShowServiceImpl movieShowService;

    @Test
    void saveValidMovieShowDTOShouldSaveMovieShow() {
        // Arrange
        MovieShowDTO movieShowDTO = new MovieShowDTO();
        MovieShow movieShow = new MovieShow();
        when(modelMapper.map(movieShowDTO, MovieShow.class)).thenReturn(movieShow);

        // Act
        movieShowService.save(movieShowDTO);

        // Assert
        verify(movieShowRepository).save(movieShow);
    }

    @Test
    void listAllShouldReturnListOfMovieShowDTO() {
        // Arrange
        List<MovieShow> movieShows = Arrays.asList(new MovieShow(), new MovieShow());
        when(movieShowRepository.findAll()).thenReturn(movieShows);

        // Act
        List<MovieShowDTO> result = movieShowService.listAll();

        // Assert
        assertEquals(movieShows.size(), result.size());
        verify(modelMapper, times(movieShows.size())).map(any(), eq(MovieShowDTO.class));
    }

    @Test
    void todayShowsShouldReturnListOfMovieShowDTO() {
        // Arrange
        LocalDate currentDate = LocalDate.now();
        
        List<MovieShow> todayShows = Arrays.asList(new MovieShow(), new MovieShow());
        when(movieShowRepository.todaysShow(currentDate)).thenReturn(todayShows);

        // Act
        List<MovieShowDTO> result = movieShowService.todayShows();

        // Assert
        assertEquals(todayShows.size(), result.size());
        verify(modelMapper, times(todayShows.size())).map(any(), eq(MovieShowDTO.class));
    }

    @SuppressWarnings("deprecation")
	@Test
    void findByIdExistingIdShouldReturnMovieShowDTO() {
        // Arrange
        int movieShowId = 1;
        MovieShow movieShow = new MovieShow();
        MovieShowDTO expected = new MovieShowDTO();
        when(movieShowRepository.getById(movieShowId)).thenReturn(movieShow);
        when(modelMapper.map(movieShow, MovieShowDTO.class)).thenReturn(expected);

        // Act
        MovieShowDTO result = movieShowService.findById(movieShowId);

        // Assert
        assertNotNull(result);
        verify(modelMapper).map(movieShow, MovieShowDTO.class);
    }

    @Test
    void deleteMovieShowExistingIdShouldDeleteMovieShow() {
        // Arrange
        int movieShowId = 1;

        // Act
        movieShowService.deleteMovieShow(movieShowId);

        // Assert
        verify(movieShowRepository).deleteById(movieShowId);
    }

    @Test
    void findByDateValidDateShouldReturnListOfMovieShowDTO() {
        // Arrange
        String date = "2024-01-28";
        List<MovieShow> movieShows = Arrays.asList(new MovieShow(), new MovieShow());
        when(movieShowRepository.findByDate(date)).thenReturn(movieShows);

        // Act
        List<MovieShowDTO> result = movieShowService.findByDate(date);

        // Assert
        assertEquals(movieShows.size(), result.size());
        verify(modelMapper, times(movieShows.size())).map(any(), eq(MovieShowDTO.class));
    }
    
    @Test
    void saveNullMovieShowDTOShouldThrowIllegalArgumentException() {
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> movieShowService.save(null));
        verify(movieShowRepository, never()).save(any());
    }

    @SuppressWarnings("deprecation")
	@Test
    void findByIdNonExistingIdShouldThrowEntityNotFoundException() {
        // Arrange
        int nonExistingId = 999;
        when(movieShowRepository.getById(nonExistingId)).thenThrow(EntityNotFoundException.class);

        // Act & Assert
        assertThrows(EntityNotFoundException.class, () -> movieShowService.findById(nonExistingId));
        verify(modelMapper, never()).map(any(), eq(MovieShowDTO.class));
    }

    @Test
    void findByDateInvalidDateShouldThrowDateTimeParseException() {
        // Arrange
        String invalidDate = "invalid-date";

        // Act & Assert
        assertThrows(DateTimeParseException.class, () -> movieShowService.findByDate(invalidDate));
        verify(movieShowRepository, never()).findByDate(any());
        verify(modelMapper, never()).map(any(), eq(MovieShowDTO.class));
    }

    
}

