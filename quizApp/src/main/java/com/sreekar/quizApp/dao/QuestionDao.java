package com.sreekar.quizApp.dao;

import com.sreekar.quizApp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> {
List<Question> findByCategory(String category);
Integer countByCategory(String category);

@Query(value = "SELECT * FROM question q where category=:topicName ORDER BY RANDOM() LIMIT 1",nativeQuery = true)
    Question findRandomQuestionByCategory(String topicName);
}
