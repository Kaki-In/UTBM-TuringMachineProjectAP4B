package com.turing_machine.views;

import com.turing_machine.database.CriterionThumbnail;
import com.turing_machine.database.Database;
import com.turing_machine.exceptions.NoSuchCriterionException;
import com.turing_machine.started_game.StartedGamePlayerCriterion;
import com.turing_machine.started_game.StartedGamePlayerCriterionCase;
import java.awt.Color;
import javax.swing.JComponent;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartedGamePlayerCriterionPanel extends Displayable {

	private StartedGamePlayerCriterion criterion;

	private ArrayList<StartedGamePlayerCriterionCasePanel> cases;

	private final JPanel panel;

	public StartedGamePlayerCriterionPanel(StartedGamePlayerCriterion criterion) {
		this.criterion = criterion;

		this.panel = new JPanel();
		this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.Y_AXIS));

		Color background_color = new Color(230, 230, 230);
		this.panel.setBackground(background_color);
		this.panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		CriterionThumbnail thumbnail;
		try {
			thumbnail = Database.getThumbnails().getCriteriaThumbnails().getCriterionThumbnail(criterion.getId());
		} catch (NoSuchCriterionException e) {
			System.err.println("Warning : couldn't find criterion thumbnail " + criterion.getId());
			throw new AssertionError("something weird happened");
		}

		JPanel description_panel = new JPanel();
		description_panel.setBackground(background_color);
		description_panel.setLayout(new BoxLayout(description_panel, BoxLayout.Y_AXIS));

		JLabel introduction = new JLabel("<html>Ce critère (" + criterion.getLetter().name() + ") vérifie...</html>");
		introduction.setFont(Displayable.getFont(15));
		introduction.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		description_panel.add(introduction);

		JLabel description = new JLabel("<html>" + thumbnail.getDescription() + "</html>");
		description.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		description_panel.add(description);

		this.panel.add(description_panel);

		this.cases = new ArrayList<>();

		ArrayList<StartedGamePlayerCriterionCase> cases = criterion.getCases();

		int columns;
		switch (cases.size()) {
			case 2:
				columns = 2;
				break;

			case 3:
				columns = 3;
				break;
			
			case 4:
				columns = 2;
				break;
			
			case 6:
				columns = 3;
				break;
			
			case 9:
				columns = 3;
				break;

			default:
				columns = Math.round((float) Math.sqrt(cases.size())) + 1; // peu probable, mais logiquement possible
		}

		for (int i = 0; i < cases.size(); ++i)
		{
			StartedGamePlayerCriterionCasePanel case_panel = new StartedGamePlayerCriterionCasePanel(cases.get(i));
			case_panel.whenShouldReload(() -> this.reloadParent());

			this.cases.add(case_panel);

			this.panel.add(case_panel.getWidget());
		}

		HintTextField player_notes = new HintTextField("Notes...");
		this.panel.add(player_notes);

		this.panel.setMinimumSize(new Dimension(300, (int) this.panel.getPreferredSize().getHeight() + 100));
		this.panel.setPreferredSize(new Dimension(300, (int) this.panel.getPreferredSize().getHeight() + 100));
	}

	@Override
	public JComponent getWidget()
	{
		return this.panel;
	}

	@Override
	public void refresh()
	{
		for (StartedGamePlayerCriterionCasePanel case_panel: this.cases)
		{
			case_panel.refresh();
		}
	}

}
