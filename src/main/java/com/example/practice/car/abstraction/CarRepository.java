package com.example.practice.car.abstraction;

import com.example.practice.car.object.Car;

public interface CarRepository {

    void save(Car car);

    Car findById(Long carId);
}
