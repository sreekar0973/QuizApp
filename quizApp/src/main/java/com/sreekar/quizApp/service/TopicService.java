package com.sreekar.quizApp.service;

import com.sreekar.quizApp.dao.TopicDao;
import com.sreekar.quizApp.model.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {
    @Autowired
    TopicDao topicDao;
    public List<Topic> getAllTopic() {
        return topicDao.findAll();
    }

    public String addTopic(Topic topic) {
         topicDao.save(topic);
         return "success";
    }
    public List<Topic> getTopics(Integer numTopics)
    {
        List<Topic> topics = topicDao.findRandomRandomTopic(numTopics);
        return topics;
    }

    public String addManyTopics(List<Topic> topics) {
        for(Topic topic:topics)
            topicDao.save(topic);
        return "successful";
    }
}
