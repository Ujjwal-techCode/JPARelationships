package com.entity.relationships.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class ApplicantResponseDTO {
    private long id;
    private String name;
    private String email;
    private String phone;
    private String status;
    private Long resumeId;
}
