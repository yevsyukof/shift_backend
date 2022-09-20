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
import ru.evsyukov.shift_backend.entity.Display;
import ru.evsyukov.shift_backend.service.DisplayService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/products/displays")
public class DisplayController {

    private final DisplayService displayService;

    @Transactional
    @PostMapping
    public ResponseEntity<?> addDisplay(@Valid @RequestBody Display display,
        BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return displayService.addDisplay(display)
            ? new ResponseEntity<>(HttpStatus.CREATED)
            : new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @GetMapping
    public ResponseEntity<?> findAllDisplays() {
        List<Display> displays = displayService.getAllDisplays();
        return !displays.isEmpty()
            ? new ResponseEntity<>(displays, HttpStatus.OK)
            : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @GetMapping(value = "/{serialNumber}")
    public ResponseEntity<?> getDisplayBySerialNumber(@PathVariable String serialNumber) {
        Optional<Display> display = displayService.getDisplayBySerialNumber(serialNumber);
        return display.isPresent()
            ? new ResponseEntity<>(display, HttpStatus.OK)
            : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Transactional
    @PutMapping(value = "/{serialNumber}")
    public ResponseEntity<?> editDisplayBySerialNumber(@PathVariable String serialNumber,
        @RequestBody @Valid Display display) {
        return displayService.updateDisplay(serialNumber, display)
            ? new ResponseEntity<>(HttpStatus.OK)
            : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Transactional
    @DeleteMapping(value = "/{serialNumber}")
    public ResponseEntity<?> deleteDisplayBySerialNumber(@PathVariable String serialNumber) {
        return displayService.deleteDisplayBySerialNumber(serialNumber)
            ? new ResponseEntity<>(HttpStatus.OK)
            : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
