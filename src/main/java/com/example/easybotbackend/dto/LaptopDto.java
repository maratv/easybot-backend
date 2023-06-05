package com.example.easybotbackend.dto;

import com.example.easybotbackend.domain.enums.LaptopSize;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class LaptopDto extends DeviceDto {

    private LaptopSize laptopSize;

}
