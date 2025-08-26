package com.example.temperatureapi.controller;

import com.example.temperatureapi.model.TemperatureResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class TemperatureController {

    @GetMapping("/temperature")
    public TemperatureResponse getTemperature(
            @RequestParam(required = false) String location,
            @RequestParam(required = false) String sensorId) {

        // Определение location и sensorId
        if (location == null || location.isEmpty()) {
            switch (sensorId) {
                case "1":
                    location = "Living Room";
                    break;
                case "2":
                    location = "Bedroom";
                    break;
                case "3":
                    location = "Kitchen";
                    break;
                default:
                    location = "Unknown";
            }
        }

        if (sensorId == null || sensorId.isEmpty()) {
            switch (location) {
                case "Living Room":
                    sensorId = "1";
                    break;
                case "Bedroom":
                    sensorId = "2";
                    break;
                case "Kitchen":
                    sensorId = "3";
                    break;
                default:
                    sensorId = "0";
            }
        }

        // Генерация случайной температуры
        Random random = new Random();
        double temperature = 15 + random.nextDouble() * 25; // от 15 до 40 градусов

        TemperatureResponse response = new TemperatureResponse();
        response.setSensorId(sensorId);
        response.setLocation(location);
        response.setTemperature(temperature);

        return response;
    }
}
