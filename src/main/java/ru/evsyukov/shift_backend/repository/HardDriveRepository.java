package ru.evsyukov.shift_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.evsyukov.shift_backend.entity.HardDrive;

public interface HardDriveRepository extends JpaRepository<HardDrive, String> {

}
