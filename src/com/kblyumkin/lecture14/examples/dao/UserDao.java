package com.kblyumkin.lecture14.examples.dao;

import com.kblyumkin.lecture14.examples.beans.User;

import java.sql.SQLException;

public interface UserDao extends AutoCloseable {

    boolean createUser(User user);

    User getUserById(int id);

    boolean updateUser(User user);

    boolean deleteUserById(int id);

    @Override
    void close() throws SQLException;
}
