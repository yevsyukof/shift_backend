package ru.evsyukov.shift_backend.service;

import java.util.List;
import java.util.Optional;
import ru.evsyukov.shift_backend.entity.HardDrive;

public interface HardDriveService {

    boolean addHardDrive(HardDrive hardDrive);

    boolean updateHardDrive(String serialNumber, HardDrive hardDrive);

    boolean deleteHardDriveBySerialNumber(String serialNumber);

    Optional<HardDrive> getHardDriveBySerialNumber(String serialNumber);

    List<HardDrive> getAllHardDrives();
}
