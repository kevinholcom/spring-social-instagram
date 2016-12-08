package org.springframework.social.instagram.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Pagination implements Serializable {

    @JsonProperty("next_url")
	private String nextUrl;
    @JsonProperty("next_max_id")    
	private String nextMaxId;
    @JsonProperty("next_min_id")
	private String nextMinId;

	public Pagination() {   
	}
	
	public Pagination(String nextUrl, String nextMaxId, String nextMinId) {
		this.nextUrl = nextUrl;
		this.nextMaxId = nextMaxId;
		this.nextMinId = nextMinId;
	}

	public String getNextUrl() {
		return nextUrl;
	}

	public String getNextMaxId() {
		return nextMaxId;
	}

	public String getNextMinId() {
		return nextMinId;
	}

    public void setNextUrl(String nextUrl) {
        this.nextUrl = nextUrl;
    }

    public void setNextMaxId(String nextMaxId) {
        this.nextMaxId = nextMaxId;
    }

    public void setNextMinId(String nextMinId) {
        this.nextMinId = nextMinId;
    }

}
