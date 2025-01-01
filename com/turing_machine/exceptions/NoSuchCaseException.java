package com.turing_machine.exceptions;

public class NoSuchCaseException extends Exception
{
    public NoSuchCaseException(int case_id) {
        super("unknown criterion case : " + case_id);
    }

}


