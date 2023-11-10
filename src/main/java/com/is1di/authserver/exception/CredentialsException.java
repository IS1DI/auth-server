package com.is1di.authserver.exception;

public class CredentialsException extends RuntimeException {
    public CredentialsException() {
    }

    public CredentialsException(String message) {
        super(message);
    }
}
