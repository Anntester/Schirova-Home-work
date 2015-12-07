package com.kblyumkin.lecture15.examples.jdbc.beans;

import com.kblyumkin.lecture15.examples.jdbc.exceptions.GenericDaoException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Properties;

public abstract class AbstractDataBaseBean<PK extends Serializable> implements DataBaseBeanInterface<PK> {
    protected final String READ_SQL;
    protected final String DELETE_SQL;
    protected final String CREATE_SQL;
    protected final String UPDATE_SQL;

    private static final String RESOURCES_DB_PROPERTIES = "/Users/kblyumkin/Projects/SourceIt/src/com/kblyumkin/lecture15/examples/resources/db.properties";

    {
        Properties props = new Properties();
        try {
            FileInputStream fis = new FileInputStream(
                                      new File(RESOURCES_DB_PROPERTIES));
            props.load(fis);
            READ_SQL   = props.getProperty("sql." + this.getClass().getSimpleName().toLowerCase() + ".read");
            DELETE_SQL = props.getProperty("sql." + this.getClass().getSimpleName().toLowerCase() + ".delete");
            CREATE_SQL = props.getProperty("sql." + this.getClass().getSimpleName().toLowerCase() + ".create");
            UPDATE_SQL = props.getProperty("sql." + this.getClass().getSimpleName().toLowerCase() + ".update");
        } catch (IOException e) {
            throw new GenericDaoException("Error loading SQL definitions", e);
        }
    }
}