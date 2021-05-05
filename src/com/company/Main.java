package com.company;

import com.company.devices.Car;
import com.company.devices.Phone;

public class Main {

    public static void main(String[] args) {
        Animal chicken = new Animal();
        chicken.name = "Koko";
        chicken.species = "Patochicken";
        chicken.weight = 2.3;

        Human pato = new Human();
        pato.firstName = "Łukasz";
        pato.lastName = "Sztando";
        pato.pet = chicken;
        pato.setSalary(5000.0);

        Car passat = new Car("Volkswagen","Passat B5", 2002, 1);
        passat.mileage = 125000.0;
        passat.horsepower = 105;
        passat.color = "silver";
        passat.fuelType = "diesel";
        passat.engineVolume = 1.9;
        passat.value = 3500.0;

        pato.setCar(passat);
        //pato.getCar();

        Car passat2 = new Car("Volkswagen","Passat B5", 2002, 1);
        passat2.mileage = 125000.0;
        passat2.horsepower = 105;
        passat2.color = "silver";
        passat2.fuelType = "diesel";
        passat2.engineVolume = 1.9;
        passat2.value = 3500.0;

        Phone phone = new Phone("Apple", "iPhone 7", 2016, 4.7, "iOS");

        phone.turnOn();
        passat.turnOn();

        pato.mobilePhone = phone;
        pato.cash = 40.0;

        Human stepBro = new Human();
        stepBro.cash = 1000.0;

        phone.sell(pato, pato, 500.0);
        phone.sell(stepBro, pato, 500.0);
        phone.sell(pato, stepBro, 5000.0);
        phone.sell(pato, stepBro, 500.0);

        System.out.println(pato.mobilePhone);
        System.out.println(stepBro.mobilePhone);

        Human slave = new Human();
        slave.sell(pato, stepBro, 100.0);

        chicken.sell(pato, stepBro, 400.0);
        System.out.println(pato.pet);
        System.out.println(stepBro.pet);

        passat.sell(pato, stepBro, 2300.0);
        System.out.println(pato.getCar());
        System.out.println(stepBro.getCar());
    }
}
