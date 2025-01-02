package com.turing_machine.database;

public class ThumbnailsDatabase {

	private final CriteriaThumbnailsDatabase criteria;
	private final CasesThumbnailsDatabase cases;

	protected ThumbnailsDatabase() {
		this.criteria = new CriteriaThumbnailsDatabase();
		this.cases = new CasesThumbnailsDatabase();
	}

	public CriteriaThumbnailsDatabase getCriteriaThumbnails() {
		return this.criteria;
	}

	public CasesThumbnailsDatabase getCasesThumbnails() {
		return this.cases;
	}

}
