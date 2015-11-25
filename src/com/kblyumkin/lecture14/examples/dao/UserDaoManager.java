package com.kblyumkin.lecture14.examples.dao;

import com.kblyumkin.lecture14.examples.constants.JdbcConstants;
import com.kblyumkin.lecture14.examples.exceptions.UserDaoException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.kblyumkin.lecture14.examples.constants.JdbcConstants.*;

public class UserDaoManager implements AutoCloseable{
    private Connection connection = null;

    public UserDaoManager() throws SQLException, ClassNotFoundException {
        Class.forName(MYSQL_JDBC_DRIVER);
        connection = DriverManager.getConnection(URL);
        connection.setAutoCommit(false);
    }

    public void truncateUsers() {
        try {
            PreparedStatement stmt = connection.prepareStatement(TRUNCATE_USERS);
            stmt.execute();
            connection.commit();
        } catch (SQLException e) {
            throw new UserDaoException("Couldn't truncate USERS", e);
        }
    }

    @Override
    public void close() throws SQLException {
        connection.close();
    }
}
