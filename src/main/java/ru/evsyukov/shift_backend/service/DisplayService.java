package ru.evsyukov.shift_backend.service;

import java.util.List;
import java.util.Optional;
import ru.evsyukov.shift_backend.entity.Display;

public interface DisplayService {

    boolean addDisplay(Display display);

    boolean updateDisplay(String serialNumber, Display display);

    boolean deleteDisplayBySerialNumber(String serialNumber);

    Optional<Display> getDisplayBySerialNumber(String serialNumber);

    List<Display> getAllDisplays();

}
