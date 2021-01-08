package com.mycompany.interfaces;

import java.io.File;
import java.io.FileFilter;
import java.util.*;

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
        luckySort(strings, (Comparator.naturalOrder()));
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

    public void ex9() {
        System.out.println("*** Exercise 9 ***");
        Greeter g1 = new Greeter(3, "thread1");
        Greeter g2 = new Greeter(3, "thread2");
        Thread t1 = new Thread(g1);
        Thread t2 = new Thread(g2);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public void ex10() {
        System.out.println("*** Exercise 10 ***");
        Greeter[] tasks = new Greeter[3];
        tasks[0] = new Greeter(3, "thread1");
        tasks[1] = new Greeter(3, "thread2");
        tasks[2] = new Greeter(3, "thread3");
        System.out.println("*** runTogether ***");
        runTogether(tasks);
        System.out.println("*** runInOrder ***");
        runInOrder(tasks);
    }

    private static void runTogether(Runnable... tasks) {
        ArrayList<Thread> threads = new ArrayList<>(tasks.length);
        for (Runnable task : tasks) {
            threads.add(new Thread(task));
        }
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void runInOrder(Runnable... tasks) {
        for (Runnable task : tasks) {
            task.run();
        }
    }

    public void ex11() {
        System.out.println("*** Exercise 11 ***");
        File[] files;
        String path = ".";
        files = ex11AnonClass(path);
        Arrays.stream(files).forEach(System.out::println);
        files = ex11Lambda(path);
        Arrays.stream(files).forEach(System.out::println);
        files = ex11MethodExpr(path);
        Arrays.stream(files).forEach(System.out::println);
    }

    private File[] ex11AnonClass(String path) {
        System.out.println("*** Exercise 11 Anonymous Inner Class ***");
        File f = new File(path);
        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        };
        return f.listFiles(fileFilter);
    }

    private File[] ex11Lambda(String path) {
        System.out.println("*** Exercise 11 Lambda ***");
        File f = new File(path);
        FileFilter fileFilter = pathname -> pathname.isDirectory();
        return f.listFiles(fileFilter);
    }

    private File[] ex11MethodExpr(String path) {
        System.out.println("*** Exercise 11 Method expression ***");
        File f = new File(path);
        return f.listFiles(File::isDirectory);
    }

    public void ex12() {
        System.out.println("*** Exercise 12 ***");
        Arrays.stream(getFilesWithExt(
                ".\\src\\main\\java\\com\\mycompany\\oop", "java")).forEach(System.out::println);
    }

    private String[] getFilesWithExt(String path, String ext) {
        File f = new File(path);
        String[] files = f.list((File dir, String fname) -> {
            String[] fnames = fname.split("\\.");
            if (fnames.length == 0) {
                return false;
            }
            return fnames[fnames.length - 1].equals(ext);
        });
        return files;
    }

    public void ex13() {
        System.out.println("*** Exercise 13 ***");
        File f = new File(".");
        File[] files = f.listFiles();
        System.out.println("before sort");
        Arrays.stream(files).forEach(System.out::println);
        sortFiles(files);
        System.out.println("\n*** after sort ***\n");
        Arrays.stream(files).forEach(System.out::println);

    }

    private void sortFiles(File[] files) {
        Arrays.sort(files, (f1, f2) -> {
            if (f1.isDirectory() && f2.isDirectory()) {
                return f1.compareTo(f2);
            } else if (f1.isDirectory()) {
                return -1;
            } else if (f2.isDirectory()) {
                return 1;
            } else {
                return f1.compareTo(f2);
            }
        });
    }
}
