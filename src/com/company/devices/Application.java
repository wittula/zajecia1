package com.company.devices;

import java.util.Comparator;

public class Application {
    String name;
    String version;
    Double price;

    public static Comparator<Application> byName = Comparator.comparing(application -> application.name);
    public static Comparator<Application> byPrice = Comparator.comparing(application -> application.price);

    public Application(String name, String version, Double price) {
        this.name = name;
        this.version = version;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Application{" +
                "name = '" + name + '\'' +
                ", version = '" + version + '\'' +
                ", price = " + price +
                "} \n";
    }
}
