package com.jung.doctor.model;

public class Rank {
	private int rankID;
	private String city;

	/**
	 * @return the rankID
	 */
	public int getRankID() {
		return rankID;
	}

	/**
	 * @param rankID
	 *            the rankID to set
	 */
	public void setRankID(int rankID) {
		this.rankID = rankID;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the points
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * @param points
	 *            the points to set
	 */
	public void setPoints(int points) {
		this.points = points;
	}

	private String name;
	private int points;
}
