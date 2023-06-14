package com.rsfrancisco.course.configurations;

import com.rsfrancisco.course.entities.Order;
import com.rsfrancisco.course.entities.User;
import com.rsfrancisco.course.repositories.OrderRepository;
import com.rsfrancisco.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

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
    @Autowired
    private OrderRepository _orderRepository;

    @Override
    public void run(String... args) throws Exception {
        // adding users
        User user1 = new User(null, "Aaron Alexander", "aaron.alexander@test.com", "11978984510", java.util.UUID.randomUUID().toString());
        User user2 = new User(null, "Brian Cooper", "brian.cooper@test.com", "11901247854", java.util.UUID.randomUUID().toString());
        User user3 = new User(null, "Victoria Medeiros", "victoria.medeiros@test.com", "11945687451", java.util.UUID.randomUUID().toString());
        User user4 = new User(null, "Bianca Andrade", "bianca.andrade@test.com", "11901235698", java.util.UUID.randomUUID().toString());
        User user5 = new User(null, "Monica Mattos", "monica.mattos@test.com", "11978451203", java.util.UUID.randomUUID().toString());
        User user6 = new User(null, "Brianna Harris", "brianna.harris@test.com", "11998563201", java.util.UUID.randomUUID().toString());
        User user7 = new User(null, "Elsa Evans", "elsa.evans@test.com", "11978453520", java.util.UUID.randomUUID().toString());
        _userRepository.saveAll(Arrays.asList(user1, user2, user3, user4, user5, user6, user7));

        // adding orders
        Order order1 = new Order(null, Instant.parse("2023-06-14T10:55:22Z"), user3);
        Order order2 = new Order(null, Instant.parse("2023-06-14T10:55:22Z"), user3);
        Order order3 = new Order(null, Instant.parse("2023-06-14T10:55:22Z"), user1);
        Order order4 = new Order(null, Instant.parse("2023-06-14T10:55:22Z"), user2);
        Order order5 = new Order(null, Instant.parse("2023-06-14T10:55:22Z"), user4);
        Order order6 = new Order(null, Instant.parse("2023-06-14T10:55:22Z"), user4);
        _orderRepository.saveAll(Arrays.asList(order1, order2, order3, order4, order5, order6));
    }
}

// padrão ISO 8601 - Instant.parse("2023-06-14T10:57:22Z")