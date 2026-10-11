package com.entity.relationships.service;

import com.entity.relationships.entity.Resume;

public interface ResumeService {

    Resume addResume(long applicantId, Resume resume);

    Resume getSpecificResume(long resumeId);
}
