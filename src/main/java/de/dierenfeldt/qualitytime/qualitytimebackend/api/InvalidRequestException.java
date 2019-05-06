package de.dierenfeldt.qualitytime.qualitytimebackend.api;

public class InvalidRequestException extends Exception {

    public InvalidRequestException(String message) {
            super(message);
    }

}