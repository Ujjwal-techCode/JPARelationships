package com.entity.relationships.service;

import com.entity.relationships.dto.request.ApplicantRequestDTO;
import com.entity.relationships.dto.response.ApplicantResponseDTO;
import com.entity.relationships.entity.Applicant;

public interface ApplicantService {

    ApplicantResponseDTO saveApplicant(ApplicantRequestDTO applicantRequestDTO);

    ApplicantResponseDTO getApplicantById(Long applicantId);
}
