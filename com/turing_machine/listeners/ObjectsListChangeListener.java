package com.turing_machine.listeners;

import java.util.ArrayList;

public interface ObjectsListChangeListener<object_type> {

	public abstract void onObjectAdded(object_type object, ArrayList<object_type> new_list);

	public abstract void onObjectDeleted(object_type object, ArrayList<object_type> new_list);

}
