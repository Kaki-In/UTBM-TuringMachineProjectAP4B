package com.turing_machine.views;

import com.turing_machine.base_objects.Code;
import com.turing_machine.base_objects.CodeIndex;
import com.turing_machine.base_objects.CriterionLetter;
import com.turing_machine.database.CriterionCaseThumbnail;
import com.turing_machine.database.Database;
import com.turing_machine.exceptions.NoSuchCaseException;
import com.turing_machine.started_game.StartedGameCriterion;
import com.turing_machine.started_game.StartedGameMachine;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MachineDiscoveringPanel extends Displayable {

	private final StartedGameMachine machine;
    
    private final JPanel panel;

	public MachineDiscoveringPanel(StartedGameMachine machine) {
        this.machine = machine;

        this.panel = new JPanel();
        this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.X_AXIS));

        JPanel criteria_panel = new JPanel();
        criteria_panel.setLayout(new GridLayout(0, 2));

        for (int i=0; i < machine.getCriteria().getCriteriaCount().toInteger(); ++i)
        {
            CriterionLetter letter = CriterionLetter.fromInteger(i);
            StartedGameCriterion started_criterion = machine.getCriteria().getCriterion(letter);

            CriterionCaseThumbnail thumbnail;
            try {
                thumbnail = Database.getThumbnails().getCasesThumbnails().getCase(started_criterion.getGoodCase().getId());
            } catch (NoSuchCaseException e) {
                System.err.println("Something weird happened here");
                continue;
            }

            JLabel letter_icon = new JLabel(letter.name());
            letter_icon.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, new Color(0, 0, 0, 0)));
            letter_icon.setFont(Displayable.getFont(19).deriveFont(Font.BOLD));
            criteria_panel.add(letter_icon);

            JLabel description = new JLabel(new DescriptableIcon(150, 63, thumbnail.getImage()));
            criteria_panel.add(description);
        }

        this.panel.add(criteria_panel);

        JPanel code_panel = new JPanel();
        code_panel.setLayout(new GridBagLayout());

        Code code = machine.getCode();

        for (int i=0; i < 3; ++i)
        {
            CodeIndex index = CodeIndex.fromInteger(i);

            GridBagConstraints indexConstraints = new GridBagConstraints();
            indexConstraints.gridx = i;
            indexConstraints.gridy = 0;

            code_panel.add(new JLabel(new IndexIcon(index, 100)), indexConstraints);

            GridBagConstraints valueConstraints = new GridBagConstraints();
            valueConstraints.gridx = i;
            valueConstraints.gridy = 1;

            code_panel.add(new JLabel(new ValueIcon(code.getValue(index), 100)), valueConstraints);
        }

        this.panel.add(code_panel);

	}

    @Override
    public void refresh() {
    }

    @Override
    public JComponent getWidget() {
        return this.panel;
    }

}
