package com.example.easybotbackend.controller;

import com.example.easybotbackend.dto.*;
import lombok.Data;

@Data
public class RequestWrapper {
    private DeviceDto deviceDto;
    private DesktopDto desktopDto;
    private DisplayDto displayDto;
    private LaptopDto laptopDto;
    private StorageDto storageDto;
}
