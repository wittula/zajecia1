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
    }
}
