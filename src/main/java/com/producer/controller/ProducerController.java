package com.producer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.producer.model.Twitter;
import com.producer.service.TwitterService;
import com.producer.service.impl.Producer;


@RestController
@RequestMapping("/api/v1")
public class ProducerController {

	@Autowired
	private Producer producer;
	
	@Autowired
	private TwitterService twitterService;
	
	@PostMapping("/gener/{gener}")
	public List<Twitter> findTweetByGener(@PathVariable String gener) throws JsonProcessingException {
		System.out.println("Tweets gener :: "+gener);
		List<Twitter> tweetes =  twitterService.findByGeners(gener);
		producer.sendMessage(tweetes);
		return tweetes;
	}
}
