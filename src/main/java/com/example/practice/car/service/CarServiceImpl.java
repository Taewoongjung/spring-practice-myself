package com.example.practice.car.service;

import com.example.practice.car.abstraction.CarService;
import com.example.practice.car.object.Car;
import com.example.practice.car.repository.CarMemoryRepository;
import com.example.practice.contract.car.CarOnOff;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarMemoryRepository carMemoryRepository;

    @Override
    public Car findCar(Long carId) {
        return carMemoryRepository.findById(carId);
    }
}
