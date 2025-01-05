package com.turing_machine.views;

import com.turing_machine.base_objects.Code;
import com.turing_machine.base_objects.CodeValue;
import java.awt.event.ItemEvent;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class ChooseCodePanel extends Displayable {

	private final CodeValue[] chosen_values;
	
	private final JPanel panel;

	public ChooseCodePanel() {
		this.panel = new JPanel();
		this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.X_AXIS));

		this.chosen_values = new CodeValue[3];

		for (int i=0; i < 3; ++i)
		{
			this.chosen_values[i] = CodeValue.ONE;

			JComboBox combo = new JComboBox<String>();

			int this_combo_index = i;

			for (int value=1; value <= 5 ; ++value)
			{
				combo.addItem("" + value);
			}

			combo.addItemListener((ItemEvent ie) -> {
				this.chosen_values[this_combo_index] = CodeValue.fromInteger(combo.getSelectedIndex() + 1);
			});

			this.panel.add(combo);
		}
	}

	@Override
	public JComponent getWidget()
	{
		return this.panel;
	}

	@Override
	public void refresh()
	{}

	public Code getCode()
	{
		return new Code(this.chosen_values[0], this.chosen_values[1], this.chosen_values[2]);
	}

}
