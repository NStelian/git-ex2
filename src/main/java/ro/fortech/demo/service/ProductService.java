package ro.fortech.demo.service;

import org.springframework.stereotype.Service;
import ro.fortech.demo.exceptions.ProductNotFoundException;
import ro.fortech.demo.model.Product;
import ro.fortech.demo.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product addProduct(Product product) {
        return this.productRepository.save(product);
    }

    public void deleteProduct(Integer productId) {
        Optional<Product> currentProduct = productRepository.findById(productId);
        if(currentProduct.isPresent())
            productRepository.deleteById(productId);
        else
            throw new ProductNotFoundException();
    }

    public Optional<Product> updateProduct(Integer productId, Product product) {
        Optional<Product> currentProduct = productRepository.findById(productId);
        if (currentProduct.isPresent()) {
            product.setProductId(productId);
            productRepository.save(product);
            return Optional.of(product);
        }
        throw new ProductNotFoundException();
    }
}
