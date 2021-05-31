package com.company;

import com.company.creatures.Animal;
import com.company.creatures.FarmAnimal;
import com.company.creatures.Human;
import com.company.creatures.Pet;
import com.company.devices.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        Human pato = new Human("Łukasz", "Sztando");
        pato.cash = 6500.0;

        Human poor = new Human("John", "Doe");
        poor.cash = 10.0;

        Phone phone = new Phone("Apple",
                "iPhone 7",
                2016,
                1200.0,
                4.7,
                "iOS"
        );

        Phone phone2 = new Phone("GooPhone", "7", 2017,
                300.0, 5.0, "Android"
        );

        pato.mobilePhone = phone;
        poor.mobilePhone = phone2;

        Application messenger = new Application("Messenger", "13.2.1", 0.0);
        Application photoshop = new Application("Photoshop", "7.3.0", 15.0);
        Application netflix = new Application("Netflix", "4.2.1", 0.0);
        Application beerpong = new Application("Beer Pong", "1.2.4", 5.0);

        phone.installAnApp(pato, messenger);
        phone.installAnApp(pato, beerpong);
        phone.installAnApp(pato, netflix);

        System.out.println(phone.hasApplication("Messenger"));
        System.out.println(phone.hasApplication(messenger));

        System.out.println(phone.hasApplication(photoshop));
        System.out.println(phone.hasApplication("Photoshop"));

        System.out.println("");

        phone.showAllApplications();
        phone.showAllFreeApplications();

        System.out.println("");
        phone.sortApplicationsByName();
        System.out.println("");
        phone.sortApplicationsByPrice();
        System.out.println("");

        phone.installAnApp(poor, photoshop);
        System.out.println(phone2.hasApplication(photoshop));
    }
}
