package org.springframework.social.instagram.api;

import java.io.Serializable;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class InstagramProfile implements Serializable {

	private long id;
	@JsonProperty("profile_picture")
	private String profilePictureUrl;
	private String username;
	private Map<String, Integer> counts;
	@JsonProperty("full_name")
	private String fullName;
	private String bio;
	private String website;
	@JsonProperty("first_name")
	private String firstName;
    @JsonProperty("last_name")
	private String lastName;

	public InstagramProfile() {

	}

	public InstagramProfile(final long id, final String username, final String fullName, final String profilePictureUrl, final Map<String, Integer> counts) {
		this.id = id;
		this.username = username;
		this.fullName = fullName;
		this.profilePictureUrl = profilePictureUrl;
		this.counts = counts;
	}

	public long getId() {
		return id;
	}

	public String getFullName() {
		return fullName;
	}

	public String getProfilePictureUrl() {
		return profilePictureUrl;
	}

	public String getUsername() {
		return username;
	}

	public Map<String, Integer> getCounts() {
		return counts;
	}

	// do not serialize, can cause NPE
	@JsonIgnore
	public int getMediaCount() {
		return counts.get("media");
	}

	// do not serialize, can cause NPE
	@JsonIgnore
	public int getFollowsCount() {
		return counts.get("follows");
	}

	// do not serialize, can cause NPE
	@JsonIgnore
	public int getFollowedBy() {
		return counts.get("followed_by");
	}

	public String getBio() {
		return bio;
	}

	public String getWebsite() {
		return website;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setBio(final String bio) {
		this.bio = bio;
	}

	public void setWebsite(final String website) {
		this.website = website;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

}
