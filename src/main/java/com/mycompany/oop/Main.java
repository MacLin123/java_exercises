package com.mycompany.oop;

public class Main {
    public static void main(String[] args) {
        Point p = new Point(3, 4).translate(1, 3).scale(0.5);
        System.out.println(p);
        Car car = new Car(1);
        car.addFuel(20);
        car.move(17);
        System.out.println(car.getDistance());
    }
}
