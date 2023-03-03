package com.example.iq_test.services;

import com.example.iq_test.dto.TestDto;
import com.example.iq_test.mapper.TestMapper;
import com.example.iq_test.models.SectionTest;
import com.example.iq_test.models.Test;
import com.example.iq_test.repositories.SectionTestRepository;
import com.example.iq_test.repositories.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    @Autowired
    private SectionTestRepository sectionTestRepository;
    @Autowired
    private TestRepository testRepository;
    @Autowired
    private TestMapper testMapper;

    public List<TestDto> findAllTests()
    {
        return testRepository
                .findAll()
                .stream()
                .map(test -> TestDto.builder()
                        .idTest(test.getId())
                        .testName(test.getTestName())
                        .idSectionTest(test.getSectionTest().getId())
                        .build())
                .toList();
    }

    public List<TestDto> findTestBySearchString(String searchString)
    {
        return testRepository
                .findAllByTestNameContains(searchString)
                .stream()
                .map(test -> TestDto.builder()
                        .idTest(test.getId())
                        .testName(test.getTestName())
                        .idSectionTest(test.getSectionTest().getId())
                        .build())
                .toList();
    }

    public TestDto findTestById(long id)
    {
        return testMapper.toDto(testRepository.findById(id).get());
    }

    public List<TestDto> findTestsByTestSection(long idSection)
    {
        return testRepository
                .findAllBySectionTest(sectionTestRepository.findById(idSection).get())
                .stream()
                .map(test -> TestDto.builder()
                        .idTest(test.getId())
                        .testName(test.getTestName())
                        .idSectionTest(test.getSectionTest().getId())
                        .build())
                .toList();
    }


    public TestDto addTest(TestDto testDto)
    {
        Test test = testMapper.toEntity(testDto);
        testRepository.save(test);

        return  TestDto
                .builder()
                .idTest(test.getId())
                .testName(test.getTestName())
                .idSectionTest(test.getSectionTest().getId())
                .build();
    }

    public TestDto addTestToSection(TestDto testDto, long idSection)
    {
        Test test = new Test();
        test.setTestName(testDto.getTestName());
        test.setSectionTest(sectionTestRepository.findById(idSection).orElseThrow());
        testRepository.save(test);
        return testDto;
    }



    public void updateTest(long idTest, TestDto testDto)
    {
        Test test = testRepository.findById(idTest).get();
        test.setTestName(testDto.getTestName());
        testRepository.save(test);
    }

    public void deleteTestById(long idTest)
    {
        testRepository.deleteById(idTest);
    }


}
