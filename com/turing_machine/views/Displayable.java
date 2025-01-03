package com.turing_machine.views;

import java.awt.Component;
import java.awt.Font;

public interface Displayable {

	public final static String FONT_NAME = "";

	public abstract void refresh();

	public abstract Component getWidget();

	public static Font getFont(int size)
	{
		return new Font(FONT_NAME, Font.BOLD, size);
	}

}
