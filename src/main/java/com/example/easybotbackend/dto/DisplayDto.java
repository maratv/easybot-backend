package com.example.easybotbackend.dto;


import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class DisplayDto extends DeviceDto {

//    @Size(min = 9, max = 55)
    private Integer diagonal;

}
