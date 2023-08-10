package com.sreekar.quizApp.dao;

import com.sreekar.quizApp.model.Topic;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicDao extends JpaRepository<Topic,Integer> {

    @Query(value = "SELECT *FROM topic t ORDER BY RANDOM() LIMIT :numTopics" ,nativeQuery = true)
     List<Topic> findRandomRandomTopic(Integer numTopics);
}
