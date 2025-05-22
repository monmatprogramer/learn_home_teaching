package org.example.learn_home_teaching.api.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.example.learn_home_teaching.api.models.dtos.requests.UserRegistrationRequest;
import org.example.learn_home_teaching.api.models.dtos.response.UserResponse;
import org.example.learn_home_teaching.api.models.entities.User;
import org.example.learn_home_teaching.api.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service // When application started, it will be automatic created
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserRepository userRepository;// talk to user's database
    private final PasswordEncoder passwordEncoder;// talk to password encryption

    // Register
    @Transactional
    public UserResponse createUser(UserRegistrationRequest userRegistrationRequest) {
        // Check if user with given email already exists
        if (userRepository.existsByEmail(userRegistrationRequest.getEmail())) {// if exist return true
            throw new IllegalArgumentException("User with given email already exists");// tell message to user
        }
        User user = new User();
        user.setName(userRegistrationRequest.getName());
        user.setEmail(userRegistrationRequest.getEmail());
        user.setPassword(userRegistrationRequest.getPassword());
        user.setPhoneNumber(userRegistrationRequest.getPhoneNumber());
        user.setRole(userRegistrationRequest.getRole());

        User registeredUser = userRepository.save(user);

        return mapToUserReponse(registeredUser);
    }

    private UserResponse mapToUserReponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setName(user.getName());
        userResponse.setEmail(user.getEmail());
        userResponse.setPhoneNumber(user.getPhoneNumber());
        userResponse.setRole(user.getRole());
        userResponse.setCreatedAt(user.getCreatedAt());
        userResponse.setActive(user.isActive());
        return userResponse;
    }
}
