package com.company;

public class InvalidNumException extends Exception {
    public InvalidNumException(){
        System.err.println("The number you've entered is invalid.");
    }
}
