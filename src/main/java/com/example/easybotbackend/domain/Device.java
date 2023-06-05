package com.example.easybotbackend.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Device {

    @Id
    @GeneratedValue
    private Long id;

    private String series;

    private String manufacturer;

    private Double price;

    private Integer amount;

}
