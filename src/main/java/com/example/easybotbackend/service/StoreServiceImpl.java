package com.example.easybotbackend.service;

import com.example.easybotbackend.controller.RequestWrapper;
import com.example.easybotbackend.domain.*;
import com.example.easybotbackend.dto.*;
import com.example.easybotbackend.repository.DeviceRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class StoreServiceImpl implements StoreService {

    private final DeviceRepository deviceRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    @Override
    public List<Laptop> getAllLaptops() {
        return deviceRepository.findAllLaptops();
    }

    @Override
    public List<Display> getAllDisplays() {
        return deviceRepository.findAllDisplays();
    }

    @Override
    public List<Desktop> getAllDesktops() {
        return deviceRepository.findAllDesktops();
    }

    @Override
    public List<Storage> getAllStorages() {
        return deviceRepository.findAllStorages();
    }

    @Override
    public Optional<Device> getDeviceById(Long id) {
        return deviceRepository.findById(id);
    }

    @Override
    public Device createLaptop(LaptopDto laptopDto) {
        Laptop device = modelMapper.map(laptopDto, Laptop.class);
        return deviceRepository.save(device);
    }

    @Override
    public Device createDesktop(DesktopDto desktopDto) {
        Desktop device = modelMapper.map(desktopDto, Desktop.class);
        return deviceRepository.save(device);
    }

    @Override
    public Device createDisplay(DisplayDto displayDto) {
        Display device = modelMapper.map(displayDto, Display.class);
        return deviceRepository.save(device);
    }

    @Override
    public Device createStorage(StorageDto storageDto) {
        Storage device = modelMapper.map(storageDto, Storage.class);
        return deviceRepository.save(device);
    }

    @Override
    public Optional<Device> updateDevice(Long id, RequestWrapper request) {
        Optional<Device> optionalDevice = deviceRepository.findById(id);
        if (optionalDevice.isPresent()) {
            Device device = optionalDevice.get();

            if (device instanceof Desktop desktop) {
                DesktopDto desktopDto = request.getDesktopDto();
                updateDeviceBaseFields(device, desktopDto);
                desktop.setDesktopFormFactor(desktopDto.getDesktopFormFactor() != null
                        ? desktopDto.getDesktopFormFactor()
                        : desktop.getDesktopFormFactor());
            }

            if (device instanceof Laptop laptop) {
                LaptopDto laptopDto = request.getLaptopDto();
                updateDeviceBaseFields(device, laptopDto);
                laptop.setLaptopSize(laptopDto.getLaptopSize() != null
                        ? laptopDto.getLaptopSize()
                        : laptop.getLaptopSize());
            }

//            if (device instanceof Desktop) {
//                Desktop desktop = (Desktop) device;
//                DesktopDto desktopDto = (DesktopDto) deviceDto;
//                desktop.setDesktopFormFactor(desktopDto.getDesktopFormFactor() != null
//                        ? desktopDto.getDesktopFormFactor()
//                        : desktop.getDesktopFormFactor());
//
//            }

//            else if (device instanceof Display display) {
//                DisplayDto displayDto = (DisplayDto) deviceDto;
//                display.setDiagonal(displayDto.getDiagonal() != null
//                        ? displayDto.getDiagonal()
//                        : display.getDiagonal());
//            }

//            if (device instanceof Laptop) {
//                ((Laptop) device).setLaptopSize(deviceDto.getLaptopSize() != null
//                        ? deviceDto.getLaptopSize()
//                        : ((Laptop) device).getLaptopSize());
//            }


            return Optional.of(deviceRepository.save(device));
        }
        return Optional.empty();
    }

    private void updateDeviceBaseFields(Device device, DeviceDto deviceDto) {

        device.setSeries(deviceDto.getSeries() != null ? deviceDto.getSeries() : device.getSeries());
        device.setManufacturer(deviceDto.getManufacturer() != null
                ? deviceDto.getManufacturer()
                : device.getManufacturer());
        device.setPrice(deviceDto.getPrice() != null ? deviceDto.getPrice() : device.getPrice());
        device.setAmount(deviceDto.getAmount() != null ? deviceDto.getAmount() : device.getAmount());


        //  return device;
    }

    @Override
    public Optional<Device> deleteDevice(Long id) {
        Optional<Device> optionalDevice = deviceRepository.findById(id);
        optionalDevice.ifPresent(device -> deviceRepository.delete(device));
        return optionalDevice;

    }
}
