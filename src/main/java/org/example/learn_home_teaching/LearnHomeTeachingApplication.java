package org.example.learn_home_teaching;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"org.example.learn_home_teaching.api"})//scan for components, services, configurations
@EntityScan("org.example.learn_home_teaching.api.models.entities") // find JPA entities
@EnableJpaRepositories("org.example.learn_home_teaching.api.repositories")// find repository interface
public class LearnHomeTeachingApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnHomeTeachingApplication.class, args);
    }

}
