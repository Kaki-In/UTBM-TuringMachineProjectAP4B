package com.turing_machine.views;

import com.turing_machine.base_objects.GameDifficulty;
import com.turing_machine.listeners.ObjectSelectionListener;
import javax.swing.JComponent;
import java.awt.event.ItemEvent;
import java.rmi.NoSuchObjectException;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class GameDifficultySelectionPanel extends Displayable {

	private final ArrayList<ObjectSelectionListener<GameDifficulty>> listeners;
	
	private final JComboBox comboBox;

	private GameDifficulty difficulty;

	public GameDifficultySelectionPanel() {
		this.listeners = new ArrayList<>();

		this.difficulty = GameDifficulty.STANDARD;

		this.comboBox = new JComboBox<String>();
		this.comboBox.addItem("Facile");
		this.comboBox.addItem("Normal");
		this.comboBox.addItem("Difficile");

		this.comboBox.setSelectedIndex(1);

		this.comboBox.addItemListener((ItemEvent ie) -> {
			int selectedIndex = this.comboBox.getSelectedIndex();

			try {
				setGameDifficulty(integerToDifficulty(selectedIndex));
			} catch (NoSuchObjectException e) {
				System.err.println("Warning : unknown difficulty index " + selectedIndex);
			}
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
		this.comboBox.setSelectedIndex(difficultyToInteger(this.difficulty));
	}

	public GameDifficulty getGameDifficulty() {
		return this.difficulty;
	}

	public void setGameDifficulty(GameDifficulty difficulty) {
		if (difficulty == this.difficulty) return ;

		this.difficulty = difficulty;

		for (ObjectSelectionListener<GameDifficulty> listener: this.listeners)
		{
			listener.onObjectSelected(this.difficulty);
		}
	}

	public void whenGameDifficultySelected(ObjectSelectionListener<GameDifficulty> listener) {
		this.listeners.add(listener);
	}


	public static int difficultyToInteger(GameDifficulty difficulty)
	{
		switch (difficulty) {
			case GameDifficulty.EASY:
				return 0;
			case GameDifficulty.STANDARD:
				return 1;
			case GameDifficulty.HARD:
				return 2;
		}

		return -1;
	}

	public static GameDifficulty integerToDifficulty(int difficulty) throws NoSuchObjectException
	{
		switch (difficulty) {
			case 0:
				return GameDifficulty.EASY;
			case 1:
				return GameDifficulty.STANDARD;
			case 2:
				return GameDifficulty.HARD;
		}

		throw new NoSuchObjectException(difficulty + " is not a valid game difficulty");
	}
}
