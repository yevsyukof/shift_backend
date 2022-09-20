package ru.evsyukov.shift_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.evsyukov.shift_backend.entity.DesktopComputer;

public interface DesktopComputerRepository extends JpaRepository<DesktopComputer, String> {

}
