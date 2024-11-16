package com.anish.quizApp.Services;

import com.anish.quizApp.Dao.QuestionRepository;
import com.anish.quizApp.Model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public List<Question> getQuestionByCategory(String category) {
        return questionRepository.findByCategory(category);
    }

    public String addQuestion(Question question) {
        questionRepository.save(question);
        return "Success";
    }

    public String deleteQuestion(Integer id) {
        questionRepository.deleteById(id);
        return "Success";
    }

    public String updateQuestion(Integer id, Question question) {
        Question olderQuestion=questionRepository.findById(id).orElseThrow(()->new RuntimeException("Not Found"));
        olderQuestion = question;
        questionRepository.deleteById(id);
        questionRepository.save(olderQuestion);
        return "Success";
    }
}
