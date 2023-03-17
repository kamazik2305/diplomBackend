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

    public List<SectionTestDto> findAllTestSectionsDto()
    {
        return  sectionTestRepository
                .findAll()
                .stream()
                .map(sectionTest -> sectionTestMapper.toDto(sectionTest))
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
                .map(sectionTest -> sectionTestMapper.toDto(sectionTest))
                .toList();
    }

    public SectionTestDto addTestSection(SectionTestDto sectionTestDto)
    {

        if(sectionTestRepository.existsByTestSectionTitle(sectionTestDto.getTestSectionTitle()))
        {
            throw new RuntimeException("Раздел с таким именем уже есть");
        }
        SectionTest sectionTest = sectionTestMapper.toEntity(sectionTestDto);
        sectionTestRepository.save(sectionTest);

        return sectionTestMapper.toDto(sectionTest);
    }

    public SectionTestDto updateTestSection(long id, SectionTestDto sectionTestDto)
    {
        if(sectionTestRepository.existsByTestSectionTitle(sectionTestDto.getTestSectionTitle()))
        {
            throw new RuntimeException("Раздел с таким именем уже есть");
        }
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
