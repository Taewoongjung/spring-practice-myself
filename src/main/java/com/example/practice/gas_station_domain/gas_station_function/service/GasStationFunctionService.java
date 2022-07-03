package com.example.practice.gas_station_domain.gas_station_function.service;

import com.example.practice.car_domain.car.object.Car;
import com.example.practice.car_domain.car.repository.CarMemoryRepository;
import com.example.practice.contract.car.CarFuelOpen;
import com.example.practice.gas_station_domain.gas_station.object.GasStation;
import com.example.practice.gas_station_domain.gas_station_function.abstraction.GasStationFillGasFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GasStationFunctionService implements GasStationFillGasFunction{
    private final CarMemoryRepository carMemoryRepository;

    @Autowired
    public GasStationFunctionService(CarMemoryRepository carMemoryRepository) {
        this.carMemoryRepository = carMemoryRepository;
    }

    @Override
    public void fillGas(GasStation gasStation, Car car, int paid) {
        Car targetedCar = carMemoryRepository.findById(car.getCarId());
        if (targetedCar.getIsReadyToGetGas().equals(CarFuelOpen.OPEN)) {

            // 지불된 돈 만큼 채워야 하는 기름 (리터로)계산
            int filledAmount = gasStation.filling(paid);
            System.out.println("filledAmount = " + filledAmount);

            // 주유 하기
            car.takeGas(filledAmount);
            car.closeGas();
            carMemoryRepository.update(car, car.getCarId());
        }
    }
}
