package com.example.iq_test.controllers;

import com.example.iq_test.dto.QuestionDto;
import com.example.iq_test.dto.QuestionTypeDto;
import com.example.iq_test.models.*;
import com.example.iq_test.services.QuestionService;
import com.example.iq_test.services.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class QuestionController {

    @Autowired
    private QuestionService questionService;
    @Autowired
    private TestService testService;

    @GetMapping("/question-types")
    public List<QuestionTypeDto> getAllTypes()
    {
        return questionService.getQuestionTypes();
    }

    @GetMapping("tests/{id_test}/question-list")
    public List<QuestionDto> getQuestionsByTest(@PathVariable(value = "id_test") long idTest)
    {
        return questionService.getQuestionsByTest(idTest);
    }

}
