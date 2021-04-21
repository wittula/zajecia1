package com.company;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Human {
    String firstName;
    String lastName;
    Animal pet;
    Phone mobilePhone;
    Car car;
    private Double salary;

    public Double getSalary(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        System.out.println("Dane o wypłacie (" + this.firstName + " " + this.lastName + ") były pobierane " + dtf.format(now) + " i wynosiły " + this.salary);

        return this.salary;
    }

    public void setSalary(Double salary){
        if (salary <= 0){
            try {
                throw new Exception("Nikt nie będzie dopłacał do swojej pracy");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("(" + this.firstName + " " + this.lastName + ") nowa wypłata: " + salary);
        System.out.println("Nowe dane zostały wysłane do systemu księgowego.");
        System.out.println("Konieczne jest odebranie aneksu do umowy od pani Hani z kadr.");
        System.out.println("ZUS i US już o wszystkim wiedzą - nie ma sensu ukrywać dochodu.");

        this.salary = salary;
    }
}
