package com.example.iq_test.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionTypeDto {

    @NonNull
    private long id;
    @NotEmpty
    private String typeDescription;
}
