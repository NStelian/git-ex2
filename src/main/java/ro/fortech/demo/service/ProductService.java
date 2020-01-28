package ro.fortech.demo.service;

import org.springframework.stereotype.Service;
import ro.fortech.demo.model.Product;
import ro.fortech.demo.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }
}
