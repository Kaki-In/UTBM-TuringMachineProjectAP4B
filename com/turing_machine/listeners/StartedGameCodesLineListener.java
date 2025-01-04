package com.turing_machine.listeners;

import com.turing_machine.base_objects.Code;
import com.turing_machine.started_game.StartedGamePlayerTestedCodeValidationResult;

public interface StartedGameCodesLineListener
{
    public abstract void onCodeDecided(Code code);

    public abstract void onVerificationDone(StartedGamePlayerTestedCodeValidationResult result);
}

