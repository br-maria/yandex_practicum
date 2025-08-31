package com.example.temperatureapi.controller;

import com.example.temperatureapi.model.Sensor;
import com.example.temperatureapi.repository.SensorRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class TemperatureController {

    private final SensorRepository repository;
    private final Random random = new Random();

    public TemperatureController(SensorRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/temperature")
    public Double getTemperature(@RequestParam String location) {
        Sensor sensor = repository.findByLocation(location).orElseThrow();
        return 15 + random.nextDouble() * 25;
    }
}
