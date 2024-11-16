package com.anish.quizApp.Controllers;

import com.anish.quizApp.Model.Quiz;
import com.anish.quizApp.Model.Response;
import com.anish.quizApp.Services.QuizService;
import com.anish.quizApp.Wrapper.QuestionWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;


    @PostMapping("createQuiz")
    public ResponseEntity<Quiz> createQuiz(@RequestParam String category, @RequestParam Integer numQ, @RequestParam String title){
        return quizService.createQuiz(category,numQ,title);
    }

    @GetMapping("getQuiz/{quizId}")
    public ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable Integer quizId){
        return quizService.getQuiz(quizId);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> getScore(@PathVariable Integer id, @RequestBody List<Response> responses){
        return quizService.getScore(id,responses);
    }
}
