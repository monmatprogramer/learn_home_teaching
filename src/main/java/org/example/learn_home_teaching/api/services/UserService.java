package org.example.learn_home_teaching.api.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.learn_home_teaching.api.models.entities.User;
import org.example.learn_home_teaching.api.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service//When application started, it will be automatic created
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserRepository userRepository;

}
