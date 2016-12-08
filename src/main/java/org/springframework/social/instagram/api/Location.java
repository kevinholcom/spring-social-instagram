package org.springframework.social.instagram.api;

import java.io.Serializable;

public class Location implements Serializable {

	private long id;
	private String name;
	private double latitude;
	private double longitude;

	public Location() {

	}

	public Location(final long id, final String name, final double latitude, final double longitude) {
		this.id = id;
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setId(final long id) {
		this.id = id;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public void setLatitude(final double latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(final double longitude) {
		this.longitude = longitude;
	}

}
