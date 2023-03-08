package com.example.iq_test.repositories;

import com.example.iq_test.models.SectionTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SectionTestRepository extends JpaRepository<SectionTest, Long> {
    List<SectionTest> findAllByTestSectionTitleContains(@Param("searchString") String searchString);
    SectionTest findByid(long id);
    boolean existsByTestSectionTitle(String testSectionTitle);
}
