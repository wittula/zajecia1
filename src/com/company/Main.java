package com.company;

import devices.Car;
import devices.Phone;

import java.sql.SQLOutput;

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

        System.out.println(pato.firstName);
        System.out.println(pato.pet.name);

        System.out.println("Imię zwierzęcia: " + chicken.name);
        System.out.println("Obecna waga: "+ chicken.weight);

        chicken.feed();
        System.out.println("Obecna waga: "+ chicken.weight);

        chicken.takeForAWalk();
        System.out.println("Obecna waga: "+ chicken.weight);

        chicken.takeForAWalk();
        System.out.println("Obecna waga: "+ chicken.weight);

        chicken.takeForAWalk();
        System.out.println("Obecna waga: "+ chicken.weight);

        chicken.takeForAWalk();
        System.out.println("Obecna waga: "+ chicken.weight);

        // chicken.takeForAWalk();
        // chicken.feed();

        // Zadanie 2
        Car passat = new Car("Volkswagen","Passat B5", 2002, 1);
        passat.mileage = 125000.0;
        passat.horsepower = 105;
        passat.color = "silver";
        passat.fuelType = "diesel";
        passat.engineVolume = 1.9;
        passat.value = 3500.0;

        // System.out.println("Auto: " + passat.producer + " " + passat.model);

        pato.setSalary(500.0);
        pato.getSalary();

        pato.setSalary(1000.0);
        pato.getSalary();

        //pato.setSalary(5.0);

        pato.setCar(passat);
        //pato.getCar();

        Car passat2 = new Car("Volkswagen","Passat B5", 2002, 1);
        passat2.mileage = 125000.0;
        passat2.horsepower = 105;
        passat2.color = "silver";
        passat2.fuelType = "diesel";
        passat2.engineVolume = 1.9;
        passat2.value = 3500.0;

        System.out.println(" == : " + (passat == passat2));
        System.out.println(" overrided equals() : " + passat.equals(passat2));

        System.out.println(chicken); // com.company.Animal@25bbe1b6 przed override toString
        System.out.println(passat); // com.company.Car@1 po override hashcode, ale przed override toString
        System.out.println(passat2); // przed override sam hashcode był inny, teraz ma po prostu id

        Phone phone = new Phone("Apple", "iPhone 7", 2016, 4.7, "iOS");

        System.out.println("Human: " + pato); // Human
        System.out.println("Car: " + passat); // Car
        System.out.println("Animal: " + chicken); // Animal
        System.out.println("Phone: " + phone); // Phone

        phone.turnOn();
        passat.turnOn();
    }
}
