package ru.evsyukov.shift_backend.service.implementation;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.evsyukov.shift_backend.entity.HardDrive;
import ru.evsyukov.shift_backend.repository.HardDriveRepository;
import ru.evsyukov.shift_backend.repository.ProductRepository;
import ru.evsyukov.shift_backend.service.HardDriveService;

@RequiredArgsConstructor
@Service
public class HardDriveServiceImpl implements HardDriveService {

    private final HardDriveRepository hardDriveRepository;

    private final ProductRepository productRepository;

    @Override
    public boolean addHardDrive(HardDrive hardDrive) {
        if (productRepository.existsById(hardDrive.getSerialNumber())) {
            return false;
        }
        hardDriveRepository.save(hardDrive);
        return true;
    }

    @Override
    public boolean updateHardDrive(String serialNumber, HardDrive hardDrive) {
        if (productRepository.existsById(serialNumber)) {
            hardDriveRepository.save(hardDrive);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteHardDriveBySerialNumber(String serialNumber) {
        if (serialNumber == null) {
            return false;
        }
        hardDriveRepository.deleteById(serialNumber);
        return true;
    }

    @Override
    public Optional<HardDrive> getHardDriveBySerialNumber(String serialNumber) {
        return hardDriveRepository.findById(serialNumber);
    }

    @Override
    public List<HardDrive> getAllHardDrives() {
        return hardDriveRepository.findAll();
    }
}
