package ru.evsyukov.shift_backend.service;

import java.util.List;
import java.util.Optional;
import ru.evsyukov.shift_backend.entity.Product;

public interface ProductService {

    List<Product> getAllProducts();

    Optional<Product> getProductBySerialNumber(String serialNumber);
}
