package com.example.iq_test.repositories;

import com.example.iq_test.models.SectionTest;
import com.example.iq_test.models.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TestRepository extends JpaRepository<Test, Long> {
    List<Test> findAllBySectionTest(SectionTest sectionTest);
    List<Test> findAllByTestNameContains(@Param("searchString") String searchString);
}
