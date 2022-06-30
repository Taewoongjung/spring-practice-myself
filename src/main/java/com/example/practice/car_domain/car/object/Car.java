package com.example.practice.car_domain.car.object;

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

    private void setIsReadyToGetGas(CarFuelOpen isReadyToGetGas) {
        this.isReadyToGetGas = isReadyToGetGas;
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

    public void calGasAmount(Long usedGas) {
        this.gasAmount = this.gasAmount - usedGas;
        System.out.println("계산 결과 = " + toString());
    }

    public void openGas() {
        this.setIsReadyToGetGas(CarFuelOpen.OPEN);
        System.out.println("가스구 결과 = " + toString());
    }

}
