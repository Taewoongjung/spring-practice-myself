package com.example.practice.gas_station_domain.gas_station.abstraction;

import com.example.practice.car_domain.car.object.Car;
import com.example.practice.gas_station_domain.gas_station.object.GasStation;

public interface GasStationService {

    void fillGas(GasStation gasStation, Car car, int price);

    void closeGasHole(Car car);

    void makePayment(Long carId, Long memberId);
}
