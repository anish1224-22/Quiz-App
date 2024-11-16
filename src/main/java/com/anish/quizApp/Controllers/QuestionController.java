package com.anish.quizApp.Controllers;

import com.anish.quizApp.Model.Question;
import com.anish.quizApp.Services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;
    @GetMapping("allQuestions")
    public List<Question> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("getQuestion/{category}")
    public List<Question> getQuestionByCategory(@PathVariable String category){
        return questionService.getQuestionByCategory(category);
    }

    @PostMapping("addQuestion")
    public String addQuestion(@RequestBody Question question){
        questionService.addQuestion(question);
        return "Success";
    }

    @DeleteMapping("deleteQuestion/{id}")
    public String deleteQuestion(@PathVariable Integer id){
        return questionService.deleteQuestion(id);
    }

    @PutMapping("updateQuestion/{id}")
    public String updateQuestionByID(@PathVariable Integer id,@RequestBody Question question){
        return questionService.updateQuestion(id,question);
    }
}
