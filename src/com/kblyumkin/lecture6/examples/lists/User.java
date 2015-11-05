package com.kblyumkin.lecture6.examples.lists;

public class User /*implements Comparable*/{
    protected String name;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return name.equals(user.getName());
    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }

    /*@Override
    public int compareTo(Object o) {
        if (!(o instanceof User)) {
            throw new ClassCastException();
        }
        User user = (User) o;

        return name.compareTo(user.getName());
    }*/
}
