package com.anish.quizApp.Services;

import com.anish.quizApp.Dao.QuestionRepository;
import com.anish.quizApp.Dao.QuizRepository;
import com.anish.quizApp.Model.Question;
import com.anish.quizApp.Model.Quiz;
import com.anish.quizApp.Model.Response;
import com.anish.quizApp.Wrapper.QuestionWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizRepository quizRepository;

    @Autowired
    QuestionRepository questionRepository;

    public ResponseEntity<Quiz> createQuiz(String category, Integer numQ, String title){
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        Pageable limit = PageRequest.of(0, numQ);
        List<Question> questionList = questionRepository.findRandomQuestionsByCategory(category, limit);
        quiz.setQuestionList(questionList);
        quizRepository.save(quiz);
        return new ResponseEntity<>(quiz, HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuiz(Integer quizId) {
        Optional<Quiz> quizOptional = quizRepository.findById(quizId);
        List<Question> questionList = quizOptional.get().getQuestionList();
        List<QuestionWrapper> questionWrappers = new ArrayList<>();
        for(Question q:questionList){
            questionWrappers.add(new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4()));
        }
        return new ResponseEntity<>(questionWrappers,HttpStatus.OK);
    }

    public ResponseEntity<Integer> getScore(Integer id, List<Response> responses) {
        Quiz quiz=quizRepository.findById(id).get();
        List<Question> questionList=quiz.getQuestionList();
        int i=0;
        int ans=0;
        for(Response response:responses){
            if(response.getResponse().equals(questionList.get(i).getRightAnswer())){
                ans++;
            }
            i++;
        }
        return new ResponseEntity<Integer>(ans,HttpStatus.OK);
    }
}
