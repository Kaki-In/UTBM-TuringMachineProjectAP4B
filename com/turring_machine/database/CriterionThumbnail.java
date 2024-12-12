package com.turring_machine.database;

import com.turring_machine.images.Image;

public class CriterionThumbnail {

	private int criterion_id;

	private Image image;

	private ArrayList<CriterionCaseThumbnail> cases;

	public CriterionThumbnail(int id) {

	}

	public CriterionThumbnail(int id, Image image, ArrayList<CriterionCaseThumbnail> cases) {

	}

	public int getId() {
		return 0;
	}

	public Image getMainThumbnail() {
		return null;
	}

	public ArrayList<CriterionCaseThumbnail> getDistinctCases() {
		return null;
	}

	public void setMainThumbnail(Image image) {

	}

	public void addCaseThumbnail(CriterionCaseThumbnail case) {

	}

}
