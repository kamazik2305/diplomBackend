package com.example.iq_test.dto;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestResultDto {
    @NonNull
    private UserDto user;
    @NonNull
    private TestDto test;
    @NonNull
    private int points;
}
