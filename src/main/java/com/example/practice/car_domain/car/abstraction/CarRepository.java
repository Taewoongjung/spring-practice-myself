package com.example.practice.car_domain.car.abstraction;

import com.example.practice.car_domain.car.object.Car;

public interface CarRepository {

    void save(Car car);

    void update(Car car, Long id);

    Car findById(Long carId);
}
