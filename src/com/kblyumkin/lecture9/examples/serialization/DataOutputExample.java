package com.kblyumkin.lecture9.examples.serialization;

import java.io.*;
import java.math.BigDecimal;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class DataOutputExample {
    private static final String FILE = "/Users/kblyumkin/Projects/SourceIt/resources/user.bin";

    public static void main(String[] args) throws IOException {

        User user = new User();
        user.setAge(25);
        user.setName("John");
        user.setLastName("Black");
        user.setSalary(new int[]{200, 250, 300, 450, 500});

        writeUser(user);

        User userFromFile = readUser();
        System.out.println(userFromFile);
    }


    private static User readUser() throws IOException {
        File file = new File(FILE);
        InputStream is = new GZIPInputStream(
                new BufferedInputStream(
                    new FileInputStream(file)));
        DataInput input = new DataInputStream(is);
        User result = new User();
        result.setAge(input.readInt());
        result.setName(input.readUTF());
        result.setLastName(input.readUTF());
        int[] salary = new int[input.readInt()];
        for (int index = 0; index < salary.length; index++) {
            salary[index] = input.readInt();
        }
        result.setSalary(salary);
        is.close();
        return result;
    }

    private static void writeUser(User user) throws IOException {
        File file = new File(FILE);

        OutputStream os = new BufferedOutputStream(
                new GZIPOutputStream(
                        new FileOutputStream(file)));

        DataOutput output = new DataOutputStream(os);

        output.writeInt(user.getAge());
        output.writeUTF(user.getName());
        output.writeUTF(user.getLastName());
        output.writeInt(user.getSalary().length);
        for (int sal : user.getSalary()) {
            output.writeInt(sal);
        }
        os.flush();
        os.close();
    }
}
