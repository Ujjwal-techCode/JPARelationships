package com.entity.relationships.service;

import com.entity.relationships.dto.request.ApplicationRequestDTO;
import com.entity.relationships.dto.response.ApplicationResponseDTO;

public interface ApplicationService {

    ApplicationResponseDTO saveApplication(ApplicationRequestDTO applicationRequestDTO);
}
