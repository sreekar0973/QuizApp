package com.sreekar.quizApp.model;

import lombok.Data;


@Data
public class QuestionWrapper {
    private Integer questionId;
    private String questionDesc;
    private String option1;
    private String option2;
    private String option3;
    private String option4;

    public QuestionWrapper(Integer questionId, String questionDesc, String option1, String option2, String option3, String option4) {
        this.questionId = questionId;
        this.questionDesc = questionDesc;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
    }
}
