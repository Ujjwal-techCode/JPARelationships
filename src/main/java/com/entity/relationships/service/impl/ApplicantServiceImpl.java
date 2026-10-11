package com.entity.relationships.service.impl;

import com.entity.relationships.dto.request.ApplicantRequestDTO;
import com.entity.relationships.dto.request.ResumeRequestDTO;
import com.entity.relationships.dto.response.ApplicantResponseDTO;
import com.entity.relationships.dto.response.ResumeResponseDTO;
import com.entity.relationships.entity.Applicant;
import com.entity.relationships.entity.Resume;
import com.entity.relationships.repository.ApplicantRepository;
import com.entity.relationships.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApplicantServiceImpl implements ApplicantService {

    @Autowired
    ApplicantRepository applicantRepository;


    @Override
    public ApplicantResponseDTO saveApplicant(ApplicantRequestDTO requestDTO) {

        Applicant applicant = new Applicant();
        applicant.setName(requestDTO.getName());
        applicant.setEmail(requestDTO.getEmail());
        applicant.setPhone(requestDTO.getPhone());
        applicant.setStatus(requestDTO.getStatus());
        Resume resume = new Resume();
        resume.setCurrentPosition(requestDTO.getResumeRequestDTO().getCurrentPosition());
        resume.setTotalExperience(requestDTO.getResumeRequestDTO().getTotalExperience());
        resume.setApplicant(applicant);
        applicant.setResume(resume);

        Applicant savedApplicant = applicantRepository.save(applicant);

        ApplicantResponseDTO responseDTO = new ApplicantResponseDTO();
        responseDTO.setId(savedApplicant.getId());
        responseDTO.setName(savedApplicant.getName());
        responseDTO.setEmail(savedApplicant.getEmail());
        responseDTO.setPhone(savedApplicant.getPhone());
        responseDTO.setStatus(savedApplicant.getStatus());
        responseDTO.setResumeId(savedApplicant.getResume().getId());

        return responseDTO;
    }

    @Override
    public ApplicantResponseDTO getApplicantById(Long applicantId) {
        Optional<Applicant> applicantOptional = applicantRepository.findById(applicantId);
        ApplicantResponseDTO applicantResponseDTO = new ApplicantResponseDTO();
        if(applicantOptional.isPresent()) {
            Applicant applicant = applicantOptional.get();
            applicantResponseDTO.setId(applicant.getId());
            applicantResponseDTO.setName(applicant.getName());
            applicantResponseDTO.setEmail(applicant.getEmail());
            applicantResponseDTO.setPhone(applicant.getPhone());
            applicantResponseDTO.setStatus(applicant.getStatus());
            applicantResponseDTO.setResumeId(applicant.getResume().getId());

        }
        return applicantResponseDTO;
    }
}
