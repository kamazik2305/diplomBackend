package com.example.iq_test.controllers;

import com.example.iq_test.dto.SectionTestDto;
import com.example.iq_test.models.SectionTest;
import com.example.iq_test.models.Test;
import com.example.iq_test.services.SectionTestService;
import com.example.iq_test.services.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class MainController {

    @Autowired
    private SectionTestService sectionTestService;
    @Autowired
    private TestService testService;
    

    @GetMapping("/")
    public String greeting(Model model) {
        return "home/homepage";
    }

    @PostMapping("/search-result")
    public List<SectionTestDto> searchSections(@RequestParam String searchString)
    {
        return sectionTestService.findTestSectionsBySearchString(searchString);
    }

    /**
    @PostMapping("/")
    public String searchResult(@RequestParam String searchString, Model model)
    {

        List<SectionTest> sectionTests = sectionTestService.findTestSectionsBySearchString(searchString);
        model.addAttribute("sectionTests", sectionTests);

        List<Test> tests = testService.findTestsBySearchString(searchString);
        model.addAttribute("tests",tests);

        String title ="Результаты поиска:";
        model.addAttribute("searchTitle", title);
        return "home/search-result";
    }*/




}
