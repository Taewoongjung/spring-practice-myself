package com.example.practice.gas_station_domain.gas_station.abstraction;

import com.example.practice.gas_station_domain.gas_station.object.GasStation;

public interface GasStationRepository {

    void save(GasStation gasStation);

    GasStation findById(Long gasStationId);
}
