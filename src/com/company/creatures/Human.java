package com.company.creatures;

import com.company.Salable;
import com.company.devices.Car;
import com.company.devices.Device;
import com.company.devices.Phone;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Human implements Salable {
    public final String firstName;
    public final String lastName;
    public Pet pet;
    public Phone mobilePhone;
    public Car[] garage;
    private Double salary;
    public Double cash;

    public Human(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.garage = new Car[3];
    }

    public Human(String firstName, String lastName, int garageCapacity) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.garage = new Car[garageCapacity];
    }

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

    public Double getGarageValue() {
        Double garageValue = 0.0;

        for (Device vehicle : this.garage) {
            garageValue += vehicle.value;
        }

        return garageValue;
    }

    public List<Car> sortGarage() {
        return Arrays.stream(garage)
                .sorted(Comparator.comparing(car -> car.yearOfProduction))
                .collect(Collectors.toList());
    }

    public boolean hasCar(Car newCar){
        for (Car car: garage) {
            if(car == newCar) return true;
        }
        return false;
    }

    public boolean hasFreeSpace(){
        for (Car car: garage) {
            if(car == null) return true;
        }
        return false;
    }

    public void removeCar(Car carToRemove){
        for (int i = 0; i < garage.length; i++){
            if (this.garage[i] == carToRemove){
                this.garage[i] = null;
            }
        }
    }

    public void addCar(Car newCar){
        for (int i = 0; i < garage.length; i++){
            if (this.garage[i] == null){
                this.garage[i] = newCar;
                newCar.owners.add(this);

                return; // trzeba zakończyć, bo w przypadku pustego garażu wpisywało to samo auto na 3 miejsca.
            }
        }
    }

    @Override
    public String toString() {
        return "\nHuman {\n" +
                "   firstName = '" + firstName + '\'' +
                ",\n   lastName = '" + lastName + '\'' +
                ",\n   pet = " + pet +
                ",\n   phone = " + mobilePhone +
                ",\n   garage = " + Arrays.toString(garage) +
                ",\n   salary = " + salary +
                ",\n   cash = " + cash +
                "\n}\n";
    }

    @Override
    public void sell(Human seller, Human buyer, Double price) {
        System.out.println("POLICJA! HANDEL LUDŹMI JEST NIELEGALNY!");
    }
}
