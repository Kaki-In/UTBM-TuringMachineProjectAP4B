package com.turing_machine.database;

import com.turing_machine.images.ImageDescriptable;
import java.awt.image.BufferedImage;

public class CriterionCaseThumbnail {

	private final int case_id;

	private final BufferedImage image;

	private final String description;

	protected CriterionCaseThumbnail(int id, String description, ImageDescriptable imageDescriptor) {
		this.image = new BufferedImage(300, 125, BufferedImage.TYPE_INT_RGB);
		this.case_id = id;
		this.description = description;

		imageDescriptor.createImage(this.image.createGraphics());
	}

	public BufferedImage getImage() {
		return this.image;
	}

	public int getId() {
		return this.case_id;
	}

	public String getDescription() {
		return this.description;
	}

}
