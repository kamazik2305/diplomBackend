package com.example.iq_test.controllers;

import com.example.iq_test.dto.SectionTestDto;
import com.example.iq_test.models.SectionTest;
import com.example.iq_test.services.SectionTestService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class SectionTestsController {

    @Autowired
    private SectionTestService sectionTestService;


    @GetMapping("/test-sections")
    public List<SectionTestDto> getAllTestSections()
    {
        return sectionTestService.findAllTestSectionsDto();
    }


    @PostMapping("/test-sections/add")
    public SectionTestDto addSectionTest(@RequestBody SectionTestDto sectionTestDto) {
        return sectionTestService.addTestSection(sectionTestDto);
    }

    @PutMapping("/test-sections/update/{id_section}")
    public SectionTestDto updateSectionTest(@PathVariable(value = "id_section") long idSection,
                                            @RequestBody SectionTestDto sectionTestDto)
    {
        return sectionTestService.updateTestSection(idSection, sectionTestDto);
    }

    @DeleteMapping("/test-sections/delete/{id_section}")
    public ResponseEntity deleteSectionTest(@PathVariable(value = "id_section") long idSection)
    {
        sectionTestService.deleteSection(idSection);
        return ResponseEntity.ok("section deleted");
    }

}

