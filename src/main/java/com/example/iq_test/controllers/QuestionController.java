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

    private List<QuestionDto> questions;
    private int index;
    private int points;


    @GetMapping("/tests/{id_test}")
    public QuestionDto getFirstQuestion(@PathVariable(value = "id_test") long Id_test)
    {
        index = 0;
        points = 0;
        questions = questionService.findQuestionsByTest(Id_test);
        return questions.get(index);
    }

    @PostMapping("/tests/{id_test}")
    public QuestionDto getNextQuestion(@RequestParam(required = false) Long buttonAnswer,
                               @RequestParam(required = false) String inputAnswer,
                               @RequestParam(required = false) String[] checkBoxAnswer, Model model)
    {

        switch ((int)questions.get(index).getIdQuestionType())
        {
            case 1: if (questionService.checkQuestionType1(buttonAnswer) != null)
                points++; break;
            case 2: if (questionService.checkQuestionType2(inputAnswer, questions.get(index))  != null)
                points++; break;
            case 3: if (questionService.checkQuestionType3(checkBoxAnswer, questions.get(index)))
                points++; break;
        }
        index++;
        return questions.get(index);
        /**
        if(index < questions.size())
        {
            return questions.get(index);
        }
        /**
        else
        {
            float maxPoints = questions.size();
            float result = points/maxPoints*100;
            model.addAttribute("result", String.format("%.0f", result));
            return "test/test-end";
        }*/

    }

    @GetMapping("/tests/{id_test}/question-list")
    public List<QuestionDto> getListForAdmin(@PathVariable(value = "id_test") long id_test)
    {
        return questionService.findQuestionsByTest(id_test);
    }

    /**
    @GetMapping("/tests/{id_test}/question-list/add-question")
    public String addGetQuestion(@PathVariable(value = "id_test") long id_test, Model model)
    {
        Test test = testService.findTestById(id_test);
        Iterable<QuestionType> questionTypes = questionService.findAllQuestionTypes();
        model.addAttribute("test", test);
        model.addAttribute("questionTypes", questionTypes);
        return "question/question-add";
    }*/


    /**
    @PostMapping("/tests/{id_test}/question-list/add-question")
    public String addQuestion(@PathVariable(value = "id_test") long id_test,
                              @RequestParam(required = false) int selectType,
                              @RequestParam String questionText,
                              @RequestParam String[] inputAnswer,
                              @RequestParam(required = false) String buttonTrueAnswer,
                              @RequestParam(required = false) String[] inputTrueAnswer)
    {
        Question question = questionService.addNewQuestion(id_test, selectType, questionText);
        questionService.saveQuestion(question);
        questionService.setAnswersToQuestion(inputAnswer, question);
        switch ((int)question.getQuestionType().getId()) {
            case 1 -> questionService.addTrueAnswerType1(buttonTrueAnswer, question);
            case 2 -> questionService.addTrueAnswerType23(inputAnswer, question);
            case 3 -> questionService.addTrueAnswerType23(inputTrueAnswer, question);
        }
        return "redirect:/tests/{id_test}/question-list";
    }*/


    /**
    @GetMapping("/tests/{id_test}/{id_question}/edit")
    public String getEditQuestion (@PathVariable(value = "id_question") long idQuestion,
                                Model model)
    {
        Question question = questionService.findQuestionById(idQuestion);
        model.addAttribute("question", question);

        Iterable<QuestionType> questionTypes = questionService.findAllQuestionTypes();
        model.addAttribute("questionTypes", questionTypes);

        ArrayList<AnswerVersion> answerVersions = questionService.findAnswerVersions(question);
        model.addAttribute("answerVersions", answerVersions);

        return "question/question-edit";
    }

    @PostMapping("/tests/{id_test}/{id_question}/edit")
    public  String editQuestion()
    {
        return "redirect:/tests/{id_test}/question-list";
    }

    @PostMapping("/tests/{id_test}/{id_question}/remove")
    public String removeQuestion(@PathVariable(value = "id_question") long id_question)
    {
        questionService.deleteQuestionById(id_question);
        return "redirect:/tests/{id_test}/question-list";
    }*/

}
