package com.company.devices;

import com.company.creatures.Human;
import com.company.Salable;

public abstract class Car extends Device implements Salable {
    public Double mileage;
    public int horsepower;
    public String color;
    public String fuelType;
    public Double engineVolume;

    public Car(String producer, String model, int yearOfProduction, Double value) {
        super(producer, model, yearOfProduction, value);
    }

    public String toString() {
        return "\nCar {\n" +
                "   producer = '" + producer + '\'' +
                ",\n   model = '" + model + '\'' +
                ",\n   yearOfProduction = " + yearOfProduction +
                ",\n   horsepower = " + horsepower +
                ",\n   fuelType = " + fuelType +
                ",\n   engineVolume = " + engineVolume +
                ",\n   color = " + color +
                ",\n   value = " + value +
                "\n}\n";
    }

    @Override
    public void turnOn() {
        System.out.println("[SAMOCHÓD] Urządzenie " + producer + " " + model + " włącza się.");
    }

    @Override
    public void sell(Human seller, Human buyer, Double price) throws Exception {
        if(!seller.hasCar(this)) {
            throw new Exception("Sprzedający nie posiada tego samochodu!");
        }

        if(!buyer.hasFreeSpace()){
            throw new Exception("Kupujący nie ma miejsca w swoim garażu!");
        }

        if (buyer.cash < price){
            throw new Exception("Kupujący nie ma tylu pieniędzy!");
        }
        seller.removeCar(this);
        buyer.addCar(this);

        seller.cash += price;
        buyer.cash -= price;

        System.out.println("Sprzedano!");
    }

    public abstract void refuel();
}
