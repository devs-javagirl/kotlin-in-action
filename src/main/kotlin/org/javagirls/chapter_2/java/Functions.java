package org.javagirls.chapter_2.java;

public class Functions {

    public static void main(String[] args) {
        System.out.println("JAVA --------------------------");
        System.out.println("Hello world !");
        System.out.println("Máx entre 3 e 5 é " + max(3, 5));
        System.out.println("Máx entre 10 e 50 é " + maxSimpler(10, 50));
    }

    private static int max(int a, int b) {
        if (a > b)
            return a;
        else
            return b;
    }

    private static int maxSimpler(int a, int b) {
        return (a > b) ? a : b;
    }
}
