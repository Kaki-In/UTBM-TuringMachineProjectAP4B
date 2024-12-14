package com.turing_machine.listeners;

public interface ObjectsListModificationLaunchedListener<index_type> {

	public abstract void onObjectCreationLaunched();

	public abstract void onObjectDeletionLaunched(index_type object_id);

}
