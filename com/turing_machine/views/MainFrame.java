package com.turing_machine.views;

import com.turing_machine.platform_state.MainPlatformState;
import java.awt.Component;

public class MainFrame implements Displayable {

	private MainPlatformState state;

	private GameDisplayedPanel displayed_panel;

	public MainFrame(MainPlatformState platform_state) {

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

}
