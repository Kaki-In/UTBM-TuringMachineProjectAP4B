package com.turing_machine.views;

import com.turing_machine.platform_state.BuildGameStep;
import com.turing_machine.platform_state.ConfiguratingGameStep;
import com.turing_machine.platform_state.GameDebriefingStep;
import com.turing_machine.platform_state.MainPlatformState;
import com.turing_machine.platform_state.StartedGameStep;
import java.awt.Component;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainFrame implements Displayable {

	private final MainPlatformState state;

	private final GameDisplayedPanel displayed_panel;

	private final JFrame frame;

	public MainFrame(MainPlatformState platform_state) {
		this.state = platform_state;

		this.frame = new JFrame();
		this.frame.setLayout(new BoxLayout(this.frame, BoxLayout.Y_AXIS));
		this.frame.setTitle("Turing Machine Game - UTBM A2024 - Groupe Dmitri Pavlovsky");

		this.displayed_panel = getStatePanel();

		this.constructFrame();
	}

	public void constructFrame()
	{
		this.frame.removeAll();

		JLabel label = new JLabel("Turing Machine");
		label.setFont(Displayable.getFont(35));
		this.frame.add(label);

		this.frame.add(this.displayed_panel.getWidget());
	}

	public GameDisplayedPanel getStatePanel()
	{
		if (state.getActualStep() instanceof ConfiguratingGameStep confStep)
		{
			return new GameConfigurationPanel(confStep);
		}

		if (state.getActualStep() instanceof BuildGameStep buildStep)
		{
			return new GameLoadingPanel(buildStep);
		}

		if (state.getActualStep() instanceof StartedGameStep playStep)
		{
			return new StartedGamePanel(playStep);
		}

		if (state.getActualStep() instanceof  GameDebriefingStep debriefStep)
		{
			return new GameDebriefPanel(debriefStep);
		}

		return null;
	}

	public JFrame getFrame()
	{
		return this.frame;
	}

	@Override
	public Component getWidget()
	{
		return this.frame;
	}

	@Override
	public void refresh()
	{
	}

}
