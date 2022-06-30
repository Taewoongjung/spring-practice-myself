package com.example.practice.gas_station_domain.gas_station_function.service;

import com.example.practice.AutoAppConfig;
import com.example.practice.car_domain.car.object.Car;
import com.example.practice.car_domain.car.repository.CarMemoryRepository;
import com.example.practice.contract.car.CarFuelOpen;
import com.example.practice.contract.car.CarOnOff;
import com.example.practice.contract.car.CarType;
import com.example.practice.gas_station_domain.gas_station.abstraction.GasStationRepository;
import com.example.practice.gas_station_domain.gas_station.object.GasStation;
import com.example.practice.gas_station_domain.gas_station.repository.GasStationMemoryRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

class GasStationFunctionServiceTest {

    @Test
    @DisplayName("주유를 할 수 있다.")
    void fillGasTest() {
        // given
        GasStationRepository gasStationRepository = new GasStationMemoryRepository();
        gasStationRepository.save(new GasStation(1L, "HappyStation", "Hyundai", 2000, "TaeWoongJung"));

        CarMemoryRepository carMemoryRepository = new CarMemoryRepository();
        carMemoryRepository.save(new Car(1L, "GV80", CarType.SUV, "2022", 70, CarOnOff.ON, CarFuelOpen.OPEN, 70000000000L));

        GasStationFunctionService gasStationFunctionService = new GasStationFunctionService(carMemoryRepository);
        Car foundCar = carMemoryRepository.findById(1L);
        GasStation foundGasStation = gasStationRepository.findById(1L);

        // when
        int calGas = foundGasStation.filling(70000);
        int result = foundCar.getGasAmount() + calGas;

        gasStationFunctionService.fillGas(foundGasStation, foundCar, 70000);

        Car actual = carMemoryRepository.findById(1L);

        // then
         assertThat(actual).isNotNull();
         assertThat(actual.getGasAmount()).isEqualTo(result);
         assertThat(actual.getIsReadyToGetGas()).isEqualTo(CarFuelOpen.CLOSED);
    }
}