package com.sreekar.quizApp.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Question{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer questionId;
    private String questionDesc;
    private String category;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String answer;
    private String difficultyLevel;
}
