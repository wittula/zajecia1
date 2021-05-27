package com.company.devices;

public class Electric extends Car{

    public Electric(String producer, String model, int yearOfProduction, Double value) {
        super(producer, model, yearOfProduction, value);
    }

    @Override
    public void refuel() {
        System.out.println("Auto elektryczne " + producer + " " + model + " zostało naładowane.");
    }
}
