package org.springframework.social.instagram.api;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Media implements Serializable {

	public static final String VIDEO = "video";
	public static final String IMAGE = "image";

	private String id;
	private String filter;
	private String link;
	private Caption caption;
	private InstagramProfile user;
	private Location location;
	@JsonProperty("created_time")
	private Date createdTime;
	private boolean userHasLiked;
	private Map<String, Image> images;
	private Map<String, Video> videos;
	private List<String> tags;
	private String type;
	private LikesInfo likes;
	private CommentsInfo comments;

	public Media() {
		super();
	}

	public Media(final String id,
			final String filter,
			final String link,
			final Caption caption,
			final InstagramProfile user,
			final Location location,
			final Date createdTime,
			final boolean userHasLiked,
			final Map<String, Image> images,
			final Map<String, Video> videos,
			final List<String> tags,
			final LikesInfo likes,
			final CommentsInfo comments) {

		this.id = id;
		this.filter = filter;
		this.link = link;
		this.caption = caption;
		this.user = user;
		this.location = location;
		this.createdTime = createdTime;
		this.userHasLiked = userHasLiked;
		this.images = images;
		this.videos = videos;
		this.tags = tags;
		this.likes = likes;
		this.comments = comments;
	}

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public String getFilter() {
		return filter;
	}

	public void setFilter(final String filter) {
		this.filter = filter;
	}

	public String getLink() {
		return link;
	}

	public void setLink(final String link) {
		this.link = link;
	}

	public Caption getCaption() {
		return caption;
	}

	public void setCaption(final Caption caption) {
		this.caption = caption;
	}

	public InstagramProfile getUser() {
		return user;
	}

	public void setUser(final InstagramProfile user) {
		this.user = user;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(final Location location) {
		this.location = location;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(final Date createdTime) {
		this.createdTime = createdTime;
	}

	public boolean isUserHasLiked() {
		return userHasLiked;
	}

	public void setUserHasLiked(final boolean userHasLiked) {
		this.userHasLiked = userHasLiked;
	}

	public Map<String, Image> getImages() {
		return images;
	}

	public void setImages(final Map<String, Image> images) {
		this.images = images;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(final List<String> tags) {
		this.tags = tags;
	}

	public LikesInfo getLikes() {
		return likes;
	}

	public void setLikes(final LikesInfo likes) {
		this.likes = likes;
	}

	public CommentsInfo getComments() {
		return comments;
	}

	public void setComments(final CommentsInfo comments) {
		this.comments = comments;
	}

	public Map<String, Video> getVideos() {
		return videos;
	}

	public void setVideos(final Map<String, Video> videos) {
		this.videos = videos;
	}

	public String getType() {
		return type;
	}

	public void setType(final String type) {
		this.type = type;
	}

}
