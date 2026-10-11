package com.entity.relationships.dto.request;

import com.entity.relationships.entity.Resume;
import lombok.Data;

@Data
public class ApplicantRequestDTO {
    private long id;
    private String name;
    private String email;
    private String phone;
    private String status;
    private ResumeRequestDTO resumeRequestDTO;
}