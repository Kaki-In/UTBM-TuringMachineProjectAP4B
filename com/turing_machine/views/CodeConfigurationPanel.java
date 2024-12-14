package com.turing_machine.views;

import java.util.ArrayList;
import com.turing_machine.listeners.CodeConfigurationChangeListener;
import com.turing_machine.configuration.MachineConfiguration;

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
