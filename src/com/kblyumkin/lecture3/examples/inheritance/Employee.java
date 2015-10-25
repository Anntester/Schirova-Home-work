package com.kblyumkin.lecture3.examples.inheritance;

public class Employee {
    public final static String COMPANY_NAME = "Some Company";

    private byte age;
    private String name;
    private String lastName = "";

    public Employee() {
        System.out.println("New employee created");
    }

    public Employee(byte age, final String name, String lastName) {
        this();
        System.out.println("New employee with arguments created");
        this.age = age;
        this.name = name;
        this.lastName = lastName;
    }

    public byte getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    protected void print() {
        System.out.println("I'm Employee!!!");
    }
}
