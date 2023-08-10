package com.sreekar.quizApp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Quiz {
    @Id
    private String Id;
    @ManyToMany
    private List<Question> questions;
}
