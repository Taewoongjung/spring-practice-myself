package com.example.practice.car.object;

public class Car {

    private Long carId;
    private String carName;
    private String carType;
    private String createdYear;
    private String gasAmount;
    private String isReadyToGetGas;
    private Long price;

    public Car(Long carId, String carName, String carType, String createdYear, String gasAmount, String isReadyToGetGas, Long price) {
        this.carId = carId;
        this.carName = carName;
        this.carType = carType;
        this.createdYear = createdYear;
        this.gasAmount = gasAmount;
        this.isReadyToGetGas = isReadyToGetGas;
        this.price = price;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public void setCreatedYear(String createdYear) {
        this.createdYear = createdYear;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public void setGasAmount(String gasAmount) {
        this.gasAmount = gasAmount;
    }

    public String getGasAmount() {
        return gasAmount;
    }

    public String getIsReadyToGetGas() {
        return isReadyToGetGas;
    }

    public void setIsReadyToGetGas(String isReadyToGetGas) {
        this.isReadyToGetGas = isReadyToGetGas;
    }

    public Long getCarId() {
        return carId;
    }

    public String getCarName() {
        return carName;
    }

    public String getCarType() {
        return carType;
    }

    public String getCreatedYear() {
        return createdYear;
    }

    public Long getPrice() {
        return price;
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
}
