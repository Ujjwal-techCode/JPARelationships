package com.entity.relationships.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class ResumeResponseDTO {

    private long id;
    private String currentPosition;
    private float totalExperience;
    private long applicantId;
}
