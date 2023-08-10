package com.sreekar.quizApp.controller;

import com.sreekar.quizApp.model.Question;
import com.sreekar.quizApp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){

        return questionService.getAllQuestions();
    }


    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }

    @PostMapping("addMany")
    public String addManyQuestions(@RequestBody List<Question> questions)
    {
        return questionService.addManyQuestions(questions);
    }

    @GetMapping("category/NoOfQuestions/{category}")
    public ResponseEntity<Integer> countByCategory(@PathVariable String category)
    {
        return questionService.countByCategory(category);
    }


    //Finds a random single question from the given topic name
    public Question findRandomQuestionByTopic(String topicName) {
        return questionService.findRandomQuestionByTopic(topicName);
    }
}
