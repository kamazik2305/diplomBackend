package com.example.iq_test.mapper;

import com.example.iq_test.dto.AnswerVersionDto;
import com.example.iq_test.dto.QuestionDto;
import com.example.iq_test.models.Question;
import com.example.iq_test.repositories.AnswerVersionRepository;
import com.example.iq_test.repositories.QuestionRepository;
import com.example.iq_test.repositories.QuestionTypeRepository;
import com.example.iq_test.repositories.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class QuestionMapper {

    private final TestRepository testRepository;
    private final QuestionRepository questionRepository;
    private final QuestionTypeRepository questionTypeRepository;

    public Question toEntity(QuestionDto questionDto)
    {
        Question question = new Question();
        question.setQuestionText(questionDto.getQuestionText());
        question.setTest(testRepository.findById(questionDto.getIdQuestion()).get());
        question.setQuestionType(questionTypeRepository.findById(questionDto.getIdQuestionType()).get());
        return question;
    }

    public QuestionDto toDto(Question question)
    {
        return QuestionDto
                .builder()
                .idQuestion(question.getId())
                .idTest(question.getTest().getId())
                .idQuestionType(question.getQuestionType().getId())
                .questionText(question.getQuestionText())
                .answerVersions(question.getAnswerVersions()
                        .stream()
                        .map(answerVersion -> AnswerVersionDto.builder()
                                .textAnswer(answerVersion.getTextAnswer())
                                .build())
                        .toList())
                .build();
    }
}
