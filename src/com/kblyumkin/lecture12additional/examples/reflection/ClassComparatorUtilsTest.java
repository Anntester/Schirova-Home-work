package com.kblyumkin.lecture12additional.examples.reflection;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class ClassComparatorUtilsTest {
    private Person person;

    @Test
    public void testIsAllFieldsAreNullPositiveCase() {
        //Given
        person = new Person();

        //When
        boolean result = ClassComparatorUtils.isAllFieldsAreNull(person);

        //Then
        assertTrue(result);
    }

    @Test
    public void testIsAllFieldsAreNullNegativeCase() {
        //Given
        person = new Person();
        //person.setLastName("Smith");
        //person.setName("John");
        person.setAddress(new Address());

        //When
        boolean result = ClassComparatorUtils.isAllFieldsAreNull(person);

        //Then
        assertFalse(result);
    }

    @Test
    public void testIsAllFieldsAreEqualsWhenAllFieldsAreNullPositiveCase() {
        //Given
        person = new Person();
        Person anotherPerson = new Person();

        //When
        boolean result = ClassComparatorUtils.isAllFieldsAreEquals(person, anotherPerson);

        //Then
        assertTrue(result);
    }

    @Test
    public void testIsAllFieldsAreEqualsWhenAllFieldsExceptCollectionsAreNotNullPositiveCase() {
        //Given
        Address address = new Address();
        address.setCountry("USA");
        address.setCity("Los Angels");
        address.setStreet("Malholland drive");
        address.setHouse("12");
        address.setApp("10-a");
        address.setZipCode("12065");

        person = new Person();

        Person anotherPerson = new Person();
        person.setName("John");
        person.setLastName("Smith");
        person.setAge(25);
        person.setResident(true);
        person.setAddress(address);
        anotherPerson.setName("John");
        anotherPerson.setLastName("Smith");
        anotherPerson.setAge(25);
        anotherPerson.setResident(true);
        anotherPerson.setAddress(address);

        //When
        boolean result = ClassComparatorUtils.isAllFieldsAreEquals(person, anotherPerson);

        //Then
        assertTrue(result);
    }

    @Test
    public void testIsAllFieldsAreEqualsWhenAllFieldsExceptCollectionsAndArrayAreNotNullWithDifferentAddressesPositiveCase() {
        //Given
        Address address = new Address();
        address.setCountry("USA");
        address.setCity("Los Angels");
        address.setStreet("Malholland drive");
        address.setHouse("12");
        address.setApp("10-b");

        Address anotherAddress = new Address();
        anotherAddress.setCountry("USA");
        anotherAddress.setCity("Los Angels");
        anotherAddress.setStreet("Malholland drive");
        anotherAddress.setHouse("12");
        anotherAddress.setApp("10-b");

        person = new Person();

        Person anotherPerson = new Person();
        person.setName("John");
        person.setLastName("Smith");
        person.setAge(25);
        person.setResident(true);
        person.setAddress(address);
        anotherPerson.setName("John");
        anotherPerson.setLastName("Smith");
        anotherPerson.setAge(25);
        anotherPerson.setResident(true);
        anotherPerson.setAddress(anotherAddress);

        //When
        boolean result = ClassComparatorUtils.isAllFieldsAreEquals(person, anotherPerson);

        //Then
        assertTrue(result);
    }

    @Test
    public void testIsAllFieldsAreEqualsWhenAllFieldsExceptCollectionsWithDifferentAddressesAreNullPositiveCase() {
        //Given
        Address address = new Address();
        address.setCountry("USA");
        address.setCity("Los Angels");
        address.setStreet("Malholland drive");
        address.setHouse("12");
        address.setApp("10-b");
        Person[] parents = {new Person(), new Person()};

        Address anotherAddress = new Address();
        anotherAddress.setCountry("USA");
        anotherAddress.setCity("Los Angels");
        anotherAddress.setStreet("Malholland drive");
        anotherAddress.setHouse("12");
        anotherAddress.setApp("10-b");

        person = new Person();

        Person anotherPerson = new Person();
        person.setName("John");
        person.setLastName("Smith");
        person.setAge(25);
        person.setResident(true);
        person.setAddress(address);
        person.setParents(parents);
        person.setSpouse(anotherPerson);
        anotherPerson.setName("John");
        anotherPerson.setLastName("Smith");
        anotherPerson.setAge(25);
        anotherPerson.setResident(true);
        anotherPerson.setAddress(anotherAddress);
        anotherPerson.setParents(parents);
        anotherPerson.setSpouse(person);

        //When
        boolean result = ClassComparatorUtils.isAllFieldsAreEquals(person, anotherPerson);

        //Then
        assertTrue(result);
    }
}
