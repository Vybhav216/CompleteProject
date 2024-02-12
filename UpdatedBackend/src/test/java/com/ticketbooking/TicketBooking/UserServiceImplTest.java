//package com.ticketbooking.TicketBooking;
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//import java.util.Arrays;
//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//import org.modelmapper.ModelMapper;
//
//import com.ticketbooking.dto.SignInDTO;
//import com.ticketbooking.dto.UserCheckDTO;
//import com.ticketbooking.dto.UserDTO;
//import com.ticketbooking.entities.User;
//import com.ticketbooking.repository.UserRepository;
//import com.ticketbooking.services.UserServiceImpl;
//
//class UserServiceImplTest {
//
//    private final UserRepository userRepository = mock(UserRepository.class);
//    private final ModelMapper modelMapper = new ModelMapper();
//    private final UserServiceImpl userService = new UserServiceImpl(userRepository, modelMapper);
//
//
//    @SuppressWarnings("deprecation")
//	@Test
//    void testFindById() {
//        int userId = 1;
//        User expectedUser = new User(userId, "John Doe", "john.doe@example.com", "password123", false);
//
//        when(userRepository.getById(userId)).thenReturn(expectedUser);
//
//        User actualUser = userService.findById(userId);
//
//        assertEquals(expectedUser, actualUser);
//    }
//
//    @Test
//    void testListAll() {
//        List<User> expectedUsers = Arrays.asList(
//                new User(1, "John Doe", "john.doe@example.com", "password123", false),
//                new User(2, "Jane Doe", "jane.doe@example.com", "password456", true)
//        );
//
//        when(userRepository.findAll()).thenReturn(expectedUsers);
//
//        List<User> actualUsers = userService.listAll();
//
//        assertEquals(expectedUsers, actualUsers);
//    }
//
//    @Test
//    void testValidateValidUser() {
//        SignInDTO signInDTO = new SignInDTO();
//        signInDTO.setEmailId("john.doe@example.com");
//        signInDTO.setPassword("password123");
//
//        User user = new User(1, "John Doe", "john.doe@example.com", "password123", false);
//
//        when(userRepository.findByEmail("john.doe@example.com")).thenReturn(user);
//
//        UserCheckDTO userCheckDTO = userService.validate(signInDTO);
//
//        assertNotNull(userCheckDTO);
//        assertEquals(user.getUserId(), userCheckDTO.getUserId());
//        assertEquals(user.getUserName(), userCheckDTO.getUserName());
//        assertEquals(user.getEmail(), userCheckDTO.getEmail());
//        assertEquals(user.isAdmin(), userCheckDTO.isAdmin());
//    }
//
//    @Test
//    void testValidateInvalidUser() {
//        SignInDTO signInDTO = new SignInDTO();
//        signInDTO.setEmailId("123");
//        signInDTO.setPassword("123");
//        User user = new User(1, "John Doe", "123", "123", false);
//
//        when(userRepository.findByEmail("123")).thenReturn(user);
//
//        UserCheckDTO userCheckDTO = userService.validate(signInDTO);
//
//        assertNull(userCheckDTO);
//    }
//    
//    @Test
//    void testValidateInvalidPassword() {
//        SignInDTO signInDTO = new SignInDTO();
//        signInDTO.setEmailId("john.doe@example.com");
//        signInDTO.setPassword(" ");
//
//        User user = new User(1, "John Doe", "john.doe@example.com", " ", false);
//
//        when(userRepository.findByEmail("john.doe@example.com")).thenReturn(user);
//
//        UserCheckDTO userCheckDTO = userService.validate(signInDTO);
//
//        assertNull(userCheckDTO);
//    }
//
//    @Test
//    void testValidateNullUser() {
//        SignInDTO signInDTO = new SignInDTO();
//        signInDTO.setEmailId(" ");
//        signInDTO.setPassword("password123");
//        
//        User user = new User(1, "John Doe", " ", "password123", false);
//
//        when(userRepository.findByEmail(" ")).thenReturn(user);
//
//        UserCheckDTO userCheckDTO = userService.validate(signInDTO);
//
//        assertNull(userCheckDTO);
//    }
//}
