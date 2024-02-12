//package com.ticketbooking.TicketBooking;
// 
//import com.ticketbooking.dto.SeatDTO;
//import com.ticketbooking.dto.TheatreDTO;
//import com.ticketbooking.entities.Seat;
//import com.ticketbooking.entities.Theatre;
//import com.ticketbooking.repository.TheatreRepository;
//import com.ticketbooking.services.TheatreServiceImpl;
//import com.ticketbooking.repository.SeatRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.modelmapper.ModelMapper;
// 
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
// 
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
// 
//class TheatreServiceImplTest {
// 
//    @InjectMocks
//    private TheatreServiceImpl theatreService;
// 
//    @Mock
//    private TheatreRepository theatreRepository;
// 
//    @Mock
//    private SeatRepository seatRepository;
// 
//    @Mock
//    private ModelMapper modelMapper;
// 
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
// 
//    @Test
//    void saveSeatValidInputCallsRepositorySave() {
//        SeatDTO seatDTO = new SeatDTO();
//        Seat seatEntity = new Seat();
//        when(modelMapper.map(any(SeatDTO.class), eq(Seat.class))).thenReturn(seatEntity);
// 
//        theatreService.saveSeat(seatDTO);
// 
//        verify(seatRepository, times(1)).save(seatEntity);
//    }
// 
//    @Test
//    void deleteSeatValidIdCallsRepositoryDeleteById() {
//        int seatId = 1;
//        theatreService.deleteSeat(seatId);
// 
//        verify(seatRepository, times(1)).deleteById(seatId);
//    }
// 
//	/*
//	 * @Test void saveTheatreValidInputCallsRepositorySave() { Theatre theatre = new
//	 * TheatreDTO(); Theatre theatreEntity = new Theatre();
//	 * when(modelMapper.map(any(TheatreDTO.class),
//	 * eq(Theatre.class))).thenReturn(theatreEntity);
//	 * 
//	 * theatreService.saveTheatre(theatre);
//	 * 
//	 * verify(theatreRepository, times(1)).save(theatreEntity); }
//	 */
//    @Test
//    void listAllTheatresReturnsListOfTheatres() {
//        List<Theatre> theatreEntities = Arrays.asList(new Theatre(), new Theatre());
//        List<TheatreDTO> expectedTheatreDTOs = Arrays.asList(new TheatreDTO(), new TheatreDTO());
// 
//        when(theatreRepository.findAll()).thenReturn(theatreEntities);
//        when(modelMapper.map(any(Theatre.class), eq(TheatreDTO.class))).thenReturn(new TheatreDTO());
// 
//        List<TheatreDTO> result = theatreService.listAllTheatres();
// 
//        assertEquals(expectedTheatreDTOs, result);
//    }
// 
//    @SuppressWarnings("deprecation")
//	@Test
//    void findTheatreByIdReturnsTheatreDTO() {
//        int theatreId = 1;
//        Theatre theatreEntity = new Theatre();
//        TheatreDTO expectedTheatreDTO = new TheatreDTO();
// 
//        when(theatreRepository.getById(theatreId)).thenReturn(theatreEntity);
//        when(modelMapper.map(any(Theatre.class), eq(TheatreDTO.class))).thenReturn(expectedTheatreDTO);
// 
//        TheatreDTO result = theatreService.findTheatreById(theatreId);
// 
//        assertEquals(expectedTheatreDTO, result);
//    }
// 
//    @Test
//    void deleteTheatreValidIdCallsRepositoryDeleteById() {
//        int theatreId = 1;
//        theatreService.deleteTheatre(theatreId);
// 
//        verify(theatreRepository, times(1)).deleteById(theatreId);
//    }
// 
//    @Test
//    void updateTheatreValidInputCallsRepositorySave() {
//        TheatreDTO theatreDTO = new TheatreDTO();
//        Theatre existingTheatre = new Theatre();
//        when(theatreRepository.findById(theatreDTO.getTheatreId())).thenReturn(Optional.of(existingTheatre));
//        when(modelMapper.map(any(TheatreDTO.class), eq(Theatre.class))).thenReturn(existingTheatre);
// 
//        theatreService.updateTheatre(theatreDTO);
// 
//        verify(theatreRepository, times(1)).save(existingTheatre);
//    }
// 
//    @Test
//    void saveSeatInvalidInputThrowsException() {
//        SeatDTO seatDTO = new SeatDTO(); // Create an invalid SeatDTO for testing
//        when(modelMapper.map(any(SeatDTO.class), eq(Seat.class))).thenReturn(new Seat());
// 
//        assertThrows(RuntimeException.class, () -> theatreService.saveSeat(seatDTO));
// 
//        verify(seatRepository, never()).save(any(Seat.class));
//    }
// 
//    @Test
//    void deleteSeatInvalidIdThrowsException() {
//        int invalidSeatId = -1; // Invalid seat ID for testing
//        assertThrows(RuntimeException.class, () -> theatreService.deleteSeat(invalidSeatId));
// 
//        verify(seatRepository, never()).deleteById(anyInt());
//    }
// 
//    @SuppressWarnings("deprecation")
//	@Test
//    void findTheatreByIdNotFoundThrowsException() {
//        int nonExistentTheatreId = 999; // Non-existent theatre ID for testing
//        when(theatreRepository.getById(nonExistentTheatreId)).thenThrow(new RuntimeException("Theatre not found"));
// 
//        assertThrows(RuntimeException.class, () -> theatreService.findTheatreById(nonExistentTheatreId));
//    }
// 
//    @Test
//    void updateTheatreNonExistentTheatreThrowsException() {
//        TheatreDTO theatreDTO = new TheatreDTO();
//        when(theatreRepository.findById(theatreDTO.getTheatreId())).thenReturn(Optional.empty());
// 
//        assertThrows(RuntimeException.class, () -> theatreService.updateTheatre(theatreDTO));
// 
//        verify(theatreRepository, never()).save(any(Theatre.class));
//    }
// 
//    @Test
//    void updateTheatreNullDTOThrowsException() {
//        assertThrows(IllegalArgumentException.class, () -> theatreService.updateTheatre(null));
// 
//        verify(theatreRepository, never()).save(any(Theatre.class));
//    }
// 
//    
// 
//}