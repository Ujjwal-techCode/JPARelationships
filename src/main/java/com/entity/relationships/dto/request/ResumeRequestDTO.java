package com.entity.relationships.dto.request;

import lombok.Data;

@Data
public class ResumeRequestDTO {

    private String currentPosition;
    private float totalExperience;
    private ApplicantRequestDTO applicantRequestDTO;

}