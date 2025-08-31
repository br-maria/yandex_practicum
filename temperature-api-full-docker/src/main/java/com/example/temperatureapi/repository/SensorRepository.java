package com.example.temperatureapi.repository;

import com.example.temperatureapi.model.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SensorRepository extends JpaRepository<Sensor, Long> {
    Optional<Sensor> findByLocation(String location);
}
