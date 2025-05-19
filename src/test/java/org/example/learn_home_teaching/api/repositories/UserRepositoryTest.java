package org.example.learn_home_teaching.api.repositories;


import org.example.learn_home_teaching.api.models.entities.User;
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
        user.setName();

    }
}
