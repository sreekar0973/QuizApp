package com.sreekar.quizApp.service;
import com.sreekar.quizApp.controller.QuestionController;
import com.sreekar.quizApp.controller.TopicController;
import com.sreekar.quizApp.dao.QuizDao;
import com.sreekar.quizApp.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuizDao quizDao;

    @Autowired
    TopicController topicController;

    @Autowired
    QuestionController questionController;


    public String createQuiz(Integer numQuestions,String userName) {
        List<Topic> topics = topicController.getTopics(numQuestions);
        List<Question> questions = new ArrayList<>();
        for(Topic t : topics)
            questions.add(questionController.findRandomQuestionByTopic(t.getTopicName()));
        Quiz quiz = new Quiz();
        quiz.setId(userName);
        quiz.setQuestions(questions);
        quizDao.save(quiz);

        return "success";
    }

    public List<QuestionWrapper> getQuizQuestions(String userName) {
        Optional<Quiz> quiz = quizDao.findById(userName);

        List<Question> questionsFromDB = quiz.get().getQuestions();
        List<QuestionWrapper> questionForUsers = new ArrayList<>();

        for(Question q:questionsFromDB)
            questionForUsers.add(new QuestionWrapper(q.getQuestionId(),q.getQuestionDesc(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4()));

        return questionForUsers;

    }

    public Integer calculate(String userName, List<Response> responses) {
        Quiz quiz = quizDao.findById(userName).get(); // by using get we can get quiz pakka
        List<Question> questions = quiz.getQuestions();
        int right=0;
        int i=0;
        for(Response response:responses) {
            if (response.getResponse()!=null && response.getResponse().equals(questions.get(i).getAnswer()))
                right++;
            i++;
        }
        return right;
    }
}
