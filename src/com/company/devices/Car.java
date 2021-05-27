package com.company.devices;

import com.company.creatures.Human;
import com.company.Salable;

import java.util.ArrayList;
import java.util.List;

public abstract class Car extends Device implements Salable {
    public Double mileage;
    public int horsepower;
    public String color;
    public String fuelType;
    public Double engineVolume;
    public List<Human> owners = new ArrayList<>();

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

    private boolean isLastOwner(Human person) {
        int ownersCount = this.owners.size();

        if (ownersCount == 0) {
            return false;
        }

        if (ownersCount == 1) {
            return this.owners.get(0) == person;
        }

        return person == (this.owners.get(ownersCount - 1));
    }

    public boolean wasEverOwner(Human person) {
        return this.owners.contains(person);
    }

    public Integer howManyTransactions() {
        return this.owners.size();
    }

    public boolean isSoldByTo(Human seller, Human buyer) {
        if (wasEverOwner(seller) && wasEverOwner(buyer)) {
            return this.owners.indexOf(buyer) == this.owners.indexOf(seller) + 1;
        }

        return false;
    }

    @Override
    public void sell(Human seller, Human buyer, Double price) throws Exception {
        if((!seller.hasCar(this)) || (!this.isLastOwner(seller))) {
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
