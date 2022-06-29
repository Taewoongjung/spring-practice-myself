package com.example.practice.car_function.service;

import com.example.practice.car.object.Car;
import com.example.practice.car.repository.CarMemoryRepository;
import com.example.practice.car.service.CarServiceImpl;
import com.example.practice.contract.car.CarFuelOpen;
import com.example.practice.contract.car.CarOnOff;
import com.example.practice.contract.car.CarType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarFunctionServiceTest {

    @Test
    @DisplayName("자동차가 엑셀을 밟으면 가스가 깍인다.")
    void goAheadTest() {

        // given
        CarFunctionService carFunctionService = new CarFunctionService();
        CarMemoryRepository carMemoryRepository = new CarMemoryRepository();
        carMemoryRepository.save(new Car(1L, "GV80", CarType.SUV, "2022", 70L, CarOnOff.ON, CarFuelOpen.OPEN, 70000000000L));
        CarServiceImpl carServiceImpl = new CarServiceImpl(carMemoryRepository, carFunctionService);

        // when
        Car result = carMemoryRepository.findById(1L);
        System.out.println("result = " + result);
        carServiceImpl.goAheadCar(result);
        Car actual = carMemoryRepository.findById(1L);

        // then
        assertThat(actual).isNotNull();
        assertThat(actual.getGasAmount()).isEqualTo(60L);
    }

    @Test
    @DisplayName("자동차 가스 주입구를 연다.")
    void open() {

        // given
        CarFunctionService carFunctionService = new CarFunctionService();
        CarMemoryRepository carMemoryRepository = new CarMemoryRepository();
        carMemoryRepository.save(new Car(1L, "GV80", CarType.SUV, "2022", 70L, CarOnOff.ON, CarFuelOpen.CLOSED, 70000000000L));
        CarServiceImpl carServiceImpl = new CarServiceImpl(carMemoryRepository, carFunctionService);

        // when
        Car actual = carMemoryRepository.findById(1L);
        carServiceImpl.openGasHole(actual);

        // then
        assertThat(actual).isNotNull();
        assertThat(actual.getIsReadyToGetGas()).isEqualTo(CarFuelOpen.OPEN);
    }
}
