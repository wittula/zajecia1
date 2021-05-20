package com.company.devices;

public abstract class Device {
    final String producer;
    final String model;
    final int yearOfProduction;

    public Device(String producer, String model, int yearOfProduction) {
        this.producer = producer;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
    }

//    public String toString() {
//        return producer + " " + model + " " + yearOfProduction;
//    }

    abstract public void turnOn();
}
