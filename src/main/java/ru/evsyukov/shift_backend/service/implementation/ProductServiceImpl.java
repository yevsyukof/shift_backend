package ru.evsyukov.shift_backend.service.implementation;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.evsyukov.shift_backend.entity.Product;
import ru.evsyukov.shift_backend.repository.ProductRepository;
import ru.evsyukov.shift_backend.service.ProductService;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductBySerialNumber(String serialNumber) {
        return productRepository.findById(serialNumber);
    }
}
