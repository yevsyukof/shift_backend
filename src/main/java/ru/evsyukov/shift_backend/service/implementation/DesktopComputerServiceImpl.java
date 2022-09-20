package ru.evsyukov.shift_backend.service.implementation;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.evsyukov.shift_backend.entity.DesktopComputer;
import ru.evsyukov.shift_backend.repository.DesktopComputerRepository;
import ru.evsyukov.shift_backend.repository.ProductRepository;
import ru.evsyukov.shift_backend.service.DesktopComputerService;

@RequiredArgsConstructor
@Service
public class DesktopComputerServiceImpl implements DesktopComputerService {

    private final DesktopComputerRepository desktopComputerRepository;

    private final ProductRepository productRepository;

    @Override
    public boolean addDesktopComputer(DesktopComputer desktopComputer) {
        if (productRepository.existsById(desktopComputer.getSerialNumber())) {
            return false;
        }
        desktopComputerRepository.save(desktopComputer);
        return true;
    }

    @Override
    public boolean updateDesktopComputer(String serialNumber, DesktopComputer desktopComputer) {
        if (productRepository.existsById(serialNumber)) {
            desktopComputerRepository.save(desktopComputer);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteDesktopComputerBySerialNumber(String serialNumber) {
        if (serialNumber == null) {
            return false;
        }
        desktopComputerRepository.deleteById(serialNumber);
        return true;
    }

    @Override
    public Optional<DesktopComputer> getDesktopComputerBySerialNumber(String serialNumber) {
        return desktopComputerRepository.findById(serialNumber);
    }

    @Override
    public List<DesktopComputer> getAllDesktopComputers() {
        return desktopComputerRepository.findAll();
    }
}
