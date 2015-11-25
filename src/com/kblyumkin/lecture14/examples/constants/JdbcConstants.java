package com.kblyumkin.lecture14.examples.constants;

public class JdbcConstants {
    public static final String GET_USER_BY_ID    = "SELECT NAME, LAST_NAME, LOGIN, PASSWORD, " +
                                                   "EMAIL, DATE_OF_BIRTH FROM USERS WHERE ID = ?";
    public static final String DELETE_USER_BY_ID = "DELETE FROM USERS WHERE ID = ?";
    public static final String INSERT_USER       =
            "INSERT INTO USERS (NAME, LAST_NAME, LOGIN, PASSWORD, EMAIL, " +
            "DATE_OF_BIRTH) VALUES (?, ?, ?, ?, ?, ?)";
    public static final String UPDATE_USER_BY_ID =
            "UPDATE USERS SET NAME = ?, LAST_NAME = ?, LOGIN = ?, PASSWORD = ?, " +
            "EMAIL = ?, DATE_OF_BIRTH = ? WHERE ID = ?";
    public static final String MYSQL_JDBC_DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL               =
            "jdbc:mysql://127.0.0.1:3306/SourceIt?user=root&password=12345";
    public static final String TRUNCATE_USERS    = "TRUNCATE TABLE USERS";

    private JdbcConstants() {}
}
