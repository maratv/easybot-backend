package com.example.easybotbackend.dto;


import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class DisplayDto extends DeviceDto {

    private Integer diagonal;

}
