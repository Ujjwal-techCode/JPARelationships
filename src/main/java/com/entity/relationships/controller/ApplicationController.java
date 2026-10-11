package com.entity.relationships.controller;

import com.entity.relationships.dto.request.ApplicationRequestDTO;
import com.entity.relationships.dto.response.ApplicationResponseDTO;
import com.entity.relationships.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/application")
public class ApplicationController {

    @Autowired
    ApplicationService applicationService;

    @PostMapping("/saveApplication")
    public ResponseEntity<ApplicationResponseDTO> saveApplication(@RequestBody ApplicationRequestDTO applicationRequestDTO) {
        return ResponseEntity.ok(applicationService.saveApplication(applicationRequestDTO));
    }
}
