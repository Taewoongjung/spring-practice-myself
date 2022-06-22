package com.example.practice.car.abstraction;

import com.example.practice.car.object.Car;

public interface CarRepository {

    void save(Car car);

    void update(Car car, Long id);

    Car findById(Long carId);
}
