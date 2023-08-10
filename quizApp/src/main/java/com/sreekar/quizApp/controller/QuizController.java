package com.sreekar.quizApp.controller;

import com.sreekar.quizApp.model.Question;
import com.sreekar.quizApp.model.QuestionWrapper;
import com.sreekar.quizApp.model.Response;
import com.sreekar.quizApp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    QuizService quizService;
    @PostMapping("create")
    public String createQuiz(@RequestParam String userName)
    {

        return quizService.createQuiz(15,userName);
    }
    @GetMapping("get")
    public List<QuestionWrapper> getQuizQuestions(@RequestParam String userName)
    {

        return quizService.getQuizQuestions(userName);
    }
    @GetMapping("submit")
    public Integer submitQuiz(@RequestParam  String userName,@RequestBody List<Response> responses)
    {
        return quizService.calculate(userName,responses);
    }


}
