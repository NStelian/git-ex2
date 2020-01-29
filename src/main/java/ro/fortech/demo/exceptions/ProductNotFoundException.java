package ro.fortech.demo.exceptions;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException() {
        super("A product with that id doesn't exist.");
    }
}
