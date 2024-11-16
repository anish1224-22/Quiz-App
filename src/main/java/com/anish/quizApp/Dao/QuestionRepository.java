package com.anish.quizApp.Dao;

import com.anish.quizApp.Model.Question;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Integer> {
    List<Question> findByCategory(String category);

    @Query(value = "Select * From question q Where q.category = :category Order By Random()", nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(@Param("category") String category, Pageable pageable);

}
