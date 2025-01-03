package com.turing_machine.platform_state;

import com.turing_machine.configuration.GameConfiguration;
import com.turing_machine.listeners.GameBuildProgressionListener;
import com.turing_machine.started_game.StartedGame;
import java.util.ArrayList;

public class BuildGameStep extends PlatformStep {
    private final GameConfiguration configuration;

    private final ArrayList<GameBuildProgressionListener> listeners;

    public BuildGameStep(GameConfiguration configuration)
    {
        this.configuration = configuration;

        this.listeners = new ArrayList<>();
    }

    public GameConfiguration getGameConfiguration()
    {
        return this.configuration;
    }

    public void emitConfigurationStart()
    {
        for (GameBuildProgressionListener listener : this.listeners)
        {
            listener.onGameBuildStart(this.configuration);
        }
    }

    public void emitConfigurationProgress(double progress, String message)
    {
        for (GameBuildProgressionListener listener : this.listeners)
        {
            listener.onGameBuildProgress(this.configuration, progress, message);
        }
    }

    public void emitConfigurationEnd(StartedGame game)
    {
        for (GameBuildProgressionListener listener : this.listeners)
        {
            listener.onGameBuildEnd(this.configuration, game);
        }
    }

    public void emitConfigurationError(String reason)
    {
        for (GameBuildProgressionListener listener : this.listeners)
        {
            listener.onGameBuildError(this.configuration, reason);
        }
    }
}
