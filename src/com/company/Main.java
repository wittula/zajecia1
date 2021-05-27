package com.company;

import com.company.creatures.Animal;
import com.company.creatures.FarmAnimal;
import com.company.creatures.Human;
import com.company.creatures.Pet;
import com.company.devices.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        Pet dog = new Pet("pitbull", 22.5, "Zwijka", null);
        FarmAnimal pig = new FarmAnimal("arkus gdynius", 43.5, "Świnka", null);

        Human pato = new Human("Łukasz", "Sztando");
        pato.pet = dog;
        pato.setSalary(5000.0);
        pato.cash = 6500.0;

        Car passat = new Diesel("Volkswagen","Passat B5", 2002, 3500.0);
        passat.mileage = 125000.0;
        passat.horsepower = 105;
        passat.color = "silver";
        passat.fuelType = "diesel";
        passat.engineVolume = 1.9;

        pato.setCar(passat, 0);

        Phone phone = new Phone("Apple",
                "iPhone 7",
                2016,
                1200.0,
                4.7,
                "iOS");

        dog.feed();
        pig.feed();

        dog.feed(1.3);
        pig.feed(7.5);

        dog.takeForAWalk();

        pig.beEaten();
        pig.beEaten();

        phone.installAnApp("Tinder");
        phone.installAnApp("Tinder", "1.4.2");
        phone.installAnApp("Tinder", "1.4.4", "tinder.com");

        List<String> appNames = new ArrayList<>();
        appNames.add("Yanosik");
        appNames.add("Steam");
        appNames.add("Messenger");

        phone.installAnApp(appNames);

        passat.refuel();

        Car astra = new LPG("Opel", "Astra Classic", 1999, 2000.0);
        astra.refuel();

        Car tesla = new Electric("Tesla", "S", 2021, 30000.0);
        tesla.refuel();

        Human najman = new Human("Marcin", "Najman", 3);
        najman.setSalary(100000.0);
        najman.cash = 19000.0;
        najman.setCar(passat, 0);
        najman.setCar(astra, 1);
        najman.setCar(tesla, 2);

        System.out.println(najman.getGarageValue());
        System.out.println(najman.sortGarage());

        astra.sell(najman, pato, 1900.0);
        System.out.println(najman);
    }
}
