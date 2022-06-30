package com.example.practice.car_domain.car.repository;

import com.example.practice.car_domain.car.object.Car;
import com.example.practice.contract.car.CarFuelOpen;
import com.example.practice.contract.car.CarOnOff;
import com.example.practice.contract.car.CarType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarMemoryRepositoryTest {

    @Test
    @DisplayName("CarMemoryRepository 는 새로운 값을 가질 수 있다.")
    void car() {
        // given
        CarMemoryRepository carMemoryRepository = new CarMemoryRepository();
        Long carId = 1L;
        carMemoryRepository.save(new Car(carId, "GV80", CarType.SUV, "2022", 70, CarOnOff.OFF, CarFuelOpen.OPEN, 70000000000L));

        // when
        final Car actual = carMemoryRepository.findById(carId);

        // then
        assertThat(actual).isNotNull();
        assertThat(actual.getCarId()).isEqualTo(1L);
        assertThat(actual.getCarType()).isEqualTo(CarType.SUV);
        assertThat(actual.getCreatedYear()).isEqualTo("2022");
        assertThat(actual.getGasAmount()).isEqualTo(70);
        assertThat(actual.getIsOnOrOff()).isEqualTo(CarOnOff.OFF);
        assertThat(actual.getIsReadyToGetGas()).isEqualTo(CarFuelOpen.OPEN);
        assertThat(actual.getPrice()).isEqualTo(70000000000L);
    }
}
