package com.example.practice.car_domain.car.abstraction;

import com.example.practice.car_domain.car.object.Car;

public interface CarService { // 자동차 고유의 기능들 모음

    void openGasHole(Car car);

    void goAheadCar(Car car);
}
