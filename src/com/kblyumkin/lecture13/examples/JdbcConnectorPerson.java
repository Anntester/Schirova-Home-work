package com.kblyumkin.lecture13.examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Random;

import static com.kblyumkin.lecture13.examples.JdbcConstants.*;

public class JdbcConnectorPerson {

    public static void main(String[] args) throws Exception {
        Class.forName(COM_MYSQL_JDBC_DRIVER).newInstance();
        try (Connection con = DriverManager.getConnection(URL)) {
            con.setAutoCommit(false);
            PreparedStatement statement = con.prepareStatement(PERSON_STATEMENT_QUERY);
            for (int i = 0; i < 1000; i++) {
                statement.setString(1, randomString());
                statement.setString(2, randomGender());
                statement.execute();
            }
            con.commit();
        }
    }

    private static String randomGender() {
        return new Random().nextInt(2) == 0 ? "male" : "female";
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
