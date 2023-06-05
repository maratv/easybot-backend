package com.example.easybotbackend.dto;

import com.example.easybotbackend.domain.enums.DesktopFormFactor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class DesktopDto extends DeviceDto {

    private DesktopFormFactor desktopFormFactor;


}
