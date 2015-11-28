package com.kblyumkin.lecture15.examples.jdbc.dao;

import com.kblyumkin.lecture15.examples.jdbc.beans.DataBaseBeanInterface;
import com.kblyumkin.lecture15.examples.jdbc.exceptions.GenericDaoException;

import javax.sql.DataSource;
import java.io.Serializable;
import java.sql.*;

public class GenericDaoImpl <T extends DataBaseBeanInterface<PK>, PK extends Serializable> implements GenericDao <T, PK> {

    private Class<T> type;
    private DataSource dataSource;

    protected GenericDaoImpl(DataSource dataSource, Class<T> type) {
        this.dataSource = dataSource;
        this.type = type;

    }

    @Override
    public PK create(T objectToCreate) {
        try (Connection con = dataSource.getConnection()) {
            prepareConnection(con);
            PreparedStatement stmt =
                    con.prepareStatement(objectToCreate.getCreateSql(),
                            Statement.RETURN_GENERATED_KEYS);
            objectToCreate.prepareCreateStatement(stmt);
            stmt.execute();
            ResultSet resultSet = stmt.getGeneratedKeys();
            if (resultSet.next()) {
                PK id = (PK) new Integer(resultSet.getInt(1));
                objectToCreate.setId(id);
                con.commit();
                return id;
            }
        } catch (SQLException e) {
            throw new GenericDaoException("Error saving user to data base", e);
        }
        throw new GenericDaoException("Error saving user to data base");
    }

    @Override
    public T read(PK id) {
        try (Connection con = dataSource.getConnection()) {
            prepareConnection(con);
            T result = type.newInstance();
            PreparedStatement stmt = con.prepareStatement(result.getReadSql());
            result.prepareReadStatement(stmt, id);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                result.setId(id);
                result.setDataFromResultSet(resultSet);
                con.commit();
                return result;
            }
        } catch (SQLException | InstantiationException | IllegalAccessException e) {
            throw new GenericDaoException("Error reading user from data base", e);
        }
        throw new GenericDaoException("Error reading user from data base");
    }

    @Override
    public void update(T objectToUpdate) {
        try(Connection con = dataSource.getConnection()) {
            prepareConnection(con);
            PreparedStatement stmt = con.prepareStatement(objectToUpdate.getUpdateSql(),
                    Statement.RETURN_GENERATED_KEYS);
            objectToUpdate.prepareUpdateStatement(stmt);
            int countOfUpdatedRows = stmt.executeUpdate();
            if (countOfUpdatedRows == 1) {
                con.commit();
                return;
            } else {
                con.rollback();
                throw new GenericDaoException("Error updating user 0 or more than 1 user was found. ROLLBACK!");
            }

        } catch (SQLException e) {
            throw new GenericDaoException("Error updating user", e);
        }

    }

    @Override
    public void delete(T objectToDelete) {

    }

    private void prepareConnection(Connection connection) throws SQLException {
        connection.setAutoCommit(false);
        connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
    }
}
