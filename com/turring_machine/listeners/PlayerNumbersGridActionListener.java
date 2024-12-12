package com.turring_machine.listeners;

import com.turring_machine.base_objects.CodeComponent;

public interface PlayerNumbersGridActionListener {

	public abstract void onValidateComponentLaunched(CodeComponent position);

	public abstract void onUnvalidateComponentLaunched(CodeComponent position);

}
