package com.turing_machine.views;

import com.turing_machine.base_objects.Code;
import com.turing_machine.base_objects.CodeIndex;
import com.turing_machine.started_game.StartedGameMachine;
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
        this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.Y_AXIS));

        Code code = machine.getCode();

        JPanel indexes_panel = new JPanel();
        indexes_panel.setLayout(new BoxLayout(indexes_panel, BoxLayout.X_AXIS));

        JPanel code_panel = new JPanel();
        code_panel.setLayout(new BoxLayout(code_panel, BoxLayout.X_AXIS));
        
        for (int i=0; i < 3; ++i)
        {
            CodeIndex index = CodeIndex.fromInteger(i);
            indexes_panel.add(new JLabel(new IndexIcon(index, 100)));
            code_panel.add(new JLabel(new ValueIcon(code.getValue(index), 100)));
        }

        this.panel.add(indexes_panel);
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
