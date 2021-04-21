package com.company;

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

        chicken.takeForAWalk();
        chicken.feed();

        // Zadanie 2
        Car passat = new Car("Passat B5", "Volkswagen");
        passat.mileage = 125000.0;
        passat.horsepower = 105;
        passat.color = "silver";
        passat.fuelType = "diesel";
        passat.engineVolume = 1.9;

        System.out.println("Auto: " + passat.producer + " " + passat.model);

        pato.car = passat;

        System.out.println("Auto Łukasza: " + pato.car.producer + " " + pato.car.model);
    }
}
