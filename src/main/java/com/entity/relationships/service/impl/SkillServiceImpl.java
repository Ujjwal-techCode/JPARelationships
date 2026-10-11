package com.entity.relationships.service.impl;

import com.entity.relationships.dto.response.SkillResponseDTO;
import com.entity.relationships.entity.Applicant;
import com.entity.relationships.entity.Application;
import com.entity.relationships.entity.Resume;
import com.entity.relationships.entity.Skill;
import com.entity.relationships.repository.ApplicantRepository;
import com.entity.relationships.repository.ApplicationRepository;
import com.entity.relationships.repository.ResumeRepository;
import com.entity.relationships.repository.SkillRepository;
import com.entity.relationships.service.SkillService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SkillServiceImpl implements SkillService {

    @Autowired
    SkillRepository skillRepository;

    @Autowired
    ApplicationRepository applicationRepository;

    @Autowired
    ResumeRepository resumeRepository;

    @Autowired
    ApplicantRepository applicantRepository;

    @Transactional
    public Skill saveSkill(Skill skill) {
        if(!skill.getApplications().isEmpty()){
            List<Application> savedApplication = new ArrayList<>();
            List<Application> applications = skill.getApplications();
            for(Application application : applications){
                Resume resume = application.getResume();
                Applicant applicant = resume.getApplicant();
                applicant = applicantRepository.save(applicant);
                resume.setApplicant(applicant);
                resume = resumeRepository.save(resume);
                application.setResume(resume);
                application = applicationRepository.save(application);
                savedApplication.add(application);
            }
            skill.setApplications(applications);
        }
        return skillRepository.save(skill);
    }

    @Override
    public SkillResponseDTO getSkillById(Integer skillId){
        Skill skill = new Skill();
        Optional<Skill> skillOptional = skillRepository.findById(skillId);
        skill = skillOptional.orElseThrow();

        SkillResponseDTO skillResponseDTO = new SkillResponseDTO();
        skillResponseDTO.setSkillId(skill.getSkillId());
        skillResponseDTO.setSkillName(skill.getSkillName());
        skillResponseDTO.setDescription(skill.getDescription());
        List<Integer> applicationIds = new ArrayList<>();
        for(Application application : skill.getApplications()){
            Integer applicationId = application.getApplicationId();
            applicationIds.add(applicationId);
        }
        skillResponseDTO.setApplicationResponseIds(applicationIds);
        return skillResponseDTO;
    }

    public Skill adjoinSkillIdAndApplicationId(Integer skillId, Integer applicationId) {
        Optional<Skill> skillOptional = skillRepository.findById(skillId);
        Optional<Application> applicationOptional = applicationRepository.findById(applicationId);
        Skill skill = skillOptional.orElseThrow();
        Application application = applicationOptional.orElseThrow();
        skill.setApplications(List.of(application));
        skillRepository.save(skill);
        return skill;
    }
}
