package ro.fortech.demo.controller;

import org.springframework.web.bind.annotation.*;
import ro.fortech.demo.model.Product;
import ro.fortech.demo.service.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable Integer productId) {
        productService.deleteProduct(productId);
    }

    @PutMapping("/{productId}")
    public Optional<Product> updateProduct(@PathVariable Integer productId, @RequestBody Product product) {
        return productService.updateProduct(productId, product);
    }
}
