package com.company.devices;

import com.company.creatures.Human;
import com.company.Salable;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;

public class Phone extends Device implements Salable {
    final Double screenSize;
    final String operatingSystem;

    static final String DEFAULT_SERVER_ADDRESS = "127.0.0.1";
    static final String DEFAULT_SERVER_PROTOCOL = "https";
    static final String DEFAULT_VERSION_NAME = "latest";

    public Phone(String producer, String model, int yearOfProduction, Double value, Double screenSize, String operatingSystem) {
        super(producer, model, yearOfProduction, value);

        this.screenSize = screenSize;
        this.operatingSystem = operatingSystem;
    }

    @Override
    public String toString() {
        return "Phone {" +
                "producer='" + producer + '\'' +
                ", model='" + model + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                ", screenSize=" + screenSize +
                ", operatingSystem='" + operatingSystem + '\'' +
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


    public void installAnApp(String appName) {
        this.installAnApp(appName, DEFAULT_VERSION_NAME);
    }

    public void installAnApp(String appName, String version) {
        this.installAnApp(appName, version, DEFAULT_SERVER_ADDRESS);
    }

    public void installAnApp(String appName, String version, String serverAddress) {
        URL appLink = null;
        try {
            appLink = new URL(DEFAULT_SERVER_PROTOCOL, serverAddress, appName + "_" + version);
            this.installAnApp(appLink);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void installAnApp(URL appSourceURL) {
        System.out.println("Pobieranie aplikacji " + appSourceURL.getFile() + " z adresu " + appSourceURL.getHost());
        System.out.println("Sprawdzanie, czy aplikacja jest płatna");
        System.out.println("Czy są pieniądze?");
        System.out.println("czy jest miejsce?");
        System.out.println("jeśli bezpłatna lub opłacona to rozpakowywanie");
        System.out.println("instalacja aplikacji " + appSourceURL.getFile());
    }

    public void installAnApp(List<String> applications) {
        String[] array = new String[applications.size()];
        array = applications.toArray(array);

        this.installAnApp(array);
    }

    public void installAnApp(String[] applications) {
        for (String appName: applications) {
            this.installAnApp(appName);
        }
    }
}
