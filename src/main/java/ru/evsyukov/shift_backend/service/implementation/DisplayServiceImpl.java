package ru.evsyukov.shift_backend.service.implementation;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.evsyukov.shift_backend.entity.Display;
import ru.evsyukov.shift_backend.repository.DisplayRepository;
import ru.evsyukov.shift_backend.repository.ProductRepository;
import ru.evsyukov.shift_backend.service.DisplayService;

@RequiredArgsConstructor
@Service
public class DisplayServiceImpl implements DisplayService {

    private final DisplayRepository displayRepository;

    private final ProductRepository productRepository;

    @Override
    public boolean addDisplay(Display display) {
        if (productRepository.existsById(display.getSerialNumber())) {
            return false;
        }
        displayRepository.save(display);
        return true;
    }

    @Override
    public boolean updateDisplay(String serialNumber, Display display) {
        if (productRepository.existsById(serialNumber)) {
            displayRepository.save(display);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteDisplayBySerialNumber(String serialNumber) {
        if (serialNumber == null) {
            return false;
        }
        displayRepository.deleteById(serialNumber);
        return true;
    }

    @Override
    public Optional<Display> getDisplayBySerialNumber(String serialNumber) {
        return displayRepository.findById(serialNumber);
    }

    @Override
    public List<Display> getAllDisplays() {
        return displayRepository.findAll();
    }
}
