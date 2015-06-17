package com.avol.interviewer.services;

import com.avol.interviewer.models.CandidateModel;
import com.avol.interviewer.dto.CandidateDto;

import java.util.List;

public interface ICandidateService {
    CandidateModel create(CandidateDto candidate);
    CandidateModel show(Long id);
    CandidateModel update(Long id, CandidateDto candidate);
    void delete(Long id);

    List<CandidateModel> findAll();
}
