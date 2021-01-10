package com.mycompany.inherit;

import com.mycompany.inherit.figures.*;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Point p = new Point(0, 0);
        Point p1 = new Point(5, 5);
        LabeledPoint lp = new LabeledPoint("label", 0, 0);
        System.out.println(lp);
//        System.out.println(p.x); // can't be accessed here EX 3
        //EX 4
        System.out.println("EX 4");
        Shape circle = new Circle(p, 3);
        Shape rectangle = new Rectangle(p, 3, 3);
        Shape line = new Line(p, p1);
        System.out.println("center of circle = " + circle.getCenter());
        circle.moveBy(2, 2);
        System.out.println("center of circle = " + circle.getCenter());
        System.out.println("center of rectangle = " + rectangle.getCenter());
        System.out.println("center of line = " + line.getCenter());
        //EX 5
        System.out.println("EX 4");
        System.out.println("clone of line ...");
        Line line1 = (Line) line;
        Line cloneLine = line1.clone();
        System.out.println("method 'equals' - " + cloneLine.equals(line1));
        System.out.println(" == " + (cloneLine == line));

        //EX 6
        System.out.println("EX 6");
        DiscountedItem x = new DiscountedItem("d1", 1, 0.2);
        Item y = new Item("d1", 1);
        DiscountedItem z = new DiscountedItem("d1", 1, 0.1);
        System.out.println("EX 6");
        System.out.println("x equals y = " + x.equals(y));
        System.out.println("y equals z = " + y.equals(z));
        System.out.println("x equals z = " + x.equals(z));
        //EX 7
        System.out.println("EX 7");
        System.out.println(Colors.getRed());
    }
}