package com.company.creatures;

import java.io.File;

public class Pet extends Animal{
    public Pet(String species, Double weight, String name, File pic) {
        super(species, weight, name, pic);
    }

    @Override
    public void feed() {
        try {
            if (this.weight <= 0.0) {
                throw new Exception("Pupil o nazwie " + this.name + " nie może jeść, bo nie żyje.");
            } else {
                this.weight += 1.0;
                System.out.println("Pupil o nazwie " + this.name + " został nakarmiony.");
            }

        } catch (Exception feedEx) {
            System.err.println(feedEx);
        }
    }

    @Override
    public void feed(Double foodWeight) {
        try {
            if (this.weight <= 0.0) {
                throw new Exception("Pupil o nazwie " + this.name + " nie może jeść, bo nie żyje.");
            } else {
                this.weight += foodWeight;
                System.out.println("Pupil o nazwie " + this.name + " został nakarmiony. (+" + foodWeight + ")");
            }

        } catch (Exception feedEx) {
            System.err.println(feedEx);
        }
    }

    @Override
        public void takeForAWalk() {
            try {
                if (this.weight == 0.0) {
                    throw new Exception("Pupil o nazwie " + this.name + " już odszedł z tego świata.");
                } else {
                    System.out.println("Pupil o nazwie " + this.name + " został wyprowadzone na spacer.");

                    if (this.weight <= 1.0) {
                        this.weight = 0.0;
                        System.out.println("Pupil o nazwie " + this.name + " wychudził się podczas spaceru i właśnie umiera.");
                    } else {
                        this.weight -= 1.0;
                    }
                }

            } catch (Exception walkEx) {
                System.err.println(walkEx);
            }
        }
    }

