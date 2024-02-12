package com.ticketbooking.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.ticketbooking.dto.SignInDTO;
import com.ticketbooking.dto.UserCheckDTO;
import com.ticketbooking.dto.UserDTO;
import com.ticketbooking.entities.User;
import com.ticketbooking.services.UserService;

import jakarta.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api/users")
@Validated
public class UserController {

	@Autowired
	private UserService userService;

//	@PostMapping("/register")
//	public ResponseEntity<?> registerUser(@RequestBody @Valid UserDTO userDTO) {
//        if (userService.isUserNameExists(userDTO.getUserName()) && userService.isEmailExists(userDTO.getEmail())){
//        	Map<String, String> error = new HashMap<>();
//            error.put("userName", "User with this username and email already exists");
//            return ResponseEntity.badRequest().body(error);
//        }
// 
//        
//		userService.saveUser(userDTO);
//		return ResponseEntity.ok().body("User registered successfully");
//	}
//
//	
//	@PostMapping("/signin") 
//	  public ResponseEntity<?> validateUser(@RequestBody @Valid SignInDTO signInDTO) { 
//		  UserCheckDTO user = userService.validate(signInDTO); 
//		  if (user != null) { 
//			  return ResponseEntity.ok(user); 
//			  } 
//		  else { 
//			  return ResponseEntity.badRequest().body("Invalid username or password"); 
//			  } 
//		  }
//	 
//
//	@GetMapping("/listallusers")
//	public ResponseEntity<?> listAllUsers() {
//		return ResponseEntity.ok(userService.listAll());
//	}
//
//	@GetMapping("{id}")
//	public ResponseEntity<?> findUserDetails(@PathVariable("id") int id) {
//		return ResponseEntity.ok().body(userService.findById(id));
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//@Autowired private UserService service;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user){
    	if (userService.isUserNameExists(user.getUserName()) && userService.isEmailExists(user.getEmail())){
        	Map<String, String> error = new HashMap<>();
            error.put("userName", "User with this username and email already exists");
            return ResponseEntity.badRequest().body(error);
        }
    	userService.saveUser(user);
        return ResponseEntity.ok().body("User registered successfully");
    }
    
    @PostMapping("/validate")
    public ResponseEntity<?> validate(@RequestBody SignInDTO dto){
        UserCheckDTO user=userService.validate(dto);
	
		 if(user!=null) { 
			 return ResponseEntity.ok(user); } 
		 else { 
			 return ResponseEntity.badRequest().body("Invalid username or password"); }
		 
    }

    @GetMapping
    public ResponseEntity<?> listall(){
        return ResponseEntity.ok(userService.listAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findDetails(@PathVariable("id") int id){
        return ResponseEntity.ok().body(userService.findById(id));
    }
}
