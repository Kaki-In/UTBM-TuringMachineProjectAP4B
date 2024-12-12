package com.turring_machine.listeners;

public interface ObjectChangeListener<object_type> {

	public abstract void onObjectChanged(object_type last_object, object_type new_object);

}
