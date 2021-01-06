package com.mycompany.oop;

/**
 * Implementation of car model
 * This class shouldn't be immutable, because its state changing is often.
 */
public class Car {
    private double distance; //miles
    private double fuel; //gallons
    private double fuelEfficiency; // miles/gallons

    public Car() {
        distance = 0;
        fuel = 0;
        fuelEfficiency = 2;
    }

    public Car(double fuelEfficiency) {
        this.fuelEfficiency = fuelEfficiency;
    }

    public void move(double miles) {
        double possibleDist = fuelEfficiency * fuel;
        if (Double.compare(possibleDist, miles) < 0) {
            throw new IllegalArgumentException("not enough fuel");
        }
        fuel -= miles / fuelEfficiency;
        distance += miles;
    }

    public void addFuel(double fuel) {
        this.fuel += fuel;
    }

    public double getDistance() {
        return distance;
    }
}
