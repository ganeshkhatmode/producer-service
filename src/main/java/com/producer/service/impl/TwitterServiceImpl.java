package com.producer.service.impl;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import com.producer.model.Twitter;
import com.producer.service.TwitterService;

@Service
public class TwitterServiceImpl implements TwitterService {

	private List<Twitter> tweets = null;
	@Autowired
	private ResourceLoader resourceLoader;

	@PostConstruct
	public void init() {
		tweets = getTweets();
	}

	public List<Twitter> getTweets() {
		Resource resource = resourceLoader.getResource("classpath:tweets.csv");
		List<Twitter> tweets = new ArrayList<>();
		try {
			Reader reader = new InputStreamReader(resource.getInputStream());
			String fileContent = FileCopyUtils.copyToString(reader);
			String[] rows = fileContent.split("\n");
			int rowCount = 0;
			for (String row : rows) {
				if (rowCount > 0) {
					String[] tweet = row.split("\\s+");
					Twitter twitter = new Twitter();
					twitter.setId(Long.parseLong(tweet[0]));
					twitter.setTweet(tweet[1]);
					twitter.setHashTag(tweet[2]);
                    List<String> geners = new ArrayList<>();
                    geners.addAll(Stream.of(tweet[3].split(",")).collect(Collectors.toList()));
					twitter.setGenres(geners);
					tweets.add(twitter);
				}
				rowCount++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return tweets;
	}

	@Override
	public Twitter findById(long id) {

		return tweets.stream().filter(t-> t.getId()==id).findFirst().get();
	}

	@Override
	public List<Twitter> findByGeners(String generName) {
		if (tweets.isEmpty()) {
			return new ArrayList<>();
		} else
			return tweets.stream()
					  .filter(t -> t.getGenres().contains(generName))
					  .collect(Collectors.toList());
	}

}
