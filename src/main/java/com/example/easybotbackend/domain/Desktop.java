package com.example.easybotbackend.domain;

import com.example.easybotbackend.domain.enums.DesktopFormFactor;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Desktop extends Device{

    @Enumerated(EnumType.STRING)
    private DesktopFormFactor desktopFormFactor;

}
