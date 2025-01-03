package com.turing_machine.views;

import com.turing_machine.configuration.GameConfiguration;
import com.turing_machine.listeners.GameBuildProgressionListener;
import com.turing_machine.platform_state.BuildGameStep;
import com.turing_machine.started_game.StartedGame;
import java.awt.Component;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class GameLoadingPanel extends GameDisplayedPanel implements Displayable {

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
		this.panel.add(infoLabel);

		this.progressBar = new JProgressBar();
		this.progressBar.setMinimum(0);
		this.progressBar.setMaximum(100);
		this.progressBar.setValue(0);

		this.step.whenConfigurationProgress(new GameBuildProgressionListener() {
			@Override
			public void onGameBuildStart(GameConfiguration configuration) {
				setPercent(0);
				setMessage("Veuillez patienter");
			}

			@Override
			public void onGameBuildProgress(GameConfiguration configuration, float progress, String message) {
				setPercent(progress);
				setMessage(message);
			}

			@Override
			public void onGameBuildEnd(GameConfiguration configuration, StartedGame game) {
				setPercent(1);
				setMessage("Configuration terminée");
			}

			@Override
			public void onGameBuildError(GameConfiguration configuration, String reasong) {
				setPercent(0);
				setMessage("Une erreur est intervenue");
			}

		});
	}

	@Override
	public Component getWidget()
	{
		return this.panel;
	}

	@Override
	public void refresh()
	{
		this.progressBar.setValue(Math.round(this.percent*100));
	}

	public synchronized void setPercent(float percent)
	{
		this.percent = percent;
	}

	public synchronized void setMessage(String message)
	{
		this.message = message;
	}

	public synchronized float getPercent()
	{
		return this.percent;
	}

	public synchronized String getMessage()
	{
		return this.message;
	}
}
