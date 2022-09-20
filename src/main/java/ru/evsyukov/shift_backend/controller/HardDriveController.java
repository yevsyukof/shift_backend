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
import ru.evsyukov.shift_backend.entity.HardDrive;
import ru.evsyukov.shift_backend.service.HardDriveService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/products/hard-drives")
public class HardDriveController {

    private final HardDriveService hardDriveService;

    @Transactional
    @PostMapping
    public ResponseEntity<?> addHardDrive(@Valid @RequestBody HardDrive hardDrive,
        BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return hardDriveService.addHardDrive(hardDrive)
            ? new ResponseEntity<>(HttpStatus.CREATED)
            : new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @GetMapping
    public ResponseEntity<?> findAllHardDrives() {
        List<HardDrive> hardDrives = hardDriveService.getAllHardDrives();
        return !hardDrives.isEmpty()
            ? new ResponseEntity<>(hardDrives, HttpStatus.OK)
            : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @GetMapping(value = "/{serialNumber}")
    public ResponseEntity<?> getHardDriveBySerialNumber(@PathVariable String serialNumber) {
        Optional<HardDrive> hardDrive = hardDriveService.getHardDriveBySerialNumber(serialNumber);
        return hardDrive.isPresent()
            ? new ResponseEntity<>(hardDrive, HttpStatus.OK)
            : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Transactional
    @PutMapping(value = "/{serialNumber}")
    public ResponseEntity<?> editHardDriveBySerialNumber(@PathVariable String serialNumber,
        @RequestBody @Valid HardDrive hardDrive) {
        return hardDriveService.updateHardDrive(serialNumber, hardDrive)
            ? new ResponseEntity<>(HttpStatus.OK)
            : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Transactional
    @DeleteMapping(value = "/{serialNumber}")
    public ResponseEntity<?> deleteHardDriveBySerialNumber(@PathVariable String serialNumber) {
        return hardDriveService.deleteHardDriveBySerialNumber(serialNumber)
            ? new ResponseEntity<>(HttpStatus.OK)
            : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
