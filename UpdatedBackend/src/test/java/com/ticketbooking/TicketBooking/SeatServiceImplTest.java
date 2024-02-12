//package com.ticketbooking.TicketBooking;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.modelmapper.ModelMapper;
//
//import com.ticketbooking.dto.SeatDTO;
//import com.ticketbooking.entities.Seat;
//import com.ticketbooking.services.SeatServiceImpl;
//
//import jakarta.transaction.SystemException;
//
//@ExtendWith(MockitoExtension.class)
//class SeatServiceImplTest {
//
//    @Mock
//    private ModelMapper modelMapper;
//
//    @InjectMocks
//    private SeatServiceImpl seatService;
//
//    @Test
//    void bookSeat_ValidSeatDTO_ShouldReturnBookedSeatDTO() {
//        // Arrange
//        SeatDTO inputSeatDTO = new SeatDTO(1, 5, 1);
//        Seat bookedSeat = new Seat(1, 5, null);
//        SeatDTO expectedBookedSeatDTO = new SeatDTO(1, 5, 1);
//
//        when(modelMapper.map(inputSeatDTO, Seat.class)).thenReturn(bookedSeat);
//        when(modelMapper.map(bookedSeat, SeatDTO.class)).thenReturn(expectedBookedSeatDTO);
//
//        // Act
//        SeatDTO result = seatService.bookSeat(inputSeatDTO);
//
//        // Assert
//        assertEquals(expectedBookedSeatDTO, result);
//        verify(modelMapper, times(1)).map(inputSeatDTO, Seat.class);
//        verify(modelMapper, times(1)).map(bookedSeat, SeatDTO.class);
//        
//    }
//
//    
//    @Test
//    void cancelSeatBooking_ValidSeatDTO_ShouldReturnCanceledSeatDTO() {
//        // Arrange
//        SeatDTO inputSeatDTO = new SeatDTO(1, 5, 1);
//        Seat canceledSeat = new Seat(1, 5, null);
//        SeatDTO expectedCanceledSeatDTO = new SeatDTO(1, 5, 1);
//
//        when(modelMapper.map(inputSeatDTO, Seat.class)).thenReturn(canceledSeat);
//        when(modelMapper.map(canceledSeat, SeatDTO.class)).thenReturn(expectedCanceledSeatDTO);
//
//        // Act
//        SeatDTO result = seatService.cancelSeatBooking(inputSeatDTO);
//
//        // Assert
//        assertEquals(expectedCanceledSeatDTO, result);
//        verify(modelMapper, times(1)).map(inputSeatDTO, Seat.class);
//        verify(modelMapper, times(1)).map(canceledSeat, SeatDTO.class);
//       
//    }
//
//    @Test
//    void blockSeat_ValidSeatDTO_ShouldReturnBlockedSeatDTO() {
//        // Arrange
//        SeatDTO inputSeatDTO = new SeatDTO(1, 5, 1);
//        Seat blockedSeat = new Seat(1, 5, null);
//        SeatDTO expectedBlockedSeatDTO = new SeatDTO(1, 5, 1);
//
//        when(modelMapper.map(inputSeatDTO, Seat.class)).thenReturn(blockedSeat);
//        when(modelMapper.map(blockedSeat, SeatDTO.class)).thenReturn(expectedBlockedSeatDTO);
//
//        // Act
//        SeatDTO result = seatService.blockSeat(inputSeatDTO);
//
//        // Assert
//        assertEquals(expectedBlockedSeatDTO, result);
//        verify(modelMapper, times(1)).map(inputSeatDTO, Seat.class);
//        verify(modelMapper, times(1)).map(blockedSeat, SeatDTO.class);
//        
//    }
//
//    @Test
//    void bookSeat_InvalidSeatDTO_ShouldThrowException() {
//        // Arrange
//        SeatDTO invalidSeatDTO = new SeatDTO();
//
//        // Act and Assert
//        assertThrows(SystemException.class, () -> seatService.bookSeat(invalidSeatDTO));
//       
//    }
//
//    
//}
