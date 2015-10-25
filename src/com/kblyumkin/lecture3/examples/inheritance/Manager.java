package com.kblyumkin.lecture3.examples.inheritance;

import java.util.Arrays;

public class Manager extends Employee {
    private Employee[] employees;


    public Manager(byte age, String name,
                   String lastName,
                   Employee...employees) {
        super(age, name, lastName);
        this.employees = employees;
    }

    public Employee[] getEmployees() {
        return employees;
    }

   /* @Override
    public String toString() {
        return "Manager{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ",employees=" + Arrays.toString(employees) +
                '}';
    }*/
    @Override
    protected void print() {

    }
}
