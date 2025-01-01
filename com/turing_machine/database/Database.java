package com.turing_machine.database;

public final class Database {
	private final static ThumbnailsDatabase thumbnails = new ThumbnailsDatabase();
	private final static CriteriaDatabase criteria = new CriteriaDatabase();
	private final static DefaultGamesDatabase games = new DefaultGamesDatabase();

	private Database() {} // force la classe à rester statique

	public final static ThumbnailsDatabase getThumbnails() {
		return thumbnails;
	}

	public static CriteriaDatabase getCriteria() {
		return criteria;
	}

	public static DefaultGamesDatabase getDefaultGames() {
		return games;
	}

}
