package org.example.learn_home_teaching.api.repositories;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.example.learn_home_teaching.api.models.entities.User;
import org.example.learn_home_teaching.api.models.entities.UserRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@ActiveProfiles("test")
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;


    @Test
    public void testFindByEmail(){
        User user = new User();
        user.setName("Test User");
        user.setEmail("Test@example.com");
        user.setPassword("password123");
        user.setRole(UserRole.STUDENT);
        userRepository.save(user);

        //Find by email
        Optional<User> foundUser = userRepository.findByEmail("Test@example.com");

        //Asset
        assertTrue(foundUser.isPresent());
        assertEquals("Test User", foundUser.get().getName());
    }

    @Test
    public void testExistsByEmail(){
        User user = new User();
        user.setName("Test User");
        user.setEmail("Test@example.com");
        user.setPassword("password123");
        user.setRole(UserRole.STUDENT);
        userRepository.save(user);

        //
        boolean isExist = userRepository.existsByEmail("Test@example.com");
        assertTrue(isExist);
    }

    @Test
    public void testFindByRole(){
        User user = new User();
        user.setName("Test User");
        user.setEmail("Test@example.com");
        user.setPassword("password123");
        user.setRole(UserRole.STUDENT);
        userRepository.save(user);

        User user2 = new User();
        user2.setName("Test User2");
        user2.setEmail("Test2@example.com");
        user2.setPassword("password123");
        user2.setRole(UserRole.STUDENT);
        userRepository.save(user2);

        List<User> teacherRole = userRepository.findByRole(UserRole.STUDENT);
        assertEquals(2,teacherRole.toArray().length);


    }
}
