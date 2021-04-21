package com.company;

import java.io.File;

public class Animal {
    String species;
    Double weight;
    String name;
    File pic;

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
}

