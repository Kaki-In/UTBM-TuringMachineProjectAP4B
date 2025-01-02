package com.turing_machine.platform_state;

import com.turing_machine.configuration.GameConfiguration;
import com.turing_machine.listeners.PlatformStepChangeListener;
import java.util.ArrayList;

public class MainPlatformState {

	private PlatformStep actual_step;

	private final ArrayList<PlatformStepChangeListener> listeners;

	public MainPlatformState() {
		this.actual_step = new ConfiguratingGameStep(new GameConfiguration());
		this.listeners = new ArrayList<>();
	}

	public PlatformStep getActualStep() {
		return this.actual_step;
	}

	public void setActualStep(PlatformStep step) {
		PlatformStep last_step = step;
		this.actual_step = step;

		for (PlatformStepChangeListener listener: this.listeners)
		{
			listener.onPlatformStepChanged(last_step, step);
		}
	}

	public void whenPlatformStepChanged(PlatformStepChangeListener listener)
	{
		this.listeners.add(listener);
	}

}
