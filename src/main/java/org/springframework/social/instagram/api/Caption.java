package org.springframework.social.instagram.api;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Caption implements Serializable {

	private long id;
	@JsonProperty("created_time")
	private Date createdTime;
	private String text;
	private InstagramProfile from;

	public Caption() {

	}

	public Caption(final long id, final Date createdTime, final String text, final InstagramProfile from) {
		this.id = id;
		this.createdTime = createdTime;
		this.text = text;
		this.from = from;
	}

	public long getId() {
		return id;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public String getText() {
		return text;
	}

	public InstagramProfile getFrom() {
		return from;
	}

	public void setId(final long id) {
		this.id = id;
	}

	public void setCreatedTime(final Date createdTime) {
		this.createdTime = createdTime;
	}

	public void setText(final String text) {
		this.text = text;
	}

	public void setFrom(final InstagramProfile from) {
		this.from = from;
	}

}
