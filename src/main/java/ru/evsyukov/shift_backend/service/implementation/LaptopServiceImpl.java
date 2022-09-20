package ru.evsyukov.shift_backend.service.implementation;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.evsyukov.shift_backend.entity.Laptop;
import ru.evsyukov.shift_backend.repository.LaptopRepository;
import ru.evsyukov.shift_backend.repository.ProductRepository;
import ru.evsyukov.shift_backend.service.LaptopService;

@RequiredArgsConstructor
@Service
public class LaptopServiceImpl implements LaptopService {

    private final LaptopRepository laptopRepository;

    private final ProductRepository productRepository;

    @Override
    public boolean addLaptop(Laptop laptop) {
        if (productRepository.existsById(laptop.getSerialNumber())) {
            return false;
        }
        laptopRepository.save(laptop);
        return true;
    }

    @Override
    public boolean updateLaptop(String serialNumber, Laptop laptop) {
        if (productRepository.existsById(serialNumber)) {
            laptopRepository.save(laptop);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteLaptopBySerialNumber(String serialNumber) {
        if (serialNumber == null) {
            return false;
        }
        laptopRepository.deleteById(serialNumber);
        return true;
    }

    @Override
    public Optional<Laptop> getLaptopBySerialNumber(String serialNumber) {
        return laptopRepository.findById(serialNumber);
    }

    @Override
    public List<Laptop> getAllLaptops() {
        return laptopRepository.findAll();
    }
}
