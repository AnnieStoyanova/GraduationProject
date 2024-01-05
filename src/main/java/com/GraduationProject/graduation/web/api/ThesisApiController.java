package com.GraduationProject.graduation.web.api;

import com.GraduationProject.graduation.dto.CreateThesisDto;
import com.GraduationProject.graduation.dto.ThesisDto;
import com.GraduationProject.graduation.services.ThesisService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/theses")
public class ThesisApiController {

    private final ThesisService thesisService;


    public ThesisApiController(ThesisService thesisService) {
        this.thesisService = thesisService;
    }


    @GetMapping
    List<ThesisDto> getTheses() {
        return thesisService.getTheses();
    }

    @PostMapping("/create-thesis")
    public CreateThesisDto createThesis(@RequestBody CreateThesisDto createThesisDto) {
        return this.thesisService.createThesis(createThesisDto);
    }

    @GetMapping("/{id}")
    public ThesisDto getThesisById(@PathVariable long id) {
        return this.thesisService.getThesisById(id);
    }
}
