package org.javagirls.chapter_2.java;

import java.util.Scanner;

public class StringTemplate {
    public static void main(String[] args) {
        System.out.println("JAVA --------------------------");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        // concatenação básica no Java
        System.out.println("Hello, " + name + "!");
        // semelhante ao string template em Kotlin
        System.out.println(String.format("Hello, %s!", name));
    }
}
