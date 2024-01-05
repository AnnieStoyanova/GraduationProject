package com.GraduationProject.graduation.web.api;

import com.GraduationProject.graduation.services.ThesisService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/theses")
public class ThesisApiController {

    private final ThesisService thesisService;


    public ThesisApiController(ThesisService thesisService) {
        this.thesisService = thesisService;
    }


}
