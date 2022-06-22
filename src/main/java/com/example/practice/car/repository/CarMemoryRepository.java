package com.example.practice.car.repository;

import com.example.practice.car.abstraction.CarRepository;
import com.example.practice.car.object.Car;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CarMemoryRepository implements CarRepository {

    private static Map<Long, Car> store = new HashMap<>();

    @Override
    public void save(Car car) {
        store.put(car.getCarId(), car);
    }

    @Override
    public void update(Car car, Long id) {
        store.put(id, car);
    }

    @Override
    public Car findById(Long carId) {
        return store.get(carId);
    }
}
