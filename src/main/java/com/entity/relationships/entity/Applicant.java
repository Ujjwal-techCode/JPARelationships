package com.entity.relationships.entity;

import jakarta.persistence.*;
import lombok.Data;


import java.util.List;

@Entity
@Data
public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    private String phone;
    private String status;

    @OneToOne(mappedBy = "applicant", cascade = CascadeType.ALL)
    private Resume resume;

}