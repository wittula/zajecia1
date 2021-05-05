package com.company;

import java.io.File;

public class Animal implements Salable {
    String species;
    Double weight;
    String name;
    File pic;

    public String toString() {
        return species+" "+weight+" "+name+" "+pic;
    }

    void feed() {
        try {
            if (this.weight <= 0.0) {
                throw new Exception("Zwierzę o nazwie " + this.name + " nie może jeść, bo nie żyje.");
            } else {
                this.weight += 1.0;
                System.out.println("Zwierzę o nazwie " + this.name + " zostało nakarmione.");
            }

        } catch (Exception feedEx) {
            System.err.println(feedEx);
        }
    }

    void takeForAWalk() {
        try {
            if (this.weight == 0.0) {
                throw new Exception("Zwierzę o nazwie " + this.name + " już odeszło z tego świata.");
            } else {
                System.out.println("Zwierzę o nazwie " + this.name + " zostało wyprowadzone na spacer.");

                if (this.weight <= 1.0) {
                    this.weight = 0.0;
                    System.out.println("Zwierzę o nazwie " + this.name + " wychudziło się podczas spaceru i właśnie umiera.");
                } else {
                    this.weight -= 1.0;
                }
            }

        } catch (Exception walkEx) {
            System.err.println(walkEx);
        }
    }

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

