package com.rsfrancisco.course.configurations;

import com.rsfrancisco.course.entities.User;
import com.rsfrancisco.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

/**
 * Configuration class for "test" profile, database seeding
 * @author Rafael Francisco
 * @email broncasrafa@gmail.com
 * @github https://github.com/broncasrafa
 */
@Configuration
@Profile("test")
public class TestConfiguration implements CommandLineRunner {
    @Autowired
    private UserRepository _userRepository;

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User(null, "Aaron Alexander", "aaron.alexander@test.com", "11978984510", java.util.UUID.randomUUID().toString());
        User user2 = new User(null, "Brian Cooper", "brian.cooper@test.com", "11901247854", java.util.UUID.randomUUID().toString());
        User user3 = new User(null, "Victoria Medeiros", "victoria.medeiros@test.com", "11945687451", java.util.UUID.randomUUID().toString());
        User user4 = new User(null, "Bianca Andrade", "bianca.andrade@test.com", "11901235698", java.util.UUID.randomUUID().toString());
        User user5 = new User(null, "Monica Mattos", "monica.mattos@test.com", "11978451203", java.util.UUID.randomUUID().toString());
        User user6 = new User(null, "Brianna Harris", "brianna.harris@test.com", "11998563201", java.util.UUID.randomUUID().toString());
        User user7 = new User(null, "Elsa Evans", "elsa.evans@test.com", "11978453520", java.util.UUID.randomUUID().toString());

        _userRepository.saveAll(Arrays.asList(user1, user2, user3, user4, user5, user6, user7));
    }
}
// , String name, String email, String phone, String password