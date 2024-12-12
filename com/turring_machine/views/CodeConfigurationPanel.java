package com.turring_machine.views;

import com.turring_machine.listeners.CodeConfigurationChangeListener;
import com.turring_machine.configuration.MachineConfiguration;
import com.turring_machine.configuration.CodeConfiguration;

public class CodeConfigurationPanel implements Displayable {

	private ArrayList<CodeConfigurationChangeListener> listeners;

	private MachineConfiguration configuration;

	private GameDifficultySelectionPanel difficulty;

	private CriteriaCountSelectionPanel count;

	public CodeConfigurationPanel(MachineConfiguration configuration) {

	}

	public void whenCodeConfigurationChanged(CodeConfigurationChangeListener listener) {

	}

}
