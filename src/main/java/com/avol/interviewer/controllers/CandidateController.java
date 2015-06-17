package com.avol.interviewer.controllers;

import com.avol.interviewer.models.CandidateModel;
import com.avol.interviewer.services.ICandidateService;
import com.avol.interviewer.utils.validators.RequestValidator;
import com.avol.interviewer.dto.CandidateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/candidates")
public class CandidateController {

    @Autowired
    ICandidateService candidateService;

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public CandidateModel show(@PathVariable("id") Long id) {
        return candidateService.show(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public CandidateModel create(@Valid @RequestBody CandidateDto candidate, BindingResult result) {
        RequestValidator.validate(result);
        return candidateService.create(candidate);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.PUT)
    public CandidateModel update(@PathVariable("id") Long id, @Valid @RequestBody CandidateDto candidate, BindingResult result) {
        RequestValidator.validate(result);
        return candidateService.update(id, candidate);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
        candidateService.delete(id);
    }
}
