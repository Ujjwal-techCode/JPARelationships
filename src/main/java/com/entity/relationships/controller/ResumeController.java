package com.entity.relationships.controller;

import com.entity.relationships.service.ResumeService;
import com.entity.relationships.entity.Resume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/resume")
public class ResumeController {

    @Autowired
    ResumeService resumeService;

    @PostMapping("/{applicantId}/Resume")
    public ResponseEntity<Resume> addResume(@PathVariable Long applicantId, @RequestBody Resume resume) {
        return ResponseEntity.ok(resumeService.addResume(applicantId, resume));
    }

    @GetMapping("/{resumeId}")
    public ResponseEntity<Resume> getSpecificResume(@PathVariable long resumeId){
        return ResponseEntity.ok(resumeService.getSpecificResume(resumeId));
    }
}
