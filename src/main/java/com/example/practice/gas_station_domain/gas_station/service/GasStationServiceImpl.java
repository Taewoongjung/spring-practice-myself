package com.example.practice.gas_station_domain.gas_station.service;

import com.example.practice.car_domain.car.object.Car;
import com.example.practice.gas_station_domain.gas_station.abstraction.GasStationService;
import com.example.practice.gas_station_domain.gas_station.object.GasStation;
import com.example.practice.gas_station_domain.gas_station_function.service.GasStationFunctionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GasStationServiceImpl implements GasStationService {

    private final GasStationFunctionService gasStationFunctionService;

    @Override
    public void fillGas(GasStation gasStation, Car car, int price) {
        gasStationFunctionService.fillGas(gasStation, car, price);
    }

    @Override
    public void closeGasHole(Car car) {
        gasStationFunctionService.closeGasHole(car);
    }

    @Override
    public void makePayment(Long carId, Long memberId) {

    }
}
