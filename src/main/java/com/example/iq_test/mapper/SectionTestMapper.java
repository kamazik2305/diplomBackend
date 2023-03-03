package com.example.iq_test.mapper;

import com.example.iq_test.dto.SectionTestDto;
import com.example.iq_test.models.SectionTest;
import com.example.iq_test.repositories.SectionTestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SectionTestMapper {

    private final SectionTestRepository sectionTestRepository;

    public SectionTest toEntity(SectionTestDto sectionTestDto)
    {
        SectionTest sectionTest = new SectionTest();
        sectionTest.setTestSectionTitle(sectionTestDto.getTestSectionTitle());
        return sectionTest;
    }

    public SectionTestDto toDto(SectionTest sectionTest)
    {
        return SectionTestDto
                .builder()
                .id(sectionTest.getId())
                .testSectionTitle(sectionTest.getTestSectionTitle())
                .build();
    }

}
