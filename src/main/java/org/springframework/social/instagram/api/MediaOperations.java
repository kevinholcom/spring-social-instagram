package org.springframework.social.instagram.api;

import java.util.List;

public interface MediaOperations {

	/**
	 * Create a comment on a media.
	 * 
	 * @param mediaId media ID
	 * @param text text
	 */
	void addComment(String mediaId, String text);

	/**
	 * Set a like on this media by the currently authenticated user.
	 * 
	 * @param mediaId media ID
	 */
	void addLike(String mediaId);

	/**
	 * Remove a comment either on the authenticated user's media or authored by the authenticated user.
	 * 
	 * @param mediaId media ID
	 * @param commentId comment ID
	 */
	void deleteComment(String mediaId, long commentId);

	/**
	 * Remove a like on this media by the currently authenticated user.
	 * 
	 * @param mediaId media ID
	 */
	void deleteLike(String mediaId);

	/**
	 * Get a full list of comments on a media.
	 * 
	 * @param mediaId media ID
	 * @return A list of comments
	 */
	List<Comment> getComments(String mediaId);

	/**
	 * Get a list of users who have liked this media.
	 * 
	 * @param mediaId media ID
	 * @return A list of users
	 */
	List<InstagramProfile> getLikes(String mediaId);

	/**
	 * Get information about a media object.
	 * 
	 * @param mediaId media ID
	 * @return Media information
	 */
	Media getMedia(String mediaId);

	/**
	 * Get a list of what media is most popular at the moment.
	 * 
	 * @return A list of media
	 * @deprecated instagram has no such API
	 */
	@Deprecated
	List<Media> getPopular();

	/**
	 * Search for media in a given area.
	 * 
	 * @param latitude latitude
	 * @param longitude longitude
	 * @return A list of media
	 */
	List<Media> search(double latitude, double longitude);

	/**
	 * Search for media in a given area.
	 * 
	 * @param latitude latitude
	 * @param longitude longitude
	 * @param distance distance
	 * @return A list of media
	 */
	List<Media> search(double latitude, double longitude, int distance);

	/**
	 * Search for media in a given area.
	 * 
	 * @param latitude latitude
	 * @param longitude longitude
	 * @param maxTimeStamp maxTimeStamp
	 * @param minTimeStamp minTimeStamp
	 * @param distance distance
	 * @return A list of media
	 */
	List<Media> search(double latitude, double longitude, long maxTimeStamp, long minTimeStamp, int distance);

	public static final String MEDIA_ENDPOINT = "media/";
}
