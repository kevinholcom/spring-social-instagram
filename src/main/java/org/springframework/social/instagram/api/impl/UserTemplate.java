package org.springframework.social.instagram.api.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.social.instagram.api.InstagramProfile;
import org.springframework.social.instagram.api.PagedMediaList;
import org.springframework.social.instagram.api.Relationship;
import org.springframework.social.instagram.api.UserOperations;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * Implementation of {@link UserOperations}, providing a binding to Instagram's
 * user-oriented REST resources.
 */
public class UserTemplate extends AbstractInstagramOperations implements UserOperations {

	public UserTemplate(InstagramTemplate instagram, boolean isAuthorizedForUser) {
		super(instagram, isAuthorizedForUser);
	}

	@Override
	public InstagramProfile getUser() {
		requireUserAuthorization();
		return get(buildUri(USERS_ENDPOINT + "self/"), InstagramProfileContainer.class).getObject();
	}

	@Override
	public InstagramProfile getUser(long userId) {
		return get(buildUri(USERS_ENDPOINT + Long.toString(userId) + "/"), InstagramProfileContainer.class).getObject();
	}

	@Override
	@Deprecated
	public PagedMediaList getFeed() {
		return getRecentMedia();
	}

	@Override
	@Deprecated
	public PagedMediaList getFeed(String maxId, String minId) {
		requireUserAuthorization();
		return getRecentMedia(maxId, minId);
	}

	@Override
	public PagedMediaList getRecentMedia() {
		return getRecentMedia(null, null);
	}

	@Override
	public PagedMediaList getRecentMedia(String maxId, String minId) {
		Map<String, String> params = new HashMap<String, String>();
		if (maxId != null)
			params.put("max_id", maxId);
		if (minId != null)
			params.put("min_id", minId);
		return get(buildUri(USERS_ENDPOINT + "self/media/recent/", params), PagedMediaList.class);
	}

	@Override
	public PagedMediaList getRecentMedia(long userId) {
		return getRecentMedia(userId, null, null);
	}

	@Override
	public PagedMediaList getRecentMedia(long userId, String maxId, String minId) {
		Map<String, String> params = new HashMap<String, String>();
		if (maxId != null)
			params.put("max_id", maxId);
		if (minId != null)
			params.put("min_id", minId);
		return get(buildUri(USERS_ENDPOINT + Long.toString(userId) + "/media/recent/", params), PagedMediaList.class);
	}

	@Override
	public List<InstagramProfile> search(String query) {
		return get(buildUri(USERS_ENDPOINT + "search/", Collections.singletonMap("q", query)),
				InstagramProfileList.class).getList();
	}

	@Override
	public List<InstagramProfile> getFollows(long userId) {
		return get(buildUri(USERS_ENDPOINT + Long.toString(userId) + "/follows/"), InstagramProfileList.class)
				.getList();
	}

	@Override
	public List<InstagramProfile> getFollowedBy(long userId) {
		return get(buildUri(USERS_ENDPOINT + Long.toString(userId) + "/followed-by/"), InstagramProfileList.class)
				.getList();
	}

	@Override
	public List<InstagramProfile> getRequestedBy() {
		requireUserAuthorization();
		return get(buildUri(USERS_ENDPOINT + "self/requested-by/"), InstagramProfileList.class).getList();
	}

	@Override
	public Relationship getRelationship(long userId) {
		requireUserAuthorization();
		return get(buildUri(USERS_ENDPOINT + Long.toString(userId) + "/relationship/"), RelationshipContainer.class)
				.getObject();
	}

	@Override
	public void followUser(long userId) {
		modifyRelationship(userId, "follow");
	}

	@Override
	public void unfollowUser(long userId) {
		modifyRelationship(userId, "unfollow");
	}

	@Override
	public void blockUser(long userId) {
		modifyRelationship(userId, "block");
	}

	@Override
	public void unblockUser(long userId) {
		modifyRelationship(userId, "unblock");
	}

	@Override
	public void approveUser(long userId) {
		modifyRelationship(userId, "approve");
	}

	@Override
	public void denyUser(long userId) {
		modifyRelationship(userId, "deny");
	}

	private void modifyRelationship(long userId, String action) {
		requireUserAuthorization();
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("action", action);
		post(buildUri(USERS_ENDPOINT + Long.toString(userId) + "/relationship/"), params, Map.class);
	}

}
