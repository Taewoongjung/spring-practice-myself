package com.example.practice.car_function.service;

import com.example.practice.car.object.Car;
import com.example.practice.car_function.abstraction.CarFunction;
import com.example.practice.contract.car.CarOnOff;
import org.springframework.stereotype.Component;

@Component
public class CarFunctionService implements CarFunction {

    @Override
    public void goAhead(Car car) {
        if (car.getIsOnOrOff() == CarOnOff.ON) {
            car.calGasAmount(10L);
        }
        return;
    }
}
