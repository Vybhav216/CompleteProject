package com.ticketbooking.services;

import java.util.List;

import com.ticketbooking.dto.MovieDTO;
import com.ticketbooking.dto.SignInDTO;
import com.ticketbooking.dto.UserCheckDTO;
import com.ticketbooking.dto.UserDTO;
import com.ticketbooking.entities.Movie;
import com.ticketbooking.entities.User;
import com.ticketbooking.globalexception.InvalidEntityException;

public interface UserService {

    //void saveUser(UserDTO admin);
    User convertToEntity(UserDTO userDTO)throws InvalidEntityException;
    User findById(int id);
	List<User> listAll();
	UserCheckDTO validate(SignInDTO signInDTO);
	boolean isUserNameExists(String userName);
	boolean isEmailExists(String email);
	void saveUser(User user);

}
