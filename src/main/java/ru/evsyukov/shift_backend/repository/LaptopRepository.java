package ru.evsyukov.shift_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.evsyukov.shift_backend.entity.Laptop;

public interface LaptopRepository extends JpaRepository<Laptop, String> {

}
