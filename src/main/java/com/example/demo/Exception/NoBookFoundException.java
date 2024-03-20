package com.example.demo.Exception;

public class NoBookFoundException
extends RuntimeException {

private String message;

public NoBookFoundException() {}

public NoBookFoundException(String msg)
{
    super(msg);
    this.message = msg;
}
}