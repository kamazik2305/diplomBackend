package com.example.iq_test.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestDto {
    @NotNull
    private long idTest;
    @NotEmpty
    private String testName;
    @NotNull
    private long idSectionTest;

}
