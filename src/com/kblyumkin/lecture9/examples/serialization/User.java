package com.kblyumkin.lecture9.examples.serialization;

import java.io.Serializable;
import java.util.Arrays;

public class User implements Cloneable, Serializable {
    private String name;
    private String lastName;
    private int age;
    private transient int[] salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int[] getSalary() {
        return salary;
    }

    public void setSalary(int[] salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", salary=" + Arrays.toString(salary) +
                '}';
    }

    public User clone() throws CloneNotSupportedException {
        return (User) super.clone();
    }
}
