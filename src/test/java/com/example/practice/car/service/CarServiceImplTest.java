package com.example.practice.car.service;

import com.example.practice.AutoAppConfig;
import com.example.practice.car.object.Car;
import com.example.practice.car.repository.CarMemoryRepository;
import com.example.practice.car_function.service.CarFunctionService;
import com.example.practice.contract.car.CarFuelOpen;
import com.example.practice.contract.car.CarOnOff;
import com.example.practice.contract.car.CarType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

class CarServiceImplTest {

    @Test
    @DisplayName("자동차가 움직이면 기름이 소모된다.")
    void findCarTest() {
        // given
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        CarFunctionService carFunctionService = ac.getBean(CarFunctionService.class);
        CarMemoryRepository carMemoryRepository = ac.getBean(CarMemoryRepository.class);
        carMemoryRepository.save(new Car(1L, "GV80", CarType.SUV, "2022", 70L, CarOnOff.ON, CarFuelOpen.OPEN, 70000000000L));
        CarServiceImpl carServiceImpl = new CarServiceImpl(carMemoryRepository, carFunctionService);

        // when
        Car testCar = carMemoryRepository.findById(1L);
        carServiceImpl.goAheadCar(testCar);
        Car actual = carMemoryRepository.findById(1L);

        // then
        assertThat(actual).isNotNull();
        assertThat(actual.getGasAmount()).isEqualTo(60L);
    }

    @Test
    @DisplayName("주유구가 닫혀있으면 열 수 있다.")
    void openGas() {
        // given
        CarFunctionService carFunctionService = new CarFunctionService();
        CarMemoryRepository carMemoryRepository = new CarMemoryRepository();
        carMemoryRepository.save(new Car(1L, "GV80", CarType.SUV, "2022", 70L, CarOnOff.ON, CarFuelOpen.CLOSED, 70000000000L));
        CarServiceImpl carServiceImpl = new CarServiceImpl(carMemoryRepository, carFunctionService);

        // when
        Car testCar = carMemoryRepository.findById(1L);
        carServiceImpl.openGasHole(testCar);
        Car actual = carMemoryRepository.findById(1L);

        // then
        assertThat(actual).isNotNull();
        assertThat(actual.getIsReadyToGetGas()).isEqualTo(CarFuelOpen.OPEN);
    }
}
