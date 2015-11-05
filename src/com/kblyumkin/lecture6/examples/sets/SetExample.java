package com.kblyumkin.lecture6.examples.sets;

import com.kblyumkin.lecture6.examples.lists.User;

import java.util.*;

public class SetExample {
    public static void main(String[] args) {
        Set<User> users = new TreeSet<>(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (!(o1 instanceof User || o2 instanceof User)) {
                    throw new ClassCastException();
                }
                User thisUser = (User) o1;
                User thatUser = (User) o2;

                return thisUser.getName().compareTo(thatUser.getName());
            }
        });
        User john = new User("John");
        users.add(john);
        users.add(new User("Peter"));
        users.add(new User("Mike"));
        users.add(new User("123John"));

        for (User user : users) {
            System.out.println(user);
        }
    }
}
