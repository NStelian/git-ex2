package ro.fortech.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fortech.demo.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
