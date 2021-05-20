package com.company.devices;

import com.company.creatures.Human;
import com.company.Salable;

public abstract class Car extends Device implements Salable {
    public Double mileage;
    public int horsepower;
    public String color;
    public String fuelType;
    public Double engineVolume;
    public Double value;

    public Car(String producer, String model, int yearOfProduction) {
        super(producer, model, yearOfProduction);
    }

//    public String toString() {
//        return producer+" "+model+" "+yearOfProduction+" "+mileage+ " " +
//                horsepower+" "+color+" "+fuelType+" "+
//                engineVolume+" "+value;
//    }

    @Override
    public void turnOn() {
        System.out.println("[SAMOCHÓD] Urządzenie " + producer + " " + model + " włącza się.");
    }

    @Override
    public void sell(Human seller, Human buyer, Double price) {
        if (seller.getCar() != this) {
            System.out.println("Nie możesz sprzedawać kradzionych samochodów");
        } else if (buyer.cash < price) {
            System.out.println("Kupujący nie ma tylu pieniędzy");
        } else if (seller == buyer) {
            System.out.println("Nie możesz sprzedać samochodu sam sobie!");
        } else {
            buyer.cash -= price;
            seller.cash += price;
            buyer.setCar(seller.getCar());
            seller.takeCar();
            System.out.println("Udało się sprzedać samochód za " + price);
        }
    }

    public abstract void refuel();
}
