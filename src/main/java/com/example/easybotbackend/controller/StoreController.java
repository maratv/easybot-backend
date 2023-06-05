package com.example.easybotbackend.controller;

import com.example.easybotbackend.domain.*;
import com.example.easybotbackend.dto.DesktopDto;
import com.example.easybotbackend.dto.DisplayDto;
import com.example.easybotbackend.dto.LaptopDto;
import com.example.easybotbackend.dto.StorageDto;
import com.example.easybotbackend.exception.ResourceNotFoundException;
import com.example.easybotbackend.service.StoreService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class StoreController {

    private final StoreService storeService;

    @GetMapping("/")
    public List<Device> getAllDevices() {
        return storeService.getAllDevices();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Device> getDeviceById(@PathVariable Long id) {
        Optional<Device> optionalDevice = storeService.getDeviceById(id);

        return optionalDevice
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException("Device with Id # '" + id + "' not found"));
    }

    @PostMapping("/{id}")
    public ResponseEntity<Device> updateDevice(@Valid @PathVariable Long id, @RequestBody RequestWrapper request) {
        Optional<Device> optionalDevice = storeService.updateDevice(id, request);
        return optionalDevice
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException("Device with Id # '" + id + "' not found"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        Optional<Device> optionalDevice = storeService.deleteDevice(id);
        if (optionalDevice.isPresent()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/laptop")
    public List<Laptop> getAllLaptops() {
        return storeService.getAllLaptops();
    }

    @PostMapping("/laptop")
    public ResponseEntity<Device> createLaptop(@Valid @RequestBody LaptopDto laptopDto) {
        Device device = storeService.createLaptop(laptopDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(device);
    }

    @GetMapping("/desktop")
    public List<Desktop> getAllDesktops() {
        return storeService.getAllDesktops();
    }

    @PostMapping("/desktop")
    public ResponseEntity<Device> createDesktop(@Valid @RequestBody DesktopDto desktopDto) {
        Device device = storeService.createDesktop(desktopDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(device);
    }

    @GetMapping("/display")
    public List<Display> getAllDisplays() {
        return storeService.getAllDisplays();
    }

    @PostMapping("/display")
    public ResponseEntity<Device> createDisplay(@Valid @RequestBody DisplayDto displayDto) {
        Device device = storeService.createDisplay(displayDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(device);
    }

    @GetMapping("/storage")
    public List<Storage> getAllStorages() {
        return storeService.getAllStorages();
    }

    @PostMapping("/storage")
    public ResponseEntity<Device> createStorage(@Valid @RequestBody StorageDto storageDto) {
        Device device = storeService.createStorage(storageDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(device);
    }


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
