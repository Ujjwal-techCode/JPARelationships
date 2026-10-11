package com.entity.relationships.service.impl;

import com.entity.relationships.dto.request.ApplicationRequestDTO;
import com.entity.relationships.dto.response.ApplicationResponseDTO;
import com.entity.relationships.entity.Applicant;
import com.entity.relationships.entity.Application;
import com.entity.relationships.entity.Resume;
import com.entity.relationships.repository.ApplicantRepository;
import com.entity.relationships.repository.ApplicationRepository;
import com.entity.relationships.repository.ResumeRepository;
import com.entity.relationships.service.ApplicationService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    ApplicationRepository applicationRepository;

    @Autowired
    ApplicantRepository applicantRepository;

    @Override
    @Transactional
    public ApplicationResponseDTO saveApplication(ApplicationRequestDTO applicationRequestDTO) {

        Application application = new Application();
        application.setPosition(applicationRequestDTO.getPosition());
        application.setStatus(applicationRequestDTO.getStatus());
        Resume resume = new Resume();
        resume.setCurrentPosition(applicationRequestDTO.getResumeRequestDTO().getCurrentPosition());
        resume.setTotalExperience(applicationRequestDTO.getResumeRequestDTO().getTotalExperience());
        Applicant applicant = new Applicant();
        applicant.setName(applicationRequestDTO.getResumeRequestDTO().getApplicantRequestDTO().getName());
        applicant.setEmail(applicationRequestDTO.getResumeRequestDTO().getApplicantRequestDTO().getEmail());
        applicant.setPhone(applicationRequestDTO.getResumeRequestDTO().getApplicantRequestDTO().getPhone());
        applicant.setStatus(applicationRequestDTO.getResumeRequestDTO().getApplicantRequestDTO().getStatus());
        resume.setApplicant(applicant);
        applicant.setResume(resume);
        Applicant savedApplicant = applicantRepository.save(applicant);
        application.setResume(savedApplicant.getResume());

        Application savedApplication = applicationRepository.save(application);

        ApplicationResponseDTO applicationResponseDTO = new ApplicationResponseDTO();
        applicationResponseDTO.setApplicationId(savedApplication.getApplicationId());
        applicationResponseDTO.setStatus(savedApplication.getStatus());
        applicationResponseDTO.setPosition(savedApplication.getPosition());
        applicationResponseDTO.setResumeId(savedApplication.getResume().getId());
        return applicationResponseDTO;

    }
}
