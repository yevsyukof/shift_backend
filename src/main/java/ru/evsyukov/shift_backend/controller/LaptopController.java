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
import ru.evsyukov.shift_backend.entity.Laptop;
import ru.evsyukov.shift_backend.service.LaptopService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/products/laptops")
public class LaptopController {

    private final LaptopService laptopService;

    @Transactional
    @PostMapping
    public ResponseEntity<?> addLaptop(@Valid @RequestBody Laptop laptop,
        BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return laptopService.addLaptop(laptop)
            ? new ResponseEntity<>(HttpStatus.CREATED)
            : new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @GetMapping
    public ResponseEntity<?> findAllLaptops() {
        List<Laptop> laptops = laptopService.getAllLaptops();
        return !laptops.isEmpty()
            ? new ResponseEntity<>(laptops, HttpStatus.OK)
            : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/{serialNumber}")
    public ResponseEntity<?> getLaptopBySerialNumber(@PathVariable String serialNumber) {
        Optional<Laptop> laptop = laptopService.getLaptopBySerialNumber(serialNumber);
        return laptop.isPresent()
            ? new ResponseEntity<>(laptop, HttpStatus.OK)
            : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Transactional
    @PutMapping(value = "/{serialNumber}")
    public ResponseEntity<?> editLaptopBySerialNumber(@PathVariable String serialNumber,
        @RequestBody @Valid Laptop laptop) {
        return laptopService.updateLaptop(serialNumber, laptop)
            ? new ResponseEntity<>(HttpStatus.OK)
            : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Transactional
    @DeleteMapping(value = "/{serialNumber}")
    public ResponseEntity<?> deleteLaptopBySerialNumber(@PathVariable String serialNumber) {
        return laptopService.deleteLaptopBySerialNumber(serialNumber)
            ? new ResponseEntity<>(HttpStatus.OK)
            : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}

