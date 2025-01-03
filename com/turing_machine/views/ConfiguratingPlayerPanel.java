package com.turing_machine.views;

import com.turing_machine.configuration.PlayerConfiguration;
import java.awt.Component;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ConfiguratingPlayerPanel implements Displayable {

	private final PlayerConfiguration configuration;

	private String name;

	private final JTextField field;

	public ConfiguratingPlayerPanel(PlayerConfiguration configuration) {
		this.configuration = configuration;
		this.name = configuration.getName();

		this.field = new JTextField();
		this.field.setText(this.name);

		configuration.whenNameChanged((last_name, new_name) -> {
			this.setName(new_name);
		});

		this.field.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent de) {
				setName(field.getText());
			}

			@Override
			public void removeUpdate(DocumentEvent de) {
				setName(field.getText());
			}

			@Override
			public void changedUpdate(DocumentEvent de) {
				setName(field.getText());
			}
		});

	}

	public PlayerConfiguration getConfiguration()
	{
		return this.configuration;
	}

	@Override
	public Component getWidget()
	{
		return this.field;
	}

	@Override
	public void refresh()
	{
		this.field.setName(this.getName());
	}

	public synchronized String getName() {
		return this.name;
	}

	public synchronized void setName(String name) {
		if (this.name.equals(name)) return;

		String last_name = this.name;
		this.name = name;

		this.configuration.setName(name);
	}

}
