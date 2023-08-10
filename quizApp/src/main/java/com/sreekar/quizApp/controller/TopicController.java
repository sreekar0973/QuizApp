package com.sreekar.quizApp.controller;

import com.sreekar.quizApp.model.Topic;
import com.sreekar.quizApp.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("topic")
public class TopicController {
    @Autowired
    TopicService topicService;
    @GetMapping("allTopics")
    public List<Topic> getAllTopics()
    {
        return topicService.getAllTopic();
    }
    @PostMapping("add")
    public String addTopic(@RequestBody Topic topic)
    {

        return topicService.addTopic(topic);
    }
    @PostMapping("addMany")
    public String addManyTopics(@RequestBody List<Topic> topics)
    {
        return topicService.addManyTopics(topics);
    }
    public List<Topic> getTopics(Integer numTopics)
    {
        return topicService.getTopics(numTopics);
    }
}
