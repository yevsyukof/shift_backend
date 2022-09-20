package ru.evsyukov.shift_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.evsyukov.shift_backend.entity.Product;

public interface ProductRepository extends JpaRepository<Product, String> {

}
