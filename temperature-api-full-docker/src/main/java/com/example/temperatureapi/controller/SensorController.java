package com.example.temperatureapi.controller;

import com.example.temperatureapi.model.Sensor;
import com.example.temperatureapi.repository.SensorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sensors")
public class SensorController {

    private final SensorRepository repository;

    public SensorController(SensorRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Sensor> getAllSensors() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Sensor getSensor(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping
    public Sensor createSensor(@RequestBody Sensor sensor) {
        return repository.save(sensor);
    }

    @PutMapping("/{id}")
    public Sensor updateSensor(@PathVariable Long id, @RequestBody Sensor updated) {
        Sensor sensor = repository.findById(id).orElseThrow();
        sensor.setName(updated.getName());
        sensor.setType(updated.getType());
        sensor.setLocation(updated.getLocation());
        sensor.setUnit(updated.getUnit());
        return repository.save(sensor);
    }

    @DeleteMapping("/{id}")
    public void deleteSensor(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @PatchMapping("/{id}/value")
    public Sensor updateSensorValue(@PathVariable Long id, @RequestBody Sensor updated) {
        Sensor sensor = repository.findById(id).orElseThrow();
        sensor.setValue(updated.getValue());
        sensor.setStatus(updated.getStatus());
        return repository.save(sensor);
    }
}
