package com.turing_machine.listeners;

import com.turing_machine.platform_state.PlatformStep;

public interface PlatformStepChangeListener
{
    public void onPlatformStepChanged(PlatformStep last_step, PlatformStep new_step);
}



