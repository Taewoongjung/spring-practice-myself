package com.example.practice.car.abstraction;

import com.example.practice.car.object.Car;

public interface CarService { // 자동차 고유의 기능들 모음
    Car findCar(Long carId);

    void goAheadCar(Car car);
}
