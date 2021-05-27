package com.company.devices;

public class Diesel extends Car{
    public Diesel(String producer, String model, int yearOfProduction, Double value) {
        super(producer, model, yearOfProduction, value);
    }

    @Override
    public void refuel() {
        System.out.println("Auto typu diesel " + producer + " " + model + " zostało zatankowane.");
    }
}
