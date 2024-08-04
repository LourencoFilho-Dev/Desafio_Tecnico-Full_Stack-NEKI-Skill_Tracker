package com.example.skilltracker.service;

import com.example.skilltracker.reposiroty.SkillRepository;
import jakarta.transaction.Transactional;

public class SkillService {

    private final SkillRepository skillRepository;

    public SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    @Transactional
    public void deleteSkill(Long skillId) {
        skillRepository.deleteById(skillId);
    }
}
