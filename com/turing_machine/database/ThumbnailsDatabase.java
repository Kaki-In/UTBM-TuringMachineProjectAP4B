package com.turing_machine.database;

public class ThumbnailsDatabase {

	private CriteriaThumbnailsDatabase criteria;

	private CasesThumbnailsDatabase cases;

	protected ThumbnailsDatabase() {

	}

	public CriteriaThumbnailsDatabase getCriteriaThumbnails() {
		return this.criteria;
	}

	public CasesThumbnailsDatabase getCasesThumbnails() {
		return this.cases;
	}

}
