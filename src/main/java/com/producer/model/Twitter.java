package com.producer.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Twitter {
	private long id;
	private String tweet;
	private String hashTag;
	private List<String> genres;

	

	public Twitter() {
		super();
	}

	public Twitter(long id, String tweet, String hashTag, List<String> genres) {
		super();
		this.id = id;
		this.tweet = tweet;
		this.hashTag = hashTag;
		this.genres = genres;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTweet() {
		return tweet;
	}

	public void setTweet(String tweet) {
		this.tweet = tweet;
	}

	public String getHashTag() {
		return hashTag;
	}

	public void setHashTag(String hashTag) {
		this.hashTag = hashTag;
	}

	public List<String> getGenres() {
		return genres;
	}

	public void setGenres(List<String> genres) {
		this.genres = genres;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((genres == null) ? 0 : genres.hashCode());
		result = prime * result + ((hashTag == null) ? 0 : hashTag.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((tweet == null) ? 0 : tweet.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Twitter other = (Twitter) obj;
		if (genres == null) {
			if (other.genres != null)
				return false;
		} else if (!genres.equals(other.genres))
			return false;
		if (hashTag == null) {
			if (other.hashTag != null)
				return false;
		} else if (!hashTag.equals(other.hashTag))
			return false;
		if (id != other.id)
			return false;
		if (tweet == null) {
			if (other.tweet != null)
				return false;
		} else if (!tweet.equals(other.tweet))
			return false;
		return true;
	}

	

}
