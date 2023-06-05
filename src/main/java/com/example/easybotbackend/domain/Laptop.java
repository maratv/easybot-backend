package com.example.easybotbackend.domain;

import com.example.easybotbackend.domain.enums.LaptopSize;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Laptop extends Device {


    @Enumerated(EnumType.STRING)
    private LaptopSize laptopSize;
}


