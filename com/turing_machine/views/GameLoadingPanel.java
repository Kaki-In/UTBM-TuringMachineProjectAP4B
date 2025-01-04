package com.turing_machine.views;

import com.turing_machine.configuration.GameConfiguration;
import com.turing_machine.listeners.GameBuildProgressionListener;
import com.turing_machine.platform_state.BuildGameStep;
import com.turing_machine.started_game.StartedGame;
import javax.swing.JComponent;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class GameLoadingPanel extends GameDisplayedPanel {

	private float percent;

	private String message;

	private final BuildGameStep step;

	private final JPanel panel;
	private final JProgressBar progressBar;
	private final JLabel infoLabel;

	public GameLoadingPanel(BuildGameStep step) {
		super(step);

		this.percent = 0;
		this.message = "Veuillez patienter";

		this.step = step;

		this.panel = new JPanel();
		this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.Y_AXIS));

		this.infoLabel = new JLabel(this.message);
		this.infoLabel.setAlignmentX(JPanel.LEFT_ALIGNMENT);
		this.panel.add(this.infoLabel);

		this.progressBar = new JProgressBar();
		this.progressBar.setMinimum(0);
		this.progressBar.setMaximum(100);
		this.progressBar.setValue(0);
		this.panel.add(this.progressBar);

		this.step.whenConfigurationProgress(new GameBuildProgressionListener() {
			@Override
			public void onGameBuildStart(GameConfiguration configuration) {
				setPercent(0);
				setMessage("Veuillez patienter");
				reloadParent();
			}

			@Override
			public void onGameBuildProgress(GameConfiguration configuration, float progress, String message) {
				setPercent(progress);
				setMessage(message);
				reloadParent();
			}

			@Override
			public void onGameBuildEnd(GameConfiguration configuration, StartedGame game) {
				setPercent(1);
				setMessage("Configuration terminée");
				reloadParent();
			}

			@Override
			public void onGameBuildError(GameConfiguration configuration, String reasong) {
				setPercent(0);
				setMessage("Une erreur est intervenue");
				reloadParent();
			}

		});
	}

	@Override
	public JComponent getWidget()
	{
		return this.panel;
	}

	@Override
	public void refresh()
	{
		this.progressBar.setValue(Math.round(this.percent*100));
		this.infoLabel.setText(this.message);
	}

	public void setPercent(float percent)
	{
		this.percent = percent;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public float getPercent()
	{
		return this.percent;
	}

	public String getMessage()
	{
		return this.message;
	}
}
