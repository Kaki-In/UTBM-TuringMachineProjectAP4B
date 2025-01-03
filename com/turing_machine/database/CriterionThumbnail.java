package com.turing_machine.database;

import com.turing_machine.images.ImageDescriptable;

public class CriterionThumbnail {

	private final int criterion_id;

	private final ImageDescriptable image;

	private final String description;

	protected CriterionThumbnail(int id, String description, ImageDescriptable imageDescriptor) {
		this.image = imageDescriptor;
		this.criterion_id = id;
		this.description = description;
	}

	public int getId() {
		return this.criterion_id;
	}

	public ImageDescriptable getMainThumbnail() {
		return this.image;
	}

	public String getDescription() {
		return this.description;
	}

}
