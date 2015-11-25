package com.kblyumkin.lecture14.examples.dao;


import com.kblyumkin.lecture14.examples.beans.User;
import com.kblyumkin.lecture14.examples.exceptions.UserDaoException;

import java.sql.*;

import static com.kblyumkin.lecture14.examples.constants.JdbcConstants.*;

public class UserDaoImpl implements UserDao {
    private Connection connection = null;

    public UserDaoImpl() throws SQLException, ClassNotFoundException {
        Class.forName(MYSQL_JDBC_DRIVER);
        connection = DriverManager.getConnection(URL);
        connection.setAutoCommit(false);
        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
    }

    @Override
    public boolean createUser(User user) {
        try {
            PreparedStatement stmt = connection.prepareStatement(INSERT_USER);
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getLastName());
            stmt.setString(3, user.getLogin());
            stmt.setString(4, user.getPassword());
            stmt.setString(5, user.getEmail());
            stmt.setDate(  6, user.getDateOfBirth());
            stmt.execute();
            connection.commit();
        } catch (SQLException e) {
            throw new UserDaoException("SQL exception ", e);
        }
        return true;
    }

    @Override
    public User getUserById(int id) {
        try {
            PreparedStatement stmt = connection.prepareStatement(GET_USER_BY_ID);
            stmt.setInt(1, id);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString(1);
                String lastName = resultSet.getString(2);
                String login = resultSet.getString(3);
                String password = resultSet.getString(4);
                String email = resultSet.getString(5);
                Date dateOfBirth =resultSet.getDate(6);

                return new User(id, name, lastName, login, password, email, dateOfBirth);
            }
        } catch (SQLException e) {
            throw new UserDaoException("SQL exception ", e);
        }
        throw new UserDaoException("User with id = " + id + " was not found");
    }

    @Override
    public boolean updateUser(User user) {
        try {
            PreparedStatement stmt = connection.prepareStatement(UPDATE_USER_BY_ID);
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getLastName());
            stmt.setString(3, user.getLogin());
            stmt.setString(4, user.getPassword());
            stmt.setString(5, user.getEmail());
            stmt.setDate(  6, user.getDateOfBirth());
            stmt.setInt(   7, user.getId());
            stmt.execute();
            connection.commit();
            return stmt.getUpdateCount() > 0;
        } catch (SQLException e) {
            throw new UserDaoException("SQL exception ", e);
        }
    }

    @Override
    public boolean deleteUserById(int id) {
        try {
            PreparedStatement stmt = connection.prepareStatement(DELETE_USER_BY_ID);
            stmt.setInt(1, id);
            stmt.execute();
            connection.commit();
            return stmt.getUpdateCount() >= 0;
        } catch (SQLException e) {
            throw new UserDaoException("User with id = " + id + " was not found");
        }
    }

    @Override
    public void close() throws SQLException {
        connection.close();
    }
}
