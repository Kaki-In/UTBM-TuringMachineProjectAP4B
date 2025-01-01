package com.turing_machine.exceptions;

public class NoSuchGameException extends Exception
{
    public NoSuchGameException(int game_id) {
        super("unknown default game : " + game_id);
    }

}


