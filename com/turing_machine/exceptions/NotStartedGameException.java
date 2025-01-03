package com.turing_machine.exceptions;

public class NotStartedGameException extends Exception
{
    public NotStartedGameException()
    {
        super("game is not started yet");
    }
}


