package com.kblyumkin.lecture6.examples.lists;

public class Manager extends User {
    private int usersCount;

    public Manager() {}

    public Manager(String name) {
        this.name = name;
    }

    public int getUsersCount() {
        return usersCount;
    }

    public void setUsersCount(int usersCount) {
        this.usersCount = usersCount;
    }
}
