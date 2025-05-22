package org.example.learn_home_teaching.api.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.example.learn_home_teaching.api.models.dtos.requests.UserRegistrationRequest;
import org.example.learn_home_teaching.api.models.dtos.response.UserResponse;
import org.example.learn_home_teaching.api.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service//When application started, it will be automatic created
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserRepository userRepository;// talk to user's database
    private final PasswordEncoder passwordEncoder;// talk to password encryption 

    //Register
    @Transactional
    public UserResponse createUser(UserRegistrationRequest userRegistrationRequest){
        //Check if user with given email already exists
        if(userRepository.existsByEmail(userRegistrationRequest.getEmail())){
            throw new IllegalArgumentException("User with given email already exists");
        }
        return null;
        
    }
}
