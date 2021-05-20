package com.company.devices;

public class Electric extends Car{

    public Electric(String producer, String model, int yearOfProduction) {
        super(producer, model, yearOfProduction);
    }

    @Override
    public void refuel() {
        System.out.println("Auto elektryczne " + producer + " " + model + " zostało naładowane.");
    }
}
