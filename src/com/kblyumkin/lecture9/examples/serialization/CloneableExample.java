package com.kblyumkin.lecture9.examples.serialization;

public class CloneableExample {
    public static void main(String[] args) throws CloneNotSupportedException {
        User user = new User();
        user.setAge(25);
        user.setName("John");
        user.setLastName("Black");
        user.setSalary(new int[]{200, 250, 300, 450, 500});

        User clone = user.clone();
        user.setName("Peter");
        user.getSalary()[0] = 0;
        System.out.println(clone);
    }
}
