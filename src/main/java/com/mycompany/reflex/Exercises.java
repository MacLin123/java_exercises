package com.mycompany.reflex;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.function.DoubleFunction;

public class Exercises {
    public void ex8() {
        System.out.println("EX 8");
        Class[] clazzes = new Class[4];
        clazzes[0] = int[].class;
        clazzes[1] = int.class;
        clazzes[2] = ArrayList.class;
        clazzes[3] = Outer.Inner.class;
        for (Class clazz : clazzes) {
            System.out.println("getCanonicalName() = " + clazz.getCanonicalName());
            System.out.println("getSimpleName() = " + clazz.getSimpleName());
            System.out.println("getTypeName() = " + clazz.getTypeName());
            System.out.println("getName() = " + clazz.getName());
            System.out.println("toString() = " + clazz.toString());
            System.out.println("toGenericString() = " + clazz.toGenericString());
            System.out.println();
        }
    }

    public void ex9() {
        System.out.println("EX 9");
        String str = "hello";
        try {
            System.out.println(universalToString(str));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public String universalToString(Object object) throws IllegalAccessException {
        Class clazz = object.getClass();
        StringBuilder sb = new StringBuilder();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Object val = field.get(object);
            sb.append(field.getName() + " = " + val + "\n");
        }
        return sb.toString();
    }

    public void ex10() {
        System.out.println("EX 10");
        Class clazz = int[].class;
        for (Method m : clazz.getMethods()) {
            System.out.println(Modifier.toString(m.getModifiers()) + " " +
                    m.getReturnType().getCanonicalName() + " " + m.getName() +
                    Arrays.toString(m.getParameters()));
        }
    }

    public void ex11() {
        System.out.println("EX 11");
        Class clazz = System.out.getClass();
        Method method = null;
        try {
            method = clazz.getDeclaredMethod("println", String.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        try {
            method.invoke(System.out, "hello world");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public void ex12() {
        System.out.println("EX 12");
        Random random = new Random();
        int n = 100000;
        long start, end;
        double[] randNums = new double[n];
        for (int i = 0; i < n; i++) {
            randNums[i] = 1000 * random.nextDouble();
        }
        Class clazz = Math.class;
        Method method = null;
        try {
            method = clazz.getMethod("sin", double.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        try {
            start = System.nanoTime();
            for (int i = 0; i < n; i++) {
                method.invoke(null, randNums[i]);
            }
            end = System.nanoTime();
            System.out.println("reflection method call = " + ((end - start) / 1E6));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            Math.sin(randNums[i]);
        }
        end = System.nanoTime();
        System.out.println("regular method call = " + ((end - start) / 1E6));
    }

    public void ex13() {
        System.out.println("EX 13");
        Method mSqrt = null;
        Method mtoHexString = null;
        try {
            mSqrt = Math.class.getMethod("sqrt", double.class);
            mtoHexString = Double.class.getMethod("toHexString", double.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("*Method invocation*");
            printTablMethodVals(mSqrt, 0, 18, 2);
            printTablMethodVals(mtoHexString, 0, 10, 3);
            System.out.println("*DoubleFunction invocation*");
            printTablDoubleFuncVals(Math::sqrt, 0, 18, 2);
            printTablDoubleFuncVals(Double::toHexString, 0, 10, 3);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void printTablMethodVals(Method method,
                                           double lowerBound, double upperBound, double step)
            throws IllegalAccessException, InvocationTargetException {
        if (method == null || method.getParameterTypes().length != 1
                || !(method.getParameterTypes()[0].equals(double.class) && !method.getParameterTypes()[0].equals(Double.class))) {
            throw new IllegalArgumentException();
        }
        System.out.println(method.getDeclaringClass().getSimpleName() + "." + method.getName());
        for (double val = lowerBound; val <= upperBound; val += step) {
            System.out.println("arg val: " + val + " returns: " + method.invoke(null, val));
        }
    }

    public static void printTablDoubleFuncVals(DoubleFunction<Object> method,
                                               double lowerBound, double upperBound, double step) {
        if (method == null) throw new IllegalArgumentException();
        System.out.println(method.getClass().getCanonicalName());
        for (double val = lowerBound; val < upperBound; val += step) {
            System.out.println("arg val: " + val + " returns: " + method.apply(val));
        }
    }
}

