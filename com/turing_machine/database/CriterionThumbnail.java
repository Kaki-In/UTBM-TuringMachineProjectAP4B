package com.turing_machine.database;

import com.turing_machine.images.ImageDescriptable;
import java.awt.image.BufferedImage;

public class CriterionThumbnail {

	private final int criterion_id;

	private final BufferedImage image;

	private final String description;

	protected CriterionThumbnail(int id, String description, ImageDescriptable imageDescriptor) {
		this.image = new BufferedImage(300, 250, BufferedImage.TYPE_INT_RGB);
		this.criterion_id = id;
		this.description = description;

		imageDescriptor.createImage(image.createGraphics());
	}

	public int getId() {
		return this.criterion_id;
	}

	public BufferedImage getMainThumbnail() {
		return this.image;
	}

	public String getDescription() {
		return this.description;
	}

}
