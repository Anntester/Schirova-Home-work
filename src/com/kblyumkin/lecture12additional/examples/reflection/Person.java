package com.kblyumkin.lecture12additional.examples.reflection;

import java.util.List;

public class Person {
    private String name;
    private String lastName;
    private int age;
    private boolean resident;
    private Address address;
    private Person spouse;
    private Person[] parents;
    private List<Person> children;

    public Person() {
    }

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Person getSpouse() {
        return spouse;
    }

    public boolean isResident() {
        return resident;
    }

    public void setResident(boolean resident) {
        this.resident = resident;
    }

    public void setSpouse(Person spouse) {
        this.spouse = spouse;
    }

    public Person[] getParents() {
        return parents;
    }

    public void setParents(Person[] parents) {
        this.parents = parents;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void setChildren(List<Person> children) {
        this.children = children;
    }
}
