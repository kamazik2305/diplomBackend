package com.example.iq_test.dto;

import com.example.iq_test.models.Question;
import lombok.*;

import javax.validation.constraints.NotEmpty;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnswerVersionDto {
    @NotEmpty
    private String textAnswer;
}
