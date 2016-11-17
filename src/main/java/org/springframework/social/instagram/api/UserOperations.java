package org.springframework.social.instagram.api;

import java.util.List;

/**
 * Interface defining the operations for retrieving information about Instagram
 * users and managing relationships amongst the authenticated user.
 */
public interface UserOperations {

	/**
	 * Get basic information about the authenticated user
	 * 
	 * @return Instagram profile
	 */
	InstagramProfile getUser();

	/**
	 * Get basic information about a specific user
	 * 
	 * @param userId
	 *            user's ID
	 * @return Instagram profile
	 */
	InstagramProfile getUser(long userId);

	/**
	 * Get the first page of the authenticated user's feed
	 * 
	 * @return List of media
	 * 
	 * @deprecated use getRecentMedia
	 */
	@Deprecated
	PagedMediaList getFeed();

	/**
	 * Get a range of media from the authenticated user's feed
	 * 
	 * @param maxId
	 *            Get media before this ID
	 * @param minId
	 *            Get media after this ID
	 * @return List of media
	 * 
	 * @deprecated use getRecentMedia
	 */
	@Deprecated
	PagedMediaList getFeed(String maxId, String minId);

	/**
	 * Get recent media of a current user
	 * 
	 * @return List of media
	 */
	PagedMediaList getRecentMedia();

	/**
	 * Get a range of recent media of a current user
	 * 
	 * @param maxId
	 *            Get media before this ID
	 * @param minId
	 *            Get media after this ID
	 * @return List of media
	 */
	PagedMediaList getRecentMedia(String maxId, String minId);

	/**
	 * Get recent media of a specific user
	 * 
	 * @param userId
	 *            user's ID
	 * @return List of media
	 */
	PagedMediaList getRecentMedia(long userId);

	/**
	 * Get a range of recent media of a specific user
	 * 
	 * @param userId
	 *            user's ID
	 * @param maxId
	 *            Get media before this ID
	 * @param minId
	 *            Get media after this ID
	 * @return List of media
	 */
	PagedMediaList getRecentMedia(long userId, String maxId, String minId);

	/**
	 * Search for users
	 * 
	 * @param query
	 *            query
	 * @return List of profiles
	 */
	List<InstagramProfile> search(String query);

	/**
	 * Get the list of users the specified user follows
	 * 
	 * @param userId
	 *            user's ID
	 * @return List of profiles
	 */
	List<InstagramProfile> getFollows(long userId);

	/**
	 * Get the list of users the specified user is followed by
	 * 
	 * @param userId
	 *            user's ID
	 * @return List of profiles
	 */
	List<InstagramProfile> getFollowedBy(long userId);

	/**
	 * List the users who have requested the authenticated user's permission to
	 * follow
	 * 
	 * @return List of profiles
	 */
	List<InstagramProfile> getRequestedBy();

	/**
	 * Get information about the authenticated user's relationship
	 * (follow/following/etc) to another user
	 * 
	 * @param userId
	 *            user's ID
	 * @return User relationship
	 */
	Relationship getRelationship(long userId);

	/**
	 * Send a request to follow the specified user
	 * 
	 * @param userId
	 *            user's ID
	 */
	void followUser(long userId);

	/**
	 * Stop following the specified user
	 * 
	 * @param userId
	 *            user's ID
	 */
	void unfollowUser(long userId);

	/**
	 * Block the specified user
	 * 
	 * @param userId
	 *            user's ID
	 */
	void blockUser(long userId);

	/**
	 * Unblock the specified user
	 * 
	 * @param userId
	 *            user's ID
	 */
	void unblockUser(long userId);

	/**
	 * Approve a user's request to follow the authenticated user
	 * 
	 * @param userId
	 *            user's ID
	 */
	void approveUser(long userId);

	/**
	 * Deny a user's request to follow the authenticated user
	 * 
	 * @param user
	 *            user's ID
	 */
	void denyUser(long user);

	public static final String USERS_ENDPOINT = "users/";

}
