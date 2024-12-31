package com.turing_machine.views;

import com.turing_machine.configuration.MachineConfiguration;
import com.turing_machine.listeners.CodeConfigurationChangeListener;
import java.awt.Component;
import java.util.ArrayList;

public class CodeConfigurationPanel implements Displayable {

	private ArrayList<CodeConfigurationChangeListener> listeners;

	private MachineConfiguration configuration;

	private GameDifficultySelectionPanel difficulty;

	private CriteriaCountSelectionPanel count;

	public CodeConfigurationPanel(MachineConfiguration configuration) {

	}

	@Override
	public Component getWidget()
	{
		return null;
	}

	@Override
	public void refresh()
	{
	}

	public void whenCodeConfigurationChanged(CodeConfigurationChangeListener listener) {

	}

}
