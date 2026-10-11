package com.entity.relationships.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Entity
@Data
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String currentPosition;
    private float totalExperience;

    //private List<Skill> skills;

    @OneToOne
    @JoinColumn(name ="applicant_id", referencedColumnName = "id", nullable = false)
    private Applicant applicant;

    @OneToMany(mappedBy = "resume", cascade = CascadeType.ALL)
    private List<Application> applications;
}
