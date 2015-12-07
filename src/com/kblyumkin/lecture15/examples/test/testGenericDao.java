package com.kblyumkin.lecture15.examples.test;

import com.kblyumkin.lecture15.examples.jdbc.beans.User;
import com.kblyumkin.lecture15.examples.jdbc.dao.AbstractDaoFactory;
import com.kblyumkin.lecture15.examples.jdbc.dao.GenericDao;
import com.kblyumkin.lecture15.examples.jdbc.exceptions.GenericDaoException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.Date;
import java.util.Calendar;

import static com.kblyumkin.lecture15.examples.test.RandomGenerator.getRandomString;
import static com.kblyumkin.lecture15.examples.test.RandomGenerator.getRandomUserType;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

public class testGenericDao {
    private static final String NEW_NAME      = "Mike";
    private static final String NEW_LAST_NAME = "Stevenson";

    private GenericDao<User, Integer> sut;
    private User doc;

    //Given
    @BeforeTest
    public void setUp() {
        sut = AbstractDaoFactory.getDaoFactory(User.class).getDao();
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(0);
        cal.set(1990, 0, 27, 0, 0, 0);
        doc = new User("John", "Smith", "John_" + getRandomString(), "12345", "john_" + getRandomString() + "@gmail.com",
                new Date(cal.getTimeInMillis()), getRandomUserType());
    }

    @Test(priority = 1)
    public void testCreate() {
        //When
        int id = sut.create(doc);

        //Then
        assertTrue(id > 0);
        assertNotNull(sut.read(id));
    }

    @Test(
        priority = 2,
        //Then
        expectedExceptions = {GenericDaoException.class},
        expectedExceptionsMessageRegExp = "Error saving user to data base")
    public void testCreateNegativeCase() {
        //Given
        User emptyUser = new User();
        emptyUser.setUserType(getRandomUserType());

        //When
        sut.create(emptyUser);
    }

    @Test(priority = 3)
    public void testRead() {
        //When
        User readUser = sut.read(doc.getId());

        //Then
        assertNotNull(readUser);
        assertEquals(readUser, doc);
    }

    @Test(priority = 4)
    public void testUpdate() {
        //Given
        doc.setName(NEW_NAME);
        doc.setLastName(NEW_LAST_NAME);

        //When
        sut.update(doc);

        //Then
        assertEquals(NEW_NAME, sut.read(doc.getId()).getName());
        assertEquals(NEW_LAST_NAME, sut.read(doc.getId()).getLastName());
    }

    @Test(
        priority = 5,
        //Then
        expectedExceptions = {GenericDaoException.class},
        expectedExceptionsMessageRegExp = "Error reading user from data base")
    public void testDelete() {
        //When
        sut.delete(doc);

        //Then
        sut.read(doc.getId());
    }
}
