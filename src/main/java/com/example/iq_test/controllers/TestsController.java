package com.example.iq_test.controllers;

import com.example.iq_test.dto.SectionTestDto;
import com.example.iq_test.dto.TestDto;
import com.example.iq_test.models.SectionTest;
import com.example.iq_test.models.Test;
import com.example.iq_test.services.SectionTestService;
import com.example.iq_test.services.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@CrossOrigin
public class TestsController {

    @Autowired
    private TestService testService;
    @Autowired
    private SectionTestService sectionTestService;

    @GetMapping("/tests")
    public List<TestDto> getAllTests()
    {
        return testService.findAllTests();
    }

    @GetMapping("/test-sections/{id_section}")
    public List<TestDto> getAllTestByTestSection(@PathVariable(value = "id_section") long idSection)
    {
        return testService.findTestsByTestSection(idSection);
    }

    @PostMapping("tests/add-test")
    public TestDto addTest(@RequestBody TestDto testDto)
    {
        return testService.addTest(testDto);
    }

    @PostMapping("/test-sections/{id_section}/add")
    public String addTestTosection(@RequestBody TestDto testDto,
                                   @PathVariable(value = "id_section") long idSection)
    {
        testService.addTestToSection(testDto, idSection);
        return "test added";
    }

    @PutMapping("tests/update/{id_test}")
    public ResponseEntity updateTest(@PathVariable(value = "id_test") long id,
                                     @RequestBody TestDto testDto)
    {
        testService.updateTest(id, testDto);
        return ResponseEntity.ok("Название теста обновлено на " + testDto.getTestName());
    }

    @DeleteMapping("/tests/delete/{id_test}")
    public ResponseEntity deleteTest(@PathVariable(value = "id_test") long id)
    {
        testService.deleteTestById(id);
        return ResponseEntity.ok("Тест удалён");
    }







}
