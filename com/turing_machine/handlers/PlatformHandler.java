package com.turing_machine.handlers;

import com.turing_machine.platform_state.MainPlatformState;


public class PlatformHandler
{
    private final MainPlatformState state;
    
    public PlatformHandler(MainPlatformState state)
    {
        this.state = state;
    }

    public MainPlatformState getState()
    {
        return this.state;
    }
}

