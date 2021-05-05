package com.company.devices;

import com.company.creatures.Human;
import com.company.Salable;

public class Car extends Device implements Salable {
    public final int id;
    public Double mileage;
    public int horsepower;
    public String color;
    public String fuelType;
    public Double engineVolume;
    public Double value;

    public Car(String producer, String model, int yearOfProduction, int id) {
        super(producer, model, yearOfProduction);
        this.id = id;
    }

    public String toString() {
        return id+" "+producer+" "+model+" "+yearOfProduction+" "+mileage+ " " +
                horsepower+" "+color+" "+fuelType+" "+
                engineVolume+" "+value;
    }

    @Override
    public void turnOn() {
        System.out.println("[SAMOCHÓD] Urządzenie " + producer + " " + model + " włącza się.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return id == car.id &&
                model.equals(car.model) &&
                mileage.equals(car.mileage) &&
                horsepower == car.horsepower &&
                color.equals(car.color) &&
                fuelType.equals(car.fuelType) &&
                engineVolume.equals(car.engineVolume) &&
                value.equals(car.value) &&
                producer.equals(car.producer);
    }

    @Override
    public int hashCode() {
        return id;
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
}
