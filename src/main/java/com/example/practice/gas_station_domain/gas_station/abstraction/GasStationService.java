package com.example.practice.gas_station_domain.gas_station.abstraction;

import com.example.practice.car_domain.car.object.Car;

public interface GasStationService {

    void fillGas(int price);

    void closeGasHole(Car car);
}
