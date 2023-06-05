package com.example.easybotbackend.service;

import com.example.easybotbackend.controller.RequestWrapper;
import com.example.easybotbackend.domain.*;
import com.example.easybotbackend.dto.*;

import java.util.List;
import java.util.Optional;

public interface StoreService {

    List<Device> getAllDevices();

    List<Laptop> getAllLaptops();

    List<Display> getAllDisplays();

    List<Desktop> getAllDesktops();

    List<Storage> getAllStorages();

    Optional<Device> getDeviceById(Long id);

    Device createLaptop(LaptopDto laptopDto);

    Device createDesktop(DesktopDto desktopDto);

    Device createDisplay(DisplayDto displayDto);

    Device createStorage(StorageDto storageDto);

    Optional<Device> updateDevice(Long id, RequestWrapper request);

    Optional<Device> deleteDevice(Long id);


}
