package com.example.practice.car.service;

import com.example.practice.AutoAppConfig;
import com.example.practice.car.object.Car;
import com.example.practice.car.repository.CarMemoryRepository;
import com.example.practice.car_function.service.CarFunctionService;
import com.example.practice.contract.car.CarFuelOpen;
import com.example.practice.contract.car.CarOnOff;
import com.example.practice.contract.car.CarType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

class CarServiceImplTest {

    @Test
    @DisplayName("findCarTest 메서드 호출")
    void findCarTest() {
        // given
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        CarServiceImpl carService = ac.getBean(CarServiceImpl.class);
        CarFunctionService carFunctionService = ac.getBean(CarFunctionService.class);
        CarMemoryRepository carMemoryRepository = ac.getBean(CarMemoryRepository.class);
        carMemoryRepository.save(new Car(1L, "GV80", CarType.SUV, "2022", 70L, CarOnOff.OFF, CarFuelOpen.OPEN, 70000000000L));

        // when
        Car actual = carService.findCar(1L);

        // then
        assertThat(actual).isNotNull();
        assertThat(actual.getCarId()).isEqualTo(1L);
        assertThat(actual.getCarType()).isEqualTo(CarType.SUV);
        assertThat(actual.getCreatedYear()).isEqualTo("2022");
        assertThat(actual.getGasAmount()).isEqualTo(70L);
        assertThat(actual.getIsOnOrOff()).isEqualTo(CarOnOff.OFF);
        assertThat(actual.getIsReadyToGetGas()).isEqualTo(CarFuelOpen.OPEN);
        assertThat(actual.getPrice()).isEqualTo(70000000000L);
    }
}