package ru.evsyukov.shift_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.evsyukov.shift_backend.entity.Display;

public interface DisplayRepository extends JpaRepository<Display, String> {

}
