package ro.fortech.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.fortech.demo.model.Product;
import ro.fortech.demo.repository.ProductRepository;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner atStartup(ProductRepository repo) {
        return args -> {
            repo.save(new Product("Haur", "14 karate"));
            repo.save(new Product("Haur2", "24 karate"));
        };
    }
}
