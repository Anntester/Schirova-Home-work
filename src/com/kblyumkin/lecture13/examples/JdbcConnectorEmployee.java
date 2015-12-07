package com.kblyumkin.lecture13.examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Random;

import static com.kblyumkin.lecture13.examples.JdbcConstants.*;

public class JdbcConnectorEmployee {
    public static void main(String[] args) throws Exception {
        Class.forName(COM_MYSQL_JDBC_DRIVER).newInstance();
        try (Connection con = DriverManager.getConnection(URL)) {
            con.setAutoCommit(false);
            PreparedStatement statement = con.prepareStatement(EMPLOYEE_STATEMENT_QUERY);
            for (int i = 0; i < 1000; i++) {
                statement.setString(1, randomString());
                statement.setString(2, randomString());
                statement.setString(3, randomCode());
                statement.setInt(   4, (new Random().nextInt(50) + 1) * 100);
                statement.setString(5, randomDepartment());
                statement.execute();
            }
            con.commit();
        }
    }

    private static String randomCode() {
        StringBuilder result = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            result.append(random.nextInt(10));
        }
        return result.toString();
    }

    private static String randomDepartment() {
        return DEPARTMENTS.get(new Random().nextInt(5));
    }

    private static String randomString() {
        Random random = new Random();
        int length = random.nextInt(5) + 3;
        char[] result = new char[length];
        for (int i = 0; i < length; i++) {
            result[i] = (char) ((random.nextInt(26) + 65) + (random.nextInt(2) * 32)) ;
        }
        return String.valueOf(result);
    }
}
