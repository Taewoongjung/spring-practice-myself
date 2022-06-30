package com.example.practice.gas_station_domain.gas_station_function.abstraction;

import com.example.practice.car_domain.car.object.Car;
import com.example.practice.gas_station_domain.gas_station.object.GasStation;

public interface GasStationFillGasFunction {
    void fillGas(GasStation gasStation, Car car, int paid);
}
