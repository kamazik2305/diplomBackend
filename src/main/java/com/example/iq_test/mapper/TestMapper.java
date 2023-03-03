package com.example.iq_test.mapper;

import com.example.iq_test.dto.TestDto;
import com.example.iq_test.models.SectionTest;
import com.example.iq_test.models.Test;
import com.example.iq_test.repositories.SectionTestRepository;
import com.example.iq_test.repositories.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestMapper {

    private final TestRepository testRepository;
    private final SectionTestRepository sectionTestRepository;

    public Test toEntity(TestDto testDto)
    {
        Test test = new Test();
        test.setTestName(testDto.getTestName());
        test.setSectionTest(sectionTestRepository.findById(testDto.getIdSectionTest()).orElseThrow());
        return test;
    }

    public TestDto toDto(Test test)
    {
        return TestDto
                .builder()
                .idTest(test.getId())
                .testName(test.getTestName())
                .idSectionTest(test.getSectionTest().getId())
                .build();
    }


}
