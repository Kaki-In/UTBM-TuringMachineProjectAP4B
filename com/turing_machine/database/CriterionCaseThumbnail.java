package com.turing_machine.database;

import com.turing_machine.images.ImageDescriptable;

public class CriterionCaseThumbnail {

	private final int case_id;

	private final ImageDescriptable image;

	private final String description;

	protected CriterionCaseThumbnail(int id, String description, ImageDescriptable imageDescriptor) {
		this.image = imageDescriptor;
		this.case_id = id;
		this.description = description;
	}

	public ImageDescriptable getImage() {
		return this.image;
	}

	public int getId() {
		return this.case_id;
	}

	public String getDescription() {
		return this.description;
	}

}
