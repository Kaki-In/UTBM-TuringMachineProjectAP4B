package com.turing_machine.views;

import com.turing_machine.platform_state.BuildGameStep;
import com.turing_machine.platform_state.ConfiguratingGameStep;
import com.turing_machine.platform_state.GameDebriefingStep;
import com.turing_machine.platform_state.MainPlatformState;
import com.turing_machine.platform_state.StartedGameStep;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainFrame extends Displayable {

	private final MainPlatformState state;

	private GameDisplayedPanel displayed_panel;

	private final JFrame frame;

	public MainFrame(MainPlatformState platform_state) {
		this.state = platform_state;

		this.frame = new JFrame();
		this.frame.getContentPane().setLayout(new BoxLayout(this.frame.getContentPane(), BoxLayout.Y_AXIS));
		this.frame.setTitle("Turing Machine Game - UTBM A2024 - Groupe Dmitri Pavlovsky");
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.displayed_panel = getStatePanel();
		this.displayed_panel.whenShouldReload(() -> {reloadParent();});

		this.constructFrame();

		platform_state.whenPlatformStepChanged((last_state, new_state) -> {
			this.displayed_panel = getStatePanel();
			
			reloadParent();

			this.displayed_panel.whenShouldReload(() -> {reloadParent();});
		});
	}

	public void constructFrame()
	{
		this.frame.getContentPane().removeAll();
		this.frame.repaint();

		JLabel label = new JLabel("Turing Machine");
		label.setFont(Displayable.getFont(35));
		label.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		label.setHorizontalAlignment(JLabel.CENTER);
		
		this.frame.getContentPane().add(label);

		this.frame.getContentPane().add(this.displayed_panel.getWidget());

		frame.setMinimumSize(frame.getPreferredSize());
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
	public void reloadParent()
	{
		super.reloadParent();

		javax.swing.SwingUtilities.invokeLater(() -> refresh());
	}

	@Override
	public JComponent getWidget()
	{
		return null;
	}

	@Override
	public void refresh()
	{
		this.displayed_panel.refresh();
		this.constructFrame();

		this.frame.revalidate();
	}

}
