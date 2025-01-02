package com.turing_machine.platform_state;

import com.turing_machine.configuration.GameConfiguration;

public class BuildGameStep extends PlatformStep {
    private final GameConfiguration configuration;

    public BuildGameStep(GameConfiguration configuration)
    {
        this.configuration = configuration;
    }

    public GameConfiguration getGameConfiguration()
    {
        return this.configuration;
    }
}
