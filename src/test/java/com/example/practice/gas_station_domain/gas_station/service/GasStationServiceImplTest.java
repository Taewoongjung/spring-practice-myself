package com.example.practice.gas_station_domain.gas_station.service;

import com.example.practice.car_domain.car.object.Car;
import com.example.practice.car_domain.car.repository.CarMemoryRepository;
import com.example.practice.contract.car.CarFuelOpen;
import com.example.practice.contract.car.CarOnOff;
import com.example.practice.contract.car.CarType;
import com.example.practice.gas_station_domain.gas_station.abstraction.GasStationRepository;
import com.example.practice.gas_station_domain.gas_station.object.GasStation;
import com.example.practice.gas_station_domain.gas_station.repository.GasStationMemoryRepository;
import com.example.practice.gas_station_domain.gas_station_function.service.GasStationFunctionService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GasStationServiceImplTest {

    @Test
    @DisplayName("주유구를 닫을 수 있다.")
    void closeGasHole() {
        // given
        GasStationRepository gasStationRepository = new GasStationMemoryRepository();
        gasStationRepository.save(new GasStation(1L, "HappyStation", "Hyundai", 2000, "TaeWoongJung"));

        CarMemoryRepository carMemoryRepository = new CarMemoryRepository();
        carMemoryRepository.save(new Car(1L, "GV80", CarType.SUV, "2022", 70, CarOnOff.ON, CarFuelOpen.OPEN, 70000000000L));

        GasStationFunctionService gasStationFunctionService = new GasStationFunctionService(carMemoryRepository);
        GasStationServiceImpl gasStationService = new GasStationServiceImpl(gasStationFunctionService);

        // when
        Car found = carMemoryRepository.findById(1L);
        gasStationService.closeGasHole(found);
        Car actual = carMemoryRepository.findById(1L);

        // then
        assertThat(actual.getIsReadyToGetGas()).isEqualTo(CarFuelOpen.CLOSED);
    }
}
