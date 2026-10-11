package com.entity.relationships.dto.request;

import com.entity.relationships.entity.Resume;
import lombok.Data;

@Data
public class ApplicationRequestDTO {

    private String status;
    private String position;
    private ResumeRequestDTO resumeRequestDTO;

}
