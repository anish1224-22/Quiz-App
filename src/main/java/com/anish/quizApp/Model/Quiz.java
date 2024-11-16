package com.anish.quizApp.Model;

import com.anish.quizApp.Model.Question;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;

    @ManyToMany
    List<Question> questionList;
}
