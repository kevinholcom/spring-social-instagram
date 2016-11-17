package org.springframework.social.instagram.api.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.social.instagram.api.Comment;
import org.springframework.social.instagram.api.InstagramProfile;
import org.springframework.social.instagram.api.Media;
import org.springframework.social.instagram.api.MediaOperations;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * Implementation of {@link MediaOperations}, providing a binding to Instagram's media-oriented REST resources.
 */
public class MediaTemplate extends AbstractInstagramOperations implements MediaOperations {

	public MediaTemplate(InstagramTemplate instagram, boolean isAuthorizedForUser) {
		super(instagram, isAuthorizedForUser);
	}

	@Override
	public void addComment(String mediaId, String text) {
		requireUserAuthorization();
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("text", text);
		post(buildUri(MEDIA_ENDPOINT + mediaId + "/comments/"), params, Map.class);
	}

	@Override
	public void addLike(String mediaId) {
		requireUserAuthorization();
		post(buildUri(MEDIA_ENDPOINT + mediaId + "/likes/"), new LinkedMultiValueMap<String, String>(), Map.class);
	}

	@Override
	public void deleteComment(String mediaId, long commentId) {
		requireUserAuthorization();
		delete(buildUri(MEDIA_ENDPOINT + mediaId + "/comments/" + Long.toString(commentId) + "/"));
	}

	@Override
	public void deleteLike(String mediaId) {
		requireUserAuthorization();
		delete(buildUri(MEDIA_ENDPOINT + mediaId + "/likes/"));
	}

	@Override
	public List<Comment> getComments(String mediaId) {
		return get(buildUri(MEDIA_ENDPOINT + mediaId + "/comments/"), CommentList.class).getList();
	}

	@Override
	public List<InstagramProfile> getLikes(String mediaId) {
		return get(buildUri(MEDIA_ENDPOINT + mediaId + "/likes/"), InstagramProfileList.class).getList();
	}

	@Override
	public Media getMedia(String mediaId) {
		return get(buildUri(MEDIA_ENDPOINT + mediaId + "/"), MediaContainer.class).getObject();
	}

	@Override
	@Deprecated
	public List<Media> getPopular() {
		// TODO check it
		return get(buildUri(MEDIA_ENDPOINT + "search/"), MediaList.class).getList();
	}

	@Override
	public List<Media> search(double latitude, double longitude) {
		return search(latitude, longitude, 0, 0, 0);
	}

	@Override
	public List<Media> search(double latitude, double longitude, int distance) {
		return search(latitude, longitude, 0, 0, distance);
	}

	@Override
	public List<Media> search(double latitude, double longitude, long maxTimeStamp, long minTimeStamp, int distance) {
		// TODO check max_timestamp & min_timestamp, 'em not documented
		Map<String, String> params = new HashMap<String, String>();
		params.put("lat", Double.toString(latitude));
		params.put("lng", Double.toString(longitude));
		if (maxTimeStamp > 0)
			params.put("max_timestamp", Long.toString(maxTimeStamp));
		if (minTimeStamp > 0)
			params.put("min_timestamp", Long.toString(minTimeStamp));
		if (distance > 0)
			params.put("distance", Integer.toString(distance));
		return get(buildUri(MEDIA_ENDPOINT + "search/", params), MediaList.class).getList();
	}

}
