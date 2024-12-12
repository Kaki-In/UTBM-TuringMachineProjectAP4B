package com.turring_machine.listeners;

public interface ObjectsListChangeListener<object_type> {

	public abstract void onObjectAdded(object_type object, ArrayList<object_type> last_list, ArrayList<object_type> new_list);

	public abstract void onObjectDeleted(object_type object, ArrayList<object_type> last_list, ArrayList<object_type> new_list);

}
