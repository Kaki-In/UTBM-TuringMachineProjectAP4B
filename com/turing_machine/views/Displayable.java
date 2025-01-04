package com.turing_machine.views;

import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JComponent;

public abstract class Displayable {

	public final static String FONT_NAME = "";

	private final ArrayList<Runnable> reload_listeners;

	public Displayable()
	{
		this.reload_listeners = new ArrayList<>();
	}

	public void reloadParent() {

		for (Runnable listener: this.reload_listeners)
		{
			listener.run();
		}
	};

	public abstract void refresh();

	public abstract JComponent getWidget();

	public static Font getFont(int size)
	{
		return new Font(FONT_NAME, Font.BOLD, size);
	}

	public void whenShouldReload(Runnable listener)
	{
		this.reload_listeners.add(listener);
	}

}
