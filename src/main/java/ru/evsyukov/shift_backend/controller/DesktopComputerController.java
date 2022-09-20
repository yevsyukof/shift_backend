package ru.evsyukov.shift_backend.controller;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.evsyukov.shift_backend.entity.DesktopComputer;
import ru.evsyukov.shift_backend.service.DesktopComputerService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/products/desktop-computers")
public class DesktopComputerController {

    private final DesktopComputerService desktopComputerService;

    @Transactional
    @PostMapping
    public ResponseEntity<?> addDesktopComputer(@Valid @RequestBody DesktopComputer desktopComputer,
        BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return desktopComputerService.addDesktopComputer(desktopComputer)
            ? new ResponseEntity<>(HttpStatus.CREATED)
            : new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @GetMapping
    public ResponseEntity<?> findAllDesktopComputers() {
        List<DesktopComputer> desktopComputers = desktopComputerService.getAllDesktopComputers();
        return !desktopComputers.isEmpty()
            ? new ResponseEntity<>(desktopComputers, HttpStatus.OK)
            : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @GetMapping(value = "/{serialNumber}")
    public ResponseEntity<?> getDesktopComputerBySerialNumber(@PathVariable String serialNumber) {
        Optional<DesktopComputer> desktopComputer =
            desktopComputerService.getDesktopComputerBySerialNumber(serialNumber);
        return desktopComputer.isPresent()
            ? new ResponseEntity<>(desktopComputer, HttpStatus.OK)
            : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Transactional
    @PutMapping(value = "/{serialNumber}")
    public ResponseEntity<?> editDesktopComputerBySerialNumber(@PathVariable String serialNumber,
        @RequestBody @Valid DesktopComputer desktopComputer) {
        return desktopComputerService.updateDesktopComputer(serialNumber, desktopComputer)
            ? new ResponseEntity<>(HttpStatus.OK)
            : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Transactional
    @DeleteMapping(value = "/{serialNumber}")
    public ResponseEntity<?> deleteDesktopComputerBySerialNumber(
        @PathVariable String serialNumber) {
        return desktopComputerService.deleteDesktopComputerBySerialNumber(serialNumber)
            ? new ResponseEntity<>(HttpStatus.OK)
            : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
