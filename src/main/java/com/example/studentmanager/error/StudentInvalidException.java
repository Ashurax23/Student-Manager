package com.example.studentmanager.error;

public class StudentInvalidException extends Exception{
    public StudentInvalidException() {
        super();
    }

    public StudentInvalidException(String message) {
        super(message);
    }

    public StudentInvalidException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentInvalidException(Throwable cause) {
        super(cause);
    }

    protected StudentInvalidException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
