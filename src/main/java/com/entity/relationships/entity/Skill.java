package com.entity.relationships.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Entity
@Data
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer skillId;
    private String skillName;
    private String description;

    @ManyToMany
    @JoinTable(name = "applications_skills",
            joinColumns = @JoinColumn(name = "skillId", referencedColumnName = "skillId"),
            inverseJoinColumns = @JoinColumn(name = "applicationId", referencedColumnName = "applicationId"))
    private List<Application> applications = new ArrayList<>();
}