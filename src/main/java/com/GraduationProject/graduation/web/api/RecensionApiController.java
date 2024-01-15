package com.GraduationProject.graduation.web.api;

import com.GraduationProject.graduation.dto.CreateRecensionDto;
import com.GraduationProject.graduation.dto.RecensionDto;
import com.GraduationProject.graduation.services.RecensionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/recensions")
public class RecensionApiController {
    private final RecensionService recensionService;

    public RecensionApiController(RecensionService recensionService) {
        this.recensionService = recensionService;
    }

    @PostMapping("/create-recension")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateRecensionDto createRecension(@RequestBody CreateRecensionDto createRecensionDto) {
        return this.recensionService.createRecension(createRecensionDto);
    }

    @GetMapping("/negative-decisions")
    public Long getAllNegativeDecisions(){
        return this.recensionService.getCountOfFalseDecisions();
    }
}
