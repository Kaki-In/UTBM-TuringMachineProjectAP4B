package com.turing_machine.views;

import com.turing_machine.configuration.PlayerConfiguration;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ConfiguratingPlayerPanel extends Displayable {

	private final PlayerConfiguration configuration;

	private String name;

	private final JTextField field;

	public ConfiguratingPlayerPanel(PlayerConfiguration configuration) {
		this.configuration = configuration;
		this.name = configuration.getName();

		this.field = new JTextField();
		this.field.setText(this.name);

		configuration.whenNameChanged((last_name, new_name) -> {
			setName(new_name);
			reloadParent();
		});

		this.field.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent de) {
				configuration.setName(field.getText());
			}

			@Override
			public void removeUpdate(DocumentEvent de) {
				configuration.setName(field.getText());
			}

			@Override
			public void changedUpdate(DocumentEvent de) {
				configuration.setName(field.getText());
			}
		});

	}

	public PlayerConfiguration getConfiguration()
	{
		return this.configuration;
	}

	@Override
	public JComponent getWidget()
	{
		return this.field;
	}

	@Override
	public void refresh()
	{
		this.field.setName(this.getName());
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		if (this.name.equals(name)) return;

		this.name = name;
	}

}
