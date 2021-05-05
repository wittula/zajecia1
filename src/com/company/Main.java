package com.company;

import com.company.creatures.Animal;
import com.company.creatures.FarmAnimal;
import com.company.creatures.Human;
import com.company.creatures.Pet;
import com.company.devices.Car;
import com.company.devices.Phone;

public class Main {

    public static void main(String[] args) {
        Pet dog = new Pet("pitbull", 22.5, "Zwijka", null);
        FarmAnimal pig = new FarmAnimal("arkus gdynius", 43.5, "Świnka", null);

        Human pato = new Human("Łukasz", "Sztando");
        pato.pet = dog;
        pato.setSalary(5000.0);

        Car passat = new Car("Volkswagen","Passat B5", 2002, 1);
        passat.mileage = 125000.0;
        passat.horsepower = 105;
        passat.color = "silver";
        passat.fuelType = "diesel";
        passat.engineVolume = 1.9;
        passat.value = 3500.0;

        pato.setCar(passat);

        Phone phone = new Phone("Apple", "iPhone 7", 2016, 4.7, "iOS");

        dog.feed();
        pig.feed();

        dog.feed(1.3);
        pig.feed(7.5);

        dog.takeForAWalk();

        pig.beEaten();
        pig.beEaten();

    }
}
