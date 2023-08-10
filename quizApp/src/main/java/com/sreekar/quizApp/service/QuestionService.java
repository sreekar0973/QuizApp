package com.sreekar.quizApp.service;


import com.sreekar.quizApp.dao.QuestionDao;
import com.sreekar.quizApp.model.Question;
import com.sreekar.quizApp.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;

    public  Question findRandomQuestionByTopic(String topicName) {
        Question question=questionDao.findRandomQuestionByCategory(topicName);
        return question;
    }

    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return  new ResponseEntity(new ArrayList <>(),HttpStatus.BAD_REQUEST);
    }

    public List<Question> getQuestionsByCategory(String category) {
        return  questionDao.findByCategory(category);
    }

    public ResponseEntity<String> addQuestion(Question question) {
        try {
            questionDao.save(question);
            return new ResponseEntity<>("success", HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity<>("success", HttpStatus.NOT_ACCEPTABLE);
    }

    public String addManyQuestions(List<Question> questions) {

        for(Question question:questions)
        questionDao.save(question);

        return "successful";
    }
    public ResponseEntity<Integer> countByCategory(String category){
        try {
            return new ResponseEntity<>(questionDao.countByCategory(category), HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity<>(0 , HttpStatus.OK);
    }
}
