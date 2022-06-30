package com.example.practice.gas_station_domain.gas_station.repository;

import com.example.practice.gas_station_domain.gas_station.abstraction.GasStationRepository;
import com.example.practice.gas_station_domain.gas_station.object.GasStation;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class GasStationMemoryRepository implements GasStationRepository {

    private static Map<Long, GasStation> store = new HashMap<>();

    @Override
    public void save(GasStation gasStation) {
        store.put(gasStation.getGasStationId(), gasStation);
    }

    @Override
    public GasStation findById(Long gasStationId) {
        return store.get(gasStationId);
    }
}
