package com.company.creatures;

import com.company.Salable;

import java.io.File;

public abstract class Animal implements Salable, Feedable {
    public final String species;
    public Double weight;
    public String name;
    public File pic;

    public Animal(String species, Double weight, String name, File pic) {
        this.species = species;
        this.weight = weight;
        this.name = name;
        this.pic = pic;
    }

    public String toString() {
        return species+" "+weight+" "+name+" "+pic;
    }

    abstract public void feed();
    abstract public void takeForAWalk();

    @Override
    public void sell(Human seller, Human buyer, Double price) {
        if (seller.pet != this) {
            System.out.println("Nie możesz sprzedawać cudzych zwierząt!");
        } else if (buyer.cash < price) {
            System.out.println("Kupujący nie ma tylu pieniędzy");
        } else if (seller == buyer) {
            System.out.println("Nie możesz sprzedać zwierzęcia sam sobie!");
        } else {
            buyer.cash -= price;
            seller.cash += price;
            buyer.pet = seller.pet;
            seller.pet = null;
            System.out.println("Udało się sprzedać zwierzaka za " + price);
        }
    }
}

