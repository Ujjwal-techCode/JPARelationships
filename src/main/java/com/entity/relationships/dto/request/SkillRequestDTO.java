package com.entity.relationships.dto.request;

import com.entity.relationships.entity.Application;
import lombok.Data;

import java.util.List;

@Data
public class SkillRequestDTO {

    private Integer skillId;
    private String skillName;
    private String description;
    List<ApplicationRequestDTO> applicationsRequestDTO;
}
