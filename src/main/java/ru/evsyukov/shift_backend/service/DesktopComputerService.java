package ru.evsyukov.shift_backend.service;

import java.util.List;
import java.util.Optional;
import ru.evsyukov.shift_backend.entity.DesktopComputer;

public interface DesktopComputerService {

    boolean addDesktopComputer(DesktopComputer desktopComputer);

    boolean updateDesktopComputer(String serialNumber, DesktopComputer desktopComputer);

    boolean deleteDesktopComputerBySerialNumber(String serialNumber);

    Optional<DesktopComputer> getDesktopComputerBySerialNumber(String serialNumber);

    List<DesktopComputer> getAllDesktopComputers();
}
