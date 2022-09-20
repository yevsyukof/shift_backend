package ru.evsyukov.shift_backend.service;

import java.util.List;
import java.util.Optional;
import ru.evsyukov.shift_backend.entity.Laptop;

public interface LaptopService {

    boolean addLaptop(Laptop laptop);

    boolean updateLaptop(String serialNumber, Laptop laptop);

    boolean deleteLaptopBySerialNumber(String serialNumber);

    Optional<Laptop> getLaptopBySerialNumber(String serialNumber);

    List<Laptop> getAllLaptops();
}
