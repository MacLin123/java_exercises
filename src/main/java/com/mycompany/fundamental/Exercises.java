package com.mycompany.fundamental;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

public class Exercises {
    private Scanner scanner;
    private boolean useInputFromKeyboard;

    public Exercises(boolean useInputFromKeyboard) {
        this.useInputFromKeyboard = useInputFromKeyboard;
        if (useInputFromKeyboard) {
            scanner = new Scanner(System.in);
        } else {
            String ex14Arr1 = "2 7 6";
            String ex14Arr2 = "9 5 1";
            String ex14Arr3 = "4 3 8";
            String[] exStrings = {"4", "365", "7", "12", "5", "10", "4294967205", "abcde",
                    ex14Arr1, ex14Arr2, ex14Arr3, ""};
            InputStream inputStream = new ByteArrayInputStream(String.join(System.lineSeparator(),
                    Arrays.asList(exStrings)).getBytes(StandardCharsets.UTF_8));
            scanner = new Scanner(inputStream);
        }
    }

    public void ex1() {
        System.out.println("*** EX 1 ***");
        if (useInputFromKeyboard) {
            System.out.println("Input number");
        }
        int num = scanner.nextInt();
        System.out.println("binary - " + Integer.toBinaryString(num));
        System.out.println("octal - " + Integer.toOctalString(num));
        System.out.println("hexadecimal - " + Integer.toHexString(num));
        System.out.println("reciprocal float-hex - " + Float.toHexString(Integer.reverse(num)));
    }

    public void ex2() {
        System.out.println("*** EX 2 ***");
        if (useInputFromKeyboard) {
            System.out.println("Input number");
        }
        int num = scanner.nextInt();
        int divider = 360;
        int normVal = num % divider;
        if (normVal < 0) {
            normVal += divider;
        }
        System.out.println("% op result = " + normVal);

        System.out.println("floorMod  result = " + Math.floorMod(num, divider));
    }

    public void ex3() {
        System.out.println("*** EX 3 ***");
        if (useInputFromKeyboard) {
            System.out.println("Input number 1");
        }
        int num1 = scanner.nextInt();
        if (useInputFromKeyboard) {
            System.out.println("Input number 2");
        }
        int num2 = scanner.nextInt();
        if (useInputFromKeyboard) {
            System.out.println("Input number 3");
        }
        int num3 = scanner.nextInt();

        int max = num1;
        if (max < num2) {
            max = num2;
        }
        if (max < num3) {
            max = num3;
        }
        System.out.println("conditional op max = " + max);
        max = num1;
        max = Math.max(max, num2);
        max = Math.max(max, num3);

        System.out.println("Math.max = " + max);
    }

    public void ex4() {
        System.out.println("*** EX 4 ***");
        double num1 = 0;
        double num2 = 1.0 / 0.0;
        System.out.println("smallest double value = " + Math.nextUp(num1));
        System.out.println("largest double value = " + Math.nextDown(num2));
    }

    public void ex5() {
        System.out.println("*** EX 5 ***");
        double bigDouble = Integer.MAX_VALUE + 1;
        int i = (int) bigDouble;
        System.out.println("double = " + bigDouble);
        System.out.println("int = " + i);
    }

    public void ex6() {
        System.out.println("*** EX 6 ***");
        BigInteger result = new BigInteger(String.valueOf(1));
        int n = 1000;
        for (long i = 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        System.out.println("factorial of 1000 = " + result);
    }

    public void ex7() {
        System.out.println("*** EX 7 ***");
        Integer num1 = Integer.parseInt(scanner.next());
        Integer num2 = Integer.parseUnsignedInt(scanner.next());
        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + Integer.toUnsignedString(num2));
        System.out.println("unsigned sum num1 + num2 = " + Integer.toUnsignedString(num1 + num2));
        System.out.println("unsigned difference num2 - num1 = " + Integer.toUnsignedString(num2 - num1));
        System.out.println("product of num1 and num2 = " + Integer.toUnsignedString(num1 * num2));

        System.out.println("quotient (num2 / num1) = " +
                Integer.toUnsignedString(Integer.divideUnsigned(num2, num1)));
        System.out.println("remainder (num2 % num1) = " +
                Integer.toUnsignedString(Integer.remainderUnsigned(num2, num1)));
    }

    public void ex8() {
        System.out.println("*** EX 8 ***");
        if (useInputFromKeyboard) {
            System.out.println("Input string");
        }
        String str = scanner.next();
        System.out.println("string is - " + str);
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                System.out.println(str.substring(i, j));
            }
        }
    }

    public void ex9() {
        System.out.println("*** EX 9 ***");

        String s = "Exercise";
        String t = "Exer";
        t += "cise";
        System.out.println("s.equals(t) = " + s.equals(t));
        System.out.println("s != t " + (s != t));

    }

    public void ex10() {
        System.out.println("*** EX 10 ***");

        Random random = new Random();
        long num = random.nextLong();
        BigInteger bigInteger = BigInteger.valueOf(num);

        System.out.println("random string = " + bigInteger.toString(36));
    }

    public void ex13() {
        System.out.println("*** EX 13 ***");
        int n = 49;
        ArrayList<Integer> arr = new ArrayList<>(n);
        ArrayList<Integer> result = new ArrayList<>(6);
        for (int i = 0; i < n; i++) {
            arr.add(i + 1);
        }
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            int randIndex = random.nextInt(arr.size());
            result.add(arr.get(randIndex));
            arr.remove(randIndex);
        }
        Collections.sort(result);
        System.out.println("lottery combination is = " + result);
    }

    public void ex14() {
        System.out.println("*** EX 14 ***");

        if (useInputFromKeyboard) {
            System.out.println("Input array");
        }

        List<List<Integer>> matrix = new ArrayList<>();
        String str = null;
        int i = 0;
        while (true) {
            try {
                str = scanner.nextLine();
            } catch (NoSuchElementException ex) {
                System.out.println(ex.getMessage());
                break;
            }
            if (str.isEmpty() && (i == 0)) {
                continue;
            } else if (str.isEmpty()) {
                break;
            }
            matrix.add(Arrays.stream(str.split(" +")).map(Integer::parseInt).collect(Collectors.toList()));
            i++;
        }
        System.out.println("matrix is = " + matrix);
        System.out.println("Matrix is magic root = " + isMagicRoot(matrix));
    }

    private boolean isMagicRoot(List<List<Integer>> matrix) {
        int sumr = 0, sumc = 0, sumd1 = 0, sumd2 = 0;

        for (int i = 0; i < matrix.size(); i++) {
            sumd1 += matrix.get(i).get(i);
            sumd2 += matrix.get(i).get(matrix.size() - i - 1);
        }
        if (sumd1 != sumd2) {
            return false;
        }
        for (int i = 0; i < matrix.size(); i++) {
            sumr = 0;
            sumc = 0;
            for (int j = 0; j < matrix.size(); j++) {
                sumr += matrix.get(i).get(j);
                sumc += matrix.get(j).get(i);
            }
            if (sumr != sumd1) {
                return false;
            }
            if (sumc != sumd1) {
                return false;
            }
        }
        return true;
    }

}
