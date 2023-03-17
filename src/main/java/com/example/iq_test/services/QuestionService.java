package com.example.iq_test.services;

import com.example.iq_test.dto.AnswerVersionDto;
import com.example.iq_test.dto.QuestionDto;
import com.example.iq_test.dto.QuestionTypeDto;
import com.example.iq_test.mapper.QuestionMapper;
import com.example.iq_test.models.*;
import com.example.iq_test.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    private TestRepository testRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private AnswerVersionRepository answerVersionRepository;
    @Autowired
    private TrueAnswerRepository trueAnswerRepository;
    @Autowired
    private QuestionTypeRepository questionTypeRepository;
    @Autowired
    private QuestionMapper questionMapper;

    public List<QuestionTypeDto> getQuestionTypes()
    {
        return  questionTypeRepository
                .findAll()
                .stream()
                .map(QuestionType -> QuestionTypeDto.builder()
                        .id(QuestionType.getId())
                        .typeDescription(QuestionType.getTypeDescription())
                        .build())
                .toList();
    }

    public List<QuestionDto> getQuestionsByTest(long idTest)
    {
        return questionRepository
                .findAllByTest(testRepository.findById(idTest))
                .stream()
                .map(question -> questionMapper.toDto(question))
                .toList();
    }



}
