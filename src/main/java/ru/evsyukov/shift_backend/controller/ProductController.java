package ru.evsyukov.shift_backend.controller;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.evsyukov.shift_backend.entity.Product;
import ru.evsyukov.shift_backend.service.ProductService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<?> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping(value = "/{serialNumber}")
    public ResponseEntity<?> getProductBySerialNumber(@PathVariable String serialNumber) {
        Optional<Product> product = productService.getProductBySerialNumber(serialNumber);
        return product.isPresent()
            ? new ResponseEntity<>(product, HttpStatus.OK)
            : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
