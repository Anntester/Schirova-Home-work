package com.kblyumkin.lecture6.examples.lists;

import java.util.*;

public class ListExample {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();

        User john = new User("John");

        users.add(new User("Peter"));
        users.add(0, john);
        users.add(new User("Mike"));
        users.add(john);


        for (User user : users) {
            System.out.println(user);
        }
    }
}
