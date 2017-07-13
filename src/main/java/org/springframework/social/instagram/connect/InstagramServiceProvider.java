package org.springframework.social.instagram.connect;

import org.springframework.social.instagram.api.Instagram;
import org.springframework.social.instagram.api.impl.InstagramTemplate;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Template;

public class InstagramServiceProvider extends AbstractOAuth2ServiceProvider<Instagram> {

	private final String clientId;

	public InstagramServiceProvider(String clientId, String clientSecret) {
		super(getOAuth2Template(clientId, clientSecret));
		this.clientId = clientId;
	}
	
	private static OAuth2Template getOAuth2Template(String clientId, String clientSecret) {
		OAuth2Template oAuth2Template = new OAuth2Template(clientId, clientSecret,
				"https://api.instagram.com/oauth/authorize", "https://api.instagram.com/oauth/access_token");
		oAuth2Template.setUseParametersForClientAuthentication(true);
		return oAuth2Template;
	}

	public Instagram getApi(String accessToken) {
		return new InstagramTemplate(clientId, accessToken);
	}

}
