package com.example.iq_test.repositories;

import com.example.iq_test.models.QuestionType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionTypeRepository extends JpaRepository<QuestionType, Long> {
    QuestionType findByTypeDescription(String typeDescription);
}
