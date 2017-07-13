package org.springframework.social.instagram.api;

import java.io.Serializable;

public class Tag implements Serializable {

	private int mediaCount;
	private String name;

	public Tag(String name, int mediaCount) {
		this.name = name;
		this.mediaCount = mediaCount;
	}

	public int getMediaCount() {
		return mediaCount;
	}

	public String getName() {
		return name;
	}

}
