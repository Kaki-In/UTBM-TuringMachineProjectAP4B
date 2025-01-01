package com.turing_machine.exceptions;

public class NoSuchCriterionException extends Exception
{
    public NoSuchCriterionException(int case_id) {
        super("unknown criterion : " + case_id);
    }

}


