package com.example.easybotbackend.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class StorageDto extends DeviceDto {

    private Integer storageSize;

}
