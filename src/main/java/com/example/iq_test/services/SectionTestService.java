package com.example.iq_test.services;

import com.example.iq_test.dto.SectionTestDto;
import com.example.iq_test.mapper.SectionTestMapper;
import com.example.iq_test.models.SectionTest;
import com.example.iq_test.repositories.SectionTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectionTestService {

    @Autowired
    private SectionTestRepository sectionTestRepository;
    @Autowired
    private SectionTestMapper sectionTestMapper;

    public List<SectionTest> findAllSections()
    {
        return sectionTestRepository.findAll();
    }

    public void findAllSectionsDto()
    {
        sectionTestRepository
                .findAll()
                .stream()
                .map(sectionTest -> SectionTestDto.builder()
                        .id(sectionTest.getId())
                        .testSectionTitle(sectionTest.getTestSectionTitle())
                        .build())
                .toList();
    }

    public List<SectionTestDto> findAllTestSectionsDto()
    {
        return  sectionTestRepository
                .findAll()
                .stream()
                .map(sectionTest -> SectionTestDto.builder()
                        .id(sectionTest.getId())
                        .testSectionTitle(sectionTest.getTestSectionTitle())
                        .build())
                .toList();
    }

    public SectionTestDto findTestSectionById(long idSection)
    {
        return sectionTestMapper.toDto(sectionTestRepository.findById(idSection).get());
    }

    public List<SectionTestDto> findTestSectionsBySearchString(String searchString)
    {
        return sectionTestRepository
                .findAllByTestSectionTitleContains(searchString)
                .stream()
                .map(sectionTest -> SectionTestDto.builder()
                        .testSectionTitle(sectionTest.getTestSectionTitle())
                        .build())
                .toList();
    }

    public SectionTestDto addTestSection(SectionTestDto sectionTestDto)
    {

        SectionTest sectionTest = sectionTestMapper.toEntity(sectionTestDto);
        sectionTestRepository.save(sectionTest);

        return SectionTestDto
                .builder()
                .id(sectionTest.getId())
                .testSectionTitle(sectionTest.getTestSectionTitle())
                .build();
    }

    public SectionTestDto updateTestSection(long id, SectionTestDto sectionTestDto)
    {
        SectionTest sectionTest = sectionTestRepository.findById(id).orElseThrow();
        sectionTest.setTestSectionTitle(sectionTestDto.getTestSectionTitle());
        sectionTestRepository.save(sectionTest);
        return sectionTestDto;
    }

    public void deleteSection(long id)
    {
        sectionTestRepository.deleteById(id);
    }
}
