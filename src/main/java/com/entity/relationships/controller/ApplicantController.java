package com.entity.relationships.controller;

import com.entity.relationships.dto.request.ApplicantRequestDTO;
import com.entity.relationships.dto.response.ApplicantResponseDTO;
import com.entity.relationships.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/applicant")
public class ApplicantController {

    @Autowired
    ApplicantService applicantService;

    @PostMapping("/saveApplicant")
    public ResponseEntity<ApplicantResponseDTO> saveApplicant(@RequestBody ApplicantRequestDTO applicantRequestDTO) {
        return ResponseEntity.ok(applicantService.saveApplicant(applicantRequestDTO));
    }

    @GetMapping("/getApplicant/{applicantId}")
    public ResponseEntity<ApplicantResponseDTO> getApplicant(@PathVariable Long applicantId) {
        return ResponseEntity.ok(applicantService.getApplicantById(applicantId));
    }
}
