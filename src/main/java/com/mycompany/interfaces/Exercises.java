package com.mycompany.interfaces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class Exercises {
    public void ex1() {
        System.out.println("*** Exercise 1 ***");
        Measurable e1 = new Employee(100.0, "e1");
        Measurable e2 = new Employee(350.0, "e2");
        Measurable e3 = new Employee(150.0, "e3");

        Measurable[] measurables = {e1, e2, e3};
        System.out.println(average(measurables));
    }

    private double average(Measurable[] objects) {
        double sum = 0;
        for (Measurable obj : objects) {
            sum += obj.getMeasure();
        }
        sum /= objects.length;
        return sum;
    }

    public void ex2() {
        System.out.println("*** Exercise 2 ***");
        Measurable e1 = new Employee(100.0, "John");
        Measurable e2 = new Employee(350.0, "Mike");
        Measurable e3 = new Employee(150.0, "Peter");

        Measurable[] measurables = {e1, e2, e3};
        Employee result = (Employee) largest(measurables);
        System.out.println(result.getName());
    }

    private Measurable largest(Measurable[] objects) {
        double max = objects[0].getMeasure();
        int indMax = 0;
        for (int i = 0; i < objects.length; i++) {
            if (max < objects[i].getMeasure()) {
                max = objects[i].getMeasure();
                indMax = i;
            }
        }
        return objects[indMax];
    }

    public void ex4() {
        System.out.println("*** Exercise 4 ***");
        IntSequence seq = IntSequence.of(3, 1, 4, 1, 5, 9);
        System.out.println("\nsequence");
        while (seq.hasNext()) {
            System.out.print(seq.next() + " ");
        }
    }

    public void ex5() {
        System.out.println("*** Exercise 5 ***");
        IntSequence seq = IntSequence.constant(1);
        System.out.println("first five numbers ... ");
        for (int i = 0; i < 5; i++) {
            System.out.print(seq.next() + " ");
        }
    }

    public void ex8() {
        System.out.println("*** Exercise 8 ***");
        ArrayList<String> strings = new ArrayList<>();
        strings.add("b");
        strings.add("c");
        strings.add("d");
        strings.add("a");
        System.out.println("before sort = " + strings);
        luckySort(strings,(Comparator.naturalOrder()));
        System.out.println("after sort = " + strings);
    }

    private void luckySort(ArrayList<String> strings, Comparator<String> comp) {
        boolean isSorted = false;
        if (strings.isEmpty() || strings.size() == 1) {
            return;
        }

        while (!isSorted) {
            isSorted = true;
            Iterator<String> iter = strings.iterator();
            String cur, prev = iter.next();
            while (iter.hasNext()) {
                cur = iter.next();
                if (comp.compare(prev, cur) > 0) {
                    isSorted = false;
                    Collections.shuffle(strings);
                    break;
                }
                prev = cur;
            }
        }
    }
}
