package com.kblyumkin.lecture15.examples.jdbc.beans;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public enum UserType implements DataBaseBeanInterface<Integer> {
    ADMIN(1),
    USER(2),
    EMPLOYEE(3);

    private static final String READ_SQL   = "SELECT TYPE FROM USERS_TYPE WHERE ID = ?";
    private static final String DELETE_SQL = "DELETE FROM USERS_TYPE WHERE ID = ?";
    private static final String CREATE_SQL = "INSERT INTO USERS_TYPE (TYPE) VALUES (?)";
    private static final String UPDATE_SQL = "UPDATE USERS SET TYPE = ? WHERE ID = ?";

    UserType(Integer id) {
        this.id = id;
    }

    private Integer id;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String getCreateSql() {
        return CREATE_SQL;
    }

    @Override
    public String getReadSql() {
        return READ_SQL;
    }

    @Override
    public String getUpdateSql() {
        return UPDATE_SQL;
    }

    @Override
    public String getDeleteSql() {
        return DELETE_SQL;
    }

    @Override
    public void prepareCreateStatement(PreparedStatement stmt) throws SQLException {
        stmt.setString(1, this.toString());
    }

    @Override
    public void prepareReadStatement(PreparedStatement stmt, Integer id) throws SQLException {
        stmt.setInt(1, id);
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public void setDataFromResultSet(ResultSet resultSet) throws SQLException {

    }

    @Override
    public void prepareUpdateStatement(PreparedStatement stmt) throws SQLException {

    }
}
