package com.avol.interviewer.services;

import com.avol.interviewer.models.CandidateModel;
import com.avol.interviewer.dao.ICandidateDao;
import com.avol.interviewer.dto.CandidateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CandidateService implements ICandidateService{

    @Autowired
    ICandidateDao candidateDao;

    @Override
    public CandidateModel create(CandidateDto candidate) {
        CandidateModel candidateModel = new CandidateModel(candidate.getFirstName(), candidate.getLastName(), candidate.getEmail(), candidate.getPhone());
        return candidateDao.save(candidateModel);
    }

    @Override
    public CandidateModel show(Long id) {
        return candidateDao.findOne(id);
    }

    @Override
    public CandidateModel update(Long id, CandidateDto candidate) {
        CandidateModel cm = candidateDao.findOne(id);
        return candidateDao.save(cm);
    }

    @Override
    public void delete(Long id) {
        candidateDao.delete(id);
    }

    @Override
    public List<CandidateModel> findAll() {
        return candidateDao.findAll();
    }

}
