package com.example.easybotbackend.dto;

import lombok.Data;

@Data
public class DeviceDto {

    private String series;

    private String manufacturer;

    private Double price;

    private Integer amount;

}
