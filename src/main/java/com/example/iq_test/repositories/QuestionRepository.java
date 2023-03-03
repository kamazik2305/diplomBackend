package com.example.iq_test.repositories;

import com.example.iq_test.models.Question;
import com.example.iq_test.models.QuestionType;
import com.example.iq_test.models.Test;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    Question findByid(long id);
    ArrayList<Question> findAllByTest(Optional<Test> test);
    ArrayList<Question> findByQuestionType(Optional<QuestionType> questionType);
}
