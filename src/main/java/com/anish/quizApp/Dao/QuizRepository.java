package com.anish.quizApp.Dao;

import com.anish.quizApp.Model.Question;
import com.anish.quizApp.Model.Quiz;
import com.anish.quizApp.Model.Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepository extends JpaRepository<Quiz,Integer> {
}
