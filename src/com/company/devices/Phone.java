package com.company.devices;

import com.company.creatures.Human;
import com.company.Salable;

import java.util.List;
import java.util.ArrayList;

public class Phone extends Device implements Salable {
    final Double screenSize;
    final String operatingSystem;
    List <Application> applicationList;

    public Phone(String producer, String model, int yearOfProduction, Double value, Double screenSize, String operatingSystem) {
        super(producer, model, yearOfProduction, value);

        this.screenSize = screenSize;
        this.operatingSystem = operatingSystem;
        this.applicationList = new ArrayList<>();
    }

    public void installAnApp(Human owner, Application application) {
        if (owner.cash < application.price) {
            System.out.println("Brak funduszy na instalację aplikacji.");
        } else {
            owner.cash -= application.price;
            this.applicationList.add(application);
        }
    }

    public boolean hasApplication(Application applicationObject) {
        for (Application application : applicationList) {
            if (application == applicationObject) {
                return true;
            }
        }

        return false;
    }

    public boolean hasApplication(String applicationName) {
        for (Application application : applicationList) {
            if (application.name.equals(applicationName)) {
                return true;
            }
        }

        return false;
    }

    public void showAllFreeApplications() {
        System.out.println("Darmowe aplikacje:");

        for (Application application : applicationList) {
            if (application.price == 0.0) {
                System.out.print(application);
            }
        }
    }

    public void showAllApplications() {
        System.out.println("Aplikacje: ");

        for (Application application : applicationList) {
            System.out.print(application);
        }
        System.out.println();
    }

    public void sortApplicationsByName() {
        applicationList.sort(Application.byName);
        System.out.println("Aplikacje wg nazwy: ");

        for (Application application : applicationList) {
            System.out.print(application);
        }
    }

    public void sortApplicationsByPrice() {
        applicationList.sort(Application.byPrice);
        System.out.println("Aplikacje wg ceny: ");

        for (Application application : applicationList) {
            System.out.print(application);
        }
    }

    @Override
    public String toString() {
        return "Phone {" +
                "producer = '" + producer + '\'' +
                ", model = '" + model + '\'' +
                ", yearOfProduction = " + yearOfProduction +
                ", screenSize = " + screenSize +
                ", operatingSystem = '" + operatingSystem + '\'' +
                '}';
    }

    @Override
    public void turnOn() {
        System.out.println("[TELEFON] Urządzenie " + producer + " " + model + " włącza się.");
    }

    @Override
    public void sell(Human seller, Human buyer, Double price) {
        if (seller.mobilePhone != this) {
            System.out.println("Nie możesz sprzedawać kradzionych telefonów");
        } else if (buyer.cash < price) {
            System.out.println("Kupujący nie ma tylu pieniędzy");
        } else if (seller == buyer) {
            System.out.println("Nie możesz sprzedać telefonu sam sobie!");
        } else {
            buyer.cash -= price;
            seller.cash += price;
            buyer.mobilePhone = seller.mobilePhone;
            seller.mobilePhone = null;
            System.out.println("Udało się sprzedać telefon za " + price);
        }
    }
}
