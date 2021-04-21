package com.company;

public class Car {
    public final String producer;
    public final String model;
    public Double mileage;
    int horsepower;
    String color;
    String fuelType;
    Double engineVolume;

    public Car(String model, String producer) {
        this.model = model;
        this.producer = producer;
    }
}
