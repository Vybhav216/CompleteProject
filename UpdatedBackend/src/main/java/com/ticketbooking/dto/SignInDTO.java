package com.ticketbooking.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class SignInDTO {
	//LoginDTO
	@NotNull(message = "Email is required")
    @Email(message = "Invalid email format")
	private String userId;
	
	@NotNull(message = "Password is required")
    @Size(min = 6, max = 50, message = "Password must be between 6 and 50 characters")
	private String password;

	

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
