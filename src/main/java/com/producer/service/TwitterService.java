package com.producer.service;

import java.util.List;

import com.producer.model.Twitter;

public interface TwitterService {
     Twitter findById(long id);
     List<Twitter> findByGeners(String generName);
}
