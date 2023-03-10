package com.example.iq_test.controllers;

import com.example.iq_test.dto.QuestionDto;
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
public class QuestionController {

    @Autowired
    private QuestionService questionService;
    @Autowired
    private TestService testService;

}
