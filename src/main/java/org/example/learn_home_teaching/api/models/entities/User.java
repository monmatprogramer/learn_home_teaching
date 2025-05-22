package org.example.learn_home_teaching.api.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity // it is mapped to be database tables
@Table(name = "users") //set table name
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity{
    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private String phoneNumber;

    private String profilePicture;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole role;

    @Column(columnDefinition = "TEXT")
    private String bio;

    @Column(columnDefinition =  "TEXT")
    private String address;

    private LocalDateTime lastLoginAt;

    private boolean isActive = true;

    @Column(columnDefinition = " TEXT")
    private String preferences;

}
