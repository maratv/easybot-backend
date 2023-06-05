package com.example.easybotbackend.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Display extends Device {

//    @Size(min = 9, max = 55)
    private Integer diagonal;
}