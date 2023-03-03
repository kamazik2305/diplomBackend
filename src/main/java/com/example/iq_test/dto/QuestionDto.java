package com.example.iq_test.dto;

import com.example.iq_test.models.QuestionType;
import com.example.iq_test.models.Test;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDto {
    @NotNull
    private long idQuestion;
    @NotEmpty
    private String questionText;
    @NotNull
    private long idTest;
    @NotNull
    private long idQuestionType;
    @NotNull
    private List<AnswerVersionDto> answerVersions;
}
