package org.javagirls.chapter_2.java;

public class Person {
    private String name;
    private boolean isStudent;

    public Person(String name, boolean isStudent) {
        this.name = name;
        this.isStudent = isStudent;
    }

    public String getName() {
        return name;
    }

    public boolean isStudent() {
        return isStudent;
    }

    public void setStudent(boolean isStudent) {
        this.isStudent = isStudent;
    }

    public static void main(String[] args) {
        System.out.println("JAVA --------------------------");
        Person person = new Person("Bob", true);
        System.out.println(person.getName());
        System.out.println(person.isStudent());
        person.setStudent(false);
        System.out.println(person.isStudent());
    }
}
