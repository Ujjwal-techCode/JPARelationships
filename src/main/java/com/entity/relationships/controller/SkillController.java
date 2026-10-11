package com.entity.relationships.controller;

import com.entity.relationships.dto.response.SkillResponseDTO;
import com.entity.relationships.entity.Skill;

import com.entity.relationships.repository.SkillRepository;
import com.entity.relationships.service.SkillService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/skills")
public class SkillController {

    @Autowired
    SkillService skillService;

    @PostMapping("/skill")
    public ResponseEntity<Skill> saveSkills(@RequestBody Skill skill) {
        return ResponseEntity.ok(skillService.saveSkill(skill));
    }

    @GetMapping("/{skillId}")
    public ResponseEntity<SkillResponseDTO> getSkillsById(@PathVariable("skillId") Integer skillId){
        return ResponseEntity.ok(skillService.getSkillById(skillId));
    }

    @PostMapping("/skillToApplication")
    public Skill addSkillToApplication(@PathParam("skillId") Integer skillId, @PathParam("applicationId") Integer applicationId){
        Skill skill = skillService.adjoinSkillIdAndApplicationId(skillId, applicationId);
        return null;
    }
}
