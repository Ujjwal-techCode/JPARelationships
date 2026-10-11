package com.entity.relationships.dto.response;

import com.entity.relationships.entity.Resume;
import lombok.Data;

@Data
public class ApplicationResponseDTO {
    private int applicationId;
    private String status;
    private String position;
    private Long resumeId;
}
