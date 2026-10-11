package com.entity.relationships.service.impl;

import com.entity.relationships.entity.Applicant;
import com.entity.relationships.entity.Resume;
import com.entity.relationships.repository.ApplicantRepository;
import com.entity.relationships.repository.ResumeRepository;
import com.entity.relationships.service.ResumeService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResumeServiceImpl implements ResumeService {

    @Autowired
    ApplicantRepository applicantRepository;

    @Autowired
    ResumeRepository resumeRepository;

    @Override
    @Transactional
    public Resume addResume(long applicantId, Resume resume){
        Optional<Applicant> applicantOptional = applicantRepository.findById(applicantId);
        var applicant = applicantOptional.orElseThrow();
        resume.setApplicant(applicant);
        return resumeRepository.save(resume);
    }

    @Override
    public Resume getSpecificResume(long resumeId){
        return resumeRepository.findById(resumeId).orElseThrow();
    }
}
