package com.turring_machine.listeners;

import com.turring_machine.base_objects.CodeComponent;

public interface PlayerNumbersGridChangeListener {

	public abstract void onNumberValidated(CodeComponent position);

	public abstract void onNumberUnvalidated(CodeComponent position);

}
