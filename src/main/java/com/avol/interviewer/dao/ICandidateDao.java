package com.avol.interviewer.dao;

import com.avol.interviewer.models.CandidateModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Durga.
 *
 * Spring Data JPA repositories are interfaces that you can define to access data.
 * JPA queries are created automatically from your method names
 *
 * SimpleJpaRepository has the implementations for CRUD operations.
 */
public interface ICandidateDao extends JpaRepository<CandidateModel, Long> {

}
