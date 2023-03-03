package com.example.iq_test.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SectionTestDto {
    @NotNull
    private long id;
    @NotEmpty
    private String testSectionTitle;
}
