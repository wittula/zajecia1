package com.company.devices;

import com.company.creatures.Human;
import com.company.Salable;

public class Phone extends Device implements Salable {
    final Double screenSize;
    final String operatingSystem;

    public Phone(String producer, String model, int yearOfProduction, Double screenSize, String operatingSystem) {
        super(producer, model, yearOfProduction);

        this.screenSize = screenSize;
        this.operatingSystem = operatingSystem;
    }

    public String toString() {
        return producer+" "+model+" "+screenSize+" "+operatingSystem+" "+yearOfProduction;
    }

    @Override
    public void turnOn() {
        System.out.println("[TELEFON] Urządzenie " + producer + " " + model + " włącza się.");
    }

    @Override
    public void sell(Human seller, Human buyer, Double price) {
        if (seller.mobilePhone != this) {
            System.out.println("Nie możesz sprzedawać kradzionych telefonów");
        } else if (buyer.cash < price) {
            System.out.println("Kupujący nie ma tylu pieniędzy");
        } else if (seller == buyer) {
            System.out.println("Nie możesz sprzedać telefonu sam sobie!");
        } else {
            buyer.cash -= price;
            seller.cash += price;
            buyer.mobilePhone = seller.mobilePhone;
            seller.mobilePhone = null;
            System.out.println("Udało się sprzedać telefon za " + price);
        }
    }
}
