package com.ticketbooking.exception;

public class ShowNotFoundException extends Exception {

    public ShowNotFoundException() {
        super("Show not found");
    }

    public ShowNotFoundException(String message) {
        super(message);
    }
}
