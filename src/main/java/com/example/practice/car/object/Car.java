package com.example.practice.car.object;

import com.example.practice.contract.car.CarFuelOpen;
import com.example.practice.contract.car.CarOnOff;
import com.example.practice.contract.car.CarType;

public class Car {

    private Long carId;
    private String carName;
    private CarType carType;
    private String createdYear;
    private Long gasAmount;
    private CarOnOff isOnOrOff;
    private CarFuelOpen isReadyToGetGas;
    private Long price;

    public Car(Long carId, String carName, CarType carType, String createdYear, Long gasAmount, CarOnOff isOnOrOff, CarFuelOpen isReadyToGetGas, Long price) {
        this.carId = carId;
        this.carName = carName;
        this.carType = carType;
        this.createdYear = createdYear;
        this.gasAmount = gasAmount;
        this.isOnOrOff = isOnOrOff;
        this.isReadyToGetGas = isReadyToGetGas;
        this.price = price;
    }

    public void setIsOnOrOff(CarOnOff isOnOrOff) {
        this.isOnOrOff = isOnOrOff;
    }

    public void setIsReadyToGetGas(CarFuelOpen isReadyToGetGas) {
        this.isReadyToGetGas = isReadyToGetGas;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public void setCreatedYear(String createdYear) {
        this.createdYear = createdYear;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public void setGasAmount(Long gasAmount) {
        this.gasAmount = gasAmount;
    }

    public Long getGasAmount() {
        return gasAmount;
    }

    public CarFuelOpen getIsReadyToGetGas() {
        return isReadyToGetGas;
    }

    public Long getCarId() {
        return carId;
    }

    public String getCarName() {
        return carName;
    }

    public CarType getCarType() {
        return carType;
    }

    public String getCreatedYear() {
        return createdYear;
    }

    public Long getPrice() {
        return price;
    }

    public CarOnOff getIsOnOrOff() {
        return isOnOrOff;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", carName='" + carName + '\'' +
                ", carType='" + carType + '\'' +
                ", createdYear='" + createdYear + '\'' +
                ", gasAmount='" + gasAmount + '\'' +
                ", isReadyToGetGas='" + isReadyToGetGas + '\'' +
                ", price=" + price +
                '}';
    }

    public Long calGasAmount (Long usedGas) {
        return this.gasAmount - usedGas;
    }
}
