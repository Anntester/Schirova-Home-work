package com.kblyumkin.lecture14.examples.exceptions;

public class UserDaoException extends RuntimeException {
    public UserDaoException(String reason) {
        super(reason);
    }

    public UserDaoException(String reason, Exception e) {
        super(reason, e);
    }
}
