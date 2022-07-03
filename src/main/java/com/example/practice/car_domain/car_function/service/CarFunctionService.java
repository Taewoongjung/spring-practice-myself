package com.example.practice.car_domain.car_function.service;

import com.example.practice.car_domain.car.object.Car;
import com.example.practice.car_domain.car_function.abstraction.CarFuelOpenFunction;
import com.example.practice.car_domain.car_function.abstraction.CarGoFunction;
import com.example.practice.contract.car.CarFuelOpen;
import com.example.practice.contract.car.CarOnOff;
import org.springframework.stereotype.Component;

@Component
public class CarFunctionService
        implements
            CarGoFunction,
            CarFuelOpenFunction
{

    @Override
    public void goAhead(Car car) {
        if (car.getIsOnOrOff() == CarOnOff.ON) {
            car.calGasAmount(10);
        }
    }

    @Override
    public void open(Car car) {
        if (car.getIsReadyToGetGas() == CarFuelOpen.CLOSED) {
            car.openGas();
        }
    }
}
