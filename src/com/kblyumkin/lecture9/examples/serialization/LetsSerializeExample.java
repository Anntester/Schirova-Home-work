package com.kblyumkin.lecture9.examples.serialization;

import java.io.*;

public class LetsSerializeExample {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        User user = new User();
        user.setAge(25);
        user.setName("John");
        user.setLastName("Black");
        user.setSalary(new int[]{200, 250, 300, 450, 500});

        User newUser = copy(user);
        user.setName("Peter");
        user.getSalary()[0] = 0;

        System.out.println(newUser);

    }

    private static <T extends Serializable> T copy(T origin) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(origin);

        oos.flush();
        oos.close();

        byte[] data = baos.toByteArray();
        ObjectInput objectInput = new ObjectInputStream(
                new ByteArrayInputStream(data));

        return (T) objectInput.readObject();
    }
}
