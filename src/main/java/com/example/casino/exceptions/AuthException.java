package com.example.casino.exceptions;

import com.example.casino.services.AuthService;

public class AuthException extends RuntimeException{
    public AuthException(){super();}
    public AuthException(String message){super(message);}
    public AuthException(String message, Throwable cause){super(message, cause);}
    public AuthException(Throwable cause){super(cause);}
}
