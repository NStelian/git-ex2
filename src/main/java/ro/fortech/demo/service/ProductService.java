package ro.fortech.demo.service;

import org.springframework.stereotype.Service;
import ro.fortech.demo.repository.ProductRepository;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
}
