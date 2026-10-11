package com.entity.relationships.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer applicationId;
    private String status;
    private String position;

    @ManyToOne
    @JoinColumn(name = "resumeId", referencedColumnName = "id", nullable = false)
    private Resume resume;

    @ManyToMany(mappedBy = "applications")
    public List<Skill> skills = new ArrayList<>();
}
