package com.company.creatures;

import java.io.File;

public class FarmAnimal extends Animal implements Edible{

    public FarmAnimal(String species, Double weight, String name, File pic) {
        super(species, weight, name, pic);
    }

    @Override
    public void beEaten() {
        try {
            if (this.weight <= 0.0) {
                throw new Exception("Zwierzę o nazwie " + this.name + " nie żyje i waży 0, więc nie ma co jeść.");
            } else {
                this.weight = 0.0;
                System.out.println("Zwierzę o nazwie " + this.name + " zostało zabite i zjedzone.");
            }

        } catch (Exception feedEx) {
            System.err.println(feedEx);
        }
    }

    @Override
    public void feed() {
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

    @Override
    public void feed(Double foodWeight) {
        try {
            if (this.weight <= 0.0) {
                throw new Exception("Zwierzę o nazwie " + this.name + " nie może jeść, bo nie żyje.");
            } else {
                this.weight += foodWeight;
                System.out.println("Zwierzę o nazwie " + this.name + " zostało nakarmione. (+" + foodWeight + ")");
            }

        } catch (Exception feedEx) {
            System.err.println(feedEx);
        }
    }

    @Override
    public void takeForAWalk() {
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
}
