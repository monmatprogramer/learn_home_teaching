package org.example.learn_home_teaching.api.models.dtos.requests;

import org.example.learn_home_teaching.api.models.entities.UserRole;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
/*
  {
    "name": "John Doe",
    "email": "john@example.com",
    "password": "password123",
    "role": "TEACHER"
}
 */
@Data
public class UserRegistrationRequest {
    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message = "Email is required")
    private String email;
    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;

    private String phoneNumber;
    
    private UserRole role = UserRole.STUDENT; //Get data from Json and Map it into UserRole on this field
}
