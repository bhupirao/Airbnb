package com.airbnb.Exception;

public class BookingException extends Exception{

    public BookingException() {
    }

    public BookingException(String message) {
        super(message);
    }
}
