package com.turing_machine.database;

import com.turing_machine.images.ImageDescriptable;
import java.awt.image.BufferedImage;

public class CriterionThumbnail {

	private final int criterion_id;

	private final BufferedImage image;

	private final String description;

	protected CriterionThumbnail(int id, String description, ImageDescriptable imageDescriptor) {
		BufferedImage image = new BufferedImage(300, 250, BufferedImage.TYPE_INT_RGB);
		imageDescriptor.createImage(image.createGraphics());

		this.image = image;
		this.criterion_id = id;
		this.description = description;
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
