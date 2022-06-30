package com.example.practice.gas_station_domain.gas_station.object;

public class GasStation {

    private Long memberId;
    private String name; // 주유소 이름
    private String brand; // 주유소 브랜드
    private Integer price; // L 당 가격
    private String ownerName; // 사장님 성함

    public GasStation(Long memberId, String name, String brand, Integer price, String ownerName) {
        this.memberId = memberId;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.ownerName = ownerName;
    }

    public Long getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public Integer getPrice() {
        return price;
    }

    public String getOwnerName() {
        return ownerName;
    }

    @Override
    public String toString() {
        return "GasStation{" +
                "memberId=" + memberId +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", ownerName='" + ownerName + '\'' +
                '}';
    }
}