package com.example.practice.car_domain.car.service;

import com.example.practice.car_domain.car.abstraction.CarService;
import com.example.practice.car_domain.car.object.Car;
import com.example.practice.car_domain.car.repository.CarMemoryRepository;
import com.example.practice.car_domain.car_function.service.CarFunctionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarMemoryRepository carMemoryRepository;
    private final CarFunctionService carFunctionService;

    @Override
    public void openGasHole(Car car) {
        carFunctionService.open(car);
    }

    @Override
    public void goAheadCar(Car car) {
        carFunctionService.goAhead(car);
        carMemoryRepository.update(car, car.getCarId());

        Car carr = carMemoryRepository.findById(car.getCarId());
        System.out.println("carr = " + carr);
    }
}
