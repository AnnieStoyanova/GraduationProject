package com.GraduationProject.graduation.web.api;

import com.GraduationProject.graduation.dto.CreateThesisDto;
import com.GraduationProject.graduation.dto.ThesisDto;
import com.GraduationProject.graduation.exceptions.TeacherNotFoundException;
import com.GraduationProject.graduation.exceptions.ThesisNotFoundException;
import com.GraduationProject.graduation.services.ThesisService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
    @ResponseStatus(HttpStatus.CREATED)
    public CreateThesisDto createThesis(@RequestBody CreateThesisDto createThesisDto) {
        return this.thesisService.createThesis(createThesisDto);
    }

    @GetMapping("/{id}")
    public ThesisDto getThesisById(@PathVariable long id) {
        try {
            return this.thesisService.getThesisById(id);
        } catch (ThesisNotFoundException ex) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Thesis Not Found", ex);
        }
    }
}
