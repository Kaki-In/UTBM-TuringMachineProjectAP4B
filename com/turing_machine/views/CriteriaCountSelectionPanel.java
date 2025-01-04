package com.turing_machine.views;

import com.turing_machine.base_objects.GameCriteriaCount;
import com.turing_machine.listeners.ObjectSelectionListener;
import javax.swing.JComponent;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class CriteriaCountSelectionPanel extends Displayable {

	private final ArrayList<ObjectSelectionListener<GameCriteriaCount>> listeners;
	
	private final JComboBox comboBox;

	private GameCriteriaCount count;

	public CriteriaCountSelectionPanel() {
		this.listeners = new ArrayList<>();

		this.count = GameCriteriaCount.FOUR_CRITERIA;
		
		this.comboBox = new JComboBox<String>();

		this.comboBox.addItem("4 critères");
		this.comboBox.addItem("5 critères");
		this.comboBox.addItem("6 critères");

		this.comboBox.setSelectedIndex(0);

		this.comboBox.addItemListener((ItemEvent ie) -> {
			int selectedIndex = this.comboBox.getSelectedIndex();

			setCriteriaCount(GameCriteriaCount.fromInteger(selectedIndex + 4));
		});
	}

	@Override
	public JComponent getWidget()
	{
		return this.comboBox;
	}

	@Override
	public void refresh()
	{
		int index = this.count.toInteger() - 4;
		this.comboBox.setSelectedIndex(index);
	}

	public GameCriteriaCount getCriteriaCount() {
		return this.count;
	}

	public void setCriteriaCount(GameCriteriaCount count) {
		if (count == this.count) return;

		this.count = count;

		for (ObjectSelectionListener<GameCriteriaCount> listener: this.listeners)
		{
			listener.onObjectSelected(this.count);
		}
	}

	public void whenCriteriaCountSelected(ObjectSelectionListener<GameCriteriaCount> listener) {
		this.listeners.add(listener);
	}

}
