package com.example.easybotbackend.repository;

import com.example.easybotbackend.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {

    @Query(value = "SELECT * FROM laptop", nativeQuery = true)
    List<Laptop> findAllLaptops();

    @Query(value = "SELECT * FROM display", nativeQuery = true)
    List<Display> findAllDisplays();

    @Query(value = "SELECT * FROM desktop", nativeQuery = true)
    List<Desktop> findAllDesktops();

    @Query(value = "SELECT * FROM storage", nativeQuery = true)
    List<Storage> findAllStorages();


}
