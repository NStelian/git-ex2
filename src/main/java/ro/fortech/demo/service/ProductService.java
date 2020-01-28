package ro.fortech.demo.service;

import org.springframework.stereotype.Service;
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
        productRepository.deleteById(productId);
    }

    public Optional<Product> updateProduct(Product product,Integer productId) {
        Optional<Product> currentProduct = productRepository.findById(product.getProductId());
        if (currentProduct.isPresent()){
            currentProduct.get().setName(product.getName());
            currentProduct.get().setDescription(product.getDescription());
            return currentProduct;
        }
        return Optional.empty();
    }
}
