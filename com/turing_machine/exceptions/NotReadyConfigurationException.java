package com.turing_machine.exceptions;

public class NotReadyConfigurationException extends Exception
{
    public NotReadyConfigurationException()
    {
        super("configuration is not ready yet");
    }
}


