package com.kblyumkin.lecture13.examples;

import java.util.Arrays;
import java.util.List;

public class JdbcConstants {
    public static final String EMPLOYEE_STATEMENT_QUERY =
            "INSERT INTO EMPLOYEE (NAME, LASTNAME, CODE, SALARY, DEPARTMENT) VALUES (?, ?, ?, ?, ?)";
    public static final List<String> DEPARTMENTS        = Arrays.asList("Management", "QA", "Dev", "Stuff", "Admin");
    public static final String COM_MYSQL_JDBC_DRIVER    = "com.mysql.jdbc.Driver";
    public static final String URL                      = "jdbc:mysql://127.0.0.1:3306/SourceIt?user=root&password=12345";
    public static final String PERSON_STATEMENT_QUERY   = "INSERT INTO PERSON (NAME, GENDER) VALUES (?, ?)";

    private JdbcConstants() {}
}
