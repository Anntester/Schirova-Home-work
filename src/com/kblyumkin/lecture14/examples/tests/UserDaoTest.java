package com.kblyumkin.lecture14.examples.tests;

import com.kblyumkin.lecture14.examples.beans.User;
import com.kblyumkin.lecture14.examples.dao.UserDao;
import com.kblyumkin.lecture14.examples.dao.UserDaoImpl;
import com.kblyumkin.lecture14.examples.dao.UserDaoManager;
import org.testng.annotations.*;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class UserDaoTest {
    private UserDao sut;
    private User user;
    private UserDaoManager userDaoManager;

    //Given
    @BeforeTest
    public void setUp() throws SQLException, ClassNotFoundException {
        sut = new UserDaoImpl();
        userDaoManager = new UserDaoManager();
        userDaoManager.truncateUsers();
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(0);
        cal.set(1990, 0, 32, 0, 0, 0);
        user = new User("John", "Smith", "John", "12345", "john@gmail.com",
                new Date(cal.getTimeInMillis()));
    }

    @AfterTest
    public void tearDown() throws SQLException {
        sut.close();
        userDaoManager.close();
    }

    @Test(priority = 1)
    public void testCreateUser() {
        //When
        boolean result = sut.createUser(user);

        //Then
        assertTrue(result);

    }

    @Test(priority = 2)
    public void testGetUserById() {
        //When
        User result = sut.getUserById(1);
        user.setId(result.getId());

        //Then
        assertEquals(result, user);
    }

    @Test(priority = 3)
    public void testUpdateUser() {
        //When
        user.setName("Mike");
        user.setLastName("Black");
        boolean result = sut.updateUser(user);

        //Then
        assertTrue(result);
    }

    @Test(priority = 4)
    public void testDeleteUserById() {
        //When
        boolean result = sut.deleteUserById(1);

        //Then
        assertTrue(result);
    }
}
