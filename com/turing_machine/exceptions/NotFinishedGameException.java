package com.turing_machine.exceptions;

public class NotFinishedGameException extends Exception
{
    public NotFinishedGameException()
    {
        super("game is not finished yet");
    }
}


