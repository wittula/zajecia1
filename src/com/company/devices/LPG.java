package com.company.devices;

public class LPG extends Car{

    public LPG(String producer, String model, int yearOfProduction, Double value) {
        super(producer, model, yearOfProduction, value);
    }

    @Override
    public void refuel() {
        System.out.println("Auto na gaz " + producer + " " + model + " zostało zatankowane.");
    }
}
