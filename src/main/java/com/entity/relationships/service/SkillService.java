package com.entity.relationships.service;

import com.entity.relationships.dto.response.SkillResponseDTO;
import com.entity.relationships.entity.Skill;

public interface SkillService {

    Skill saveSkill(Skill skill);

    SkillResponseDTO getSkillById(Integer skillId);

    Skill adjoinSkillIdAndApplicationId(Integer skillId, Integer applicationId);
}
