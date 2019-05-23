package com.geekbrains.launcher;

import java.io.*;
import java.util.Comparator;
import java.util.Stack;
import java.util.TreeSet;


// try catch finally throw throws


// transient volatile


// sleep()   wait()

// Arrays.sort()


public class Test {
    public static void main(String[] args) throws IOException {
        Test reverseLineInputStream = new Test();
        reverseLineInputStream.readAndPrintInReverseOrder();
    }

    public void readAndPrintInReverseOrder() throws IOException {

        String path = "123/test1.txt";

        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(path));

            br = new BufferedReader(new FileReader(path));
            Stack<String> lines = new Stack<String>();
            String line = br.readLine();
            while (line != null) {
                lines.push(line);
                line = br.readLine();
            }

            while (!lines.empty()) {
                System.out.println(lines.pop());
            }

            // дописать код

        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                }
            }
        }
    }
}


class MyCompUserDefine {

    public static void main(String a[]) {

        TreeSet<Empl> salComp = new TreeSet<Empl>(new MySalaryComp());
        salComp.add(new Empl("Ram", 3000));
        salComp.add(new Empl("John", 6000));
        salComp.add(new Empl("Crish", 2000));
        salComp.add(new Empl("Tom", 2400));
        for (Empl e : salComp) {
            e.info();
        }

    }
}

class MySalaryComp implements Comparator<Empl> {

    @Override
    public int compare(Empl e1, Empl e2) {
        if (e1.getSalary() > e2.getSalary()) {
            return 1;
        } else {
            return -1;
        }
    }
}

class Empl {
    private String name;
    private int salary;

    public Empl(String n, int s) {
        this.name = n;
        this.salary = s;
    }

    public int getSalary() {
        return salary;
    }

    public void info() {
        System.out.println(name + " " + salary);
    }
}


//     br = new BufferedReader(new FileReader(path));
//             Stack<String> lines = new Stack<String>();
//        String line = br.readLine();
//        while(line != null) {
//        lines.push(line);
//        line = br.readLine();
//        }
//
//        while(! lines.empty()) {
//        System.out.println(lines.pop());
//        }
