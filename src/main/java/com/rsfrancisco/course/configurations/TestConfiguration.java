package com.rsfrancisco.course.configurations;

import com.rsfrancisco.course.entities.Category;
import com.rsfrancisco.course.entities.Order;
import com.rsfrancisco.course.entities.User;
import com.rsfrancisco.course.entities.enums.OrderStatus;
import com.rsfrancisco.course.repositories.CategoryRepository;
import com.rsfrancisco.course.repositories.OrderRepository;
import com.rsfrancisco.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
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
    @Autowired
    private OrderRepository _orderRepository;
    @Autowired
    private CategoryRepository _categoryRepository;

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
        Order order1 = new Order(null, Instant.parse("2023-06-14T10:55:22Z"), user3, OrderStatus.WAITING_PAYMENT);
        Order order2 = new Order(null, Instant.parse("2023-06-14T10:55:22Z"), user3, OrderStatus.PAID);
        Order order3 = new Order(null, Instant.parse("2023-06-14T10:55:22Z"), user1, OrderStatus.WAITING_PAYMENT);
        Order order4 = new Order(null, Instant.parse("2023-06-14T10:55:22Z"), user2, OrderStatus.PAID);
        Order order5 = new Order(null, Instant.parse("2023-06-14T10:55:22Z"), user4, OrderStatus.WAITING_PAYMENT);
        Order order6 = new Order(null, Instant.parse("2023-06-14T10:55:22Z"), user4, OrderStatus.PAID);
        _orderRepository.saveAll(Arrays.asList(order1, order2, order3, order4, order5, order6));

        // adding categories
        Category c1 = new Category(null, "Electronics");
        Category c2 = new Category(null, "Computers");
        Category c3 = new Category(null, "Books");
        Category c4 = new Category(null, "Automotive");

        _categoryRepository.saveAll(Arrays.asList(c1, c2, c3, c4));
    }
}

// padrão ISO 8601 - Instant.parse("2023-06-14T10:57:22Z")