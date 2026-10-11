package com.entity.relationships.dto.response;

import com.entity.relationships.dto.request.ApplicationRequestDTO;
import lombok.Data;

import java.util.List;

@Data
public class SkillResponseDTO {

    private Integer skillId;
    private String skillName;
    private String description;
    private List<Integer> applicationResponseIds;
}
