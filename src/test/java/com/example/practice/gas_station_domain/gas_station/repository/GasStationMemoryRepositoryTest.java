package com.example.practice.gas_station_domain.gas_station.repository;

import com.example.practice.AutoAppConfig;
import com.example.practice.gas_station_domain.gas_station.abstraction.GasStationRepository;
import com.example.practice.gas_station_domain.gas_station.object.GasStation;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

class GasStationMemoryRepositoryTest {

    @Test
    @DisplayName("GasStationMemoryRepositoryTest 는 새로운 값을 가질 수 있다.")
    void saveTest() {
        // given
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        GasStationRepository gasStationRepository = ac.getBean(GasStationRepository.class);
        Long gasStationId = 1L;
        gasStationRepository.save(new GasStation(gasStationId, "HappyStation", "Hyundai", 2000, "TaeWoongJung"));

        // when
        GasStation actual = gasStationRepository.findById(gasStationId);

        // then
         assertThat(actual).isNotNull();
         assertThat(actual.getGasStationId()).isEqualTo(1L);
         assertThat(actual.getName()).isEqualTo("HappyStation");
         assertThat(actual.getBrand()).isEqualTo("Hyundai");
         assertThat(actual.getPrice()).isEqualTo(2000);
         assertThat(actual.getOwnerName()).isEqualTo("TaeWoongJung");
    }
}