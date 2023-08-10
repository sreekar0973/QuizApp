package com.sreekar.quizApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Response {
    private Integer QuestionId;
    private String response;
}
