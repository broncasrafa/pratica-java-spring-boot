package com.rsfrancisco.course.configurations;

import com.rsfrancisco.course.entities.Category;
import com.rsfrancisco.course.entities.Order;
import com.rsfrancisco.course.entities.Product;
import com.rsfrancisco.course.entities.User;
import com.rsfrancisco.course.entities.enums.OrderStatus;
import com.rsfrancisco.course.repositories.CategoryRepository;
import com.rsfrancisco.course.repositories.OrderRepository;
import com.rsfrancisco.course.repositories.ProductRepository;
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
    @Autowired
    private ProductRepository _productRepository;

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

        // adding products
        Product p1 = new Product(null, "TCL Smart Roku TV 32\" Classe 3-Series HD 720p LED – 32S355, preto", "TCL Smart Roku TV 32\" Classe 3-Series HD 720p LED – 32S355, preto", 129.99, null);
        Product p2 = new Product(null, "SAMSUNG TV Smart FHD LED Classe 32\" 1080P (UN32N5300AFXZA, modelo 2018), preta", "SAMSUNG TV Smart FHD LED Classe 32\" 1080P (UN32N5300AFXZA, modelo 2018), preta", 227.99, null);
        Product p3 = new Product(null, "Apple iPad Pro de 12,9 polegadas 2022 (Wi-Fi, 128 GB) - cinza espacial (6ª geração)", "Apple iPad Pro de 12,9 polegadas 2022 (Wi-Fi, 128 GB) - cinza espacial (6ª geração)", 828.00, null);

        Product p4 = new Product(null, "CyberpowerPC PC Gamer Xtreme VR Gamer, Intel Core i7-12700F 2,1GHz, GeForce RTX 3060 12GB, 16GB DDR4, 1TB NVMe SSD, WiFi e Win 11 Home (GXiVR8040A12), preto", "CyberpowerPC PC Gamer Xtreme VR Gamer, Intel Core i7-12700F 2,1GHz, GeForce RTX 3060 12GB, 16GB DDR4, 1TB NVMe SSD, WiFi e Win 11 Home (GXiVR8040A12), preto", 1169.99, null);
        Product p5 = new Product(null, "Dell Laptop Inspiron 15 2022, tela HD de 15,6 polegadas, processador Intel Celeron N4020, RAM DDR4 de 16 GB, SSD PCIe de 1 TB, Webcam, HDMI, Wi-Fi, Bluetooth, Windows 11 Home, preto", "Dell Laptop Inspiron 15 2022, tela HD de 15,6 polegadas, processador Intel Celeron N4020, RAM DDR4 de 16 GB, SSD PCIe de 1 TB, Webcam, HDMI, Wi-Fi, Bluetooth, Windows 11 Home, preto", 405.00, null);

        Product p6 = new Product(null, "Gel de limpeza para carro, kit de limpeza de carro com detalhes universais, limpador de fendas automotivas, saída de ar, remoção de detalhes, limpeza de teclado, limpador, para saídas de carro, PC, laptops, câmeras", "Gel de limpeza para carro, kit de limpeza de carro com detalhes universais, limpador de fendas automotivas, saída de ar, remoção de detalhes, limpeza de teclado, limpador, para saídas de carro, PC, laptops, câmeras", 6.99, null);
        Product p7 = new Product(null, "Chemical Guys SPI22016 Limpador e protetor total de interiores, seguro para carros, caminhões, SUVs, Jeeps, motocicletas, trailers e mais, 500 ml", "Chemical Guys SPI22016 Limpador e protetor total de interiores, seguro para carros, caminhões, SUVs, Jeeps, motocicletas, trailers e mais, 500 ml", 11.97, null);

        Product p8 = new Product(null, "Quem Pensa Enriquece - O Legado (Portuguese Edition)", "Quem Pensa Enriquece - O Legado (Portuguese Edition)", 12.44, null);
        Product p9 = new Product(null, "O Poder Secreto Da Oracao E Do Jejum", "O Poder Secreto Da Oracao E Do Jejum", 22.87, null);
        Product p10 = new Product(null, "Pai rico, Pai pobre", "Pai rico, Pai pobre", 10.99, null);
        _productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10));

    }
}
// Long id, String name, String description, Double price, String imgUrl
// padrão ISO 8601 - Instant.parse("2023-06-14T10:57:22Z")