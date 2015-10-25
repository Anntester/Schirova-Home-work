package com.kblyumkin.lecture3.examples.inheritance;

import java.lang.reflect.Field;

public class EmployeeTest {
    public static void main(String[] args) throws IllegalAccessException {
        Employee john = new Employee((byte) 50, "John", "Smith");
        /*Employee mary = new Employee((byte) 40, "Mary", "White");
        Employee mike = new Employee((byte) 30, "Mike", "Fly");

        Employee me = new Employee();



        Manager manager = new Manager((byte) 25, "Steve" , "Jobs",
                john, mary, mike);*/
        //System.out.println(manager);
        System.out.println(john);

        Class clazz = john.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if ("name".equals(field.getName())) {
                field.setAccessible(true);
                field.set(john, "Mike");
            }
        }

        System.out.println(john);
    }
}
