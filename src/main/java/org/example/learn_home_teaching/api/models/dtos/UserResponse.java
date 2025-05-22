package org.example.learn_home_teaching.api.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.learn_home_teaching.api.models.entities.UserRole;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private UUID id;
    private String name;
    private String email;
    private String phoneNumber;
    private UserRole role; // reference to UserRole.java or UserRole class
    private LocalDateTime createdAt;
    private boolean active;

}
/*
* Security: hide sensitive field
* Flexibility: send the need data
* Versioning: Change that do not affect database structure
* */
