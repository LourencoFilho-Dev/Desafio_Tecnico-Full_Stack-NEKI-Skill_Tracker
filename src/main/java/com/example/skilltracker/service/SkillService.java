package com.example.skilltracker.service;

import com.example.skilltracker.dtos.SkillDto;
import com.example.skilltracker.mapper.SkillMapper;
import com.example.skilltracker.model.Skill;
import com.example.skilltracker.reposiroty.SkillRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SkillService {
    private final SkillRepository skillRepository;
    private final SkillMapper skillMapper;

    @Autowired
    public SkillService(SkillRepository skillRepository, SkillMapper skillMapper) {
        this.skillRepository = skillRepository;
        this.skillMapper = skillMapper;
    }

    @Transactional
    public void deleteSkill(Long skillId) {
        skillRepository.findById(skillId)
                .orElseThrow(() -> new EntityNotFoundException("Skill não encontrada com ID: " + skillId));
        skillRepository.deleteById(skillId);
    }

    public List<SkillDto> getAllSkills() {
        return skillRepository.findAll().stream()
                .map(skillMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public SkillDto createSkill(SkillDto skillDto) {
        Skill skill = skillMapper.toEntity(skillDto);
        Skill savedSkill = skillRepository.save(skill);
        return skillMapper.toDto(savedSkill);
    }

    @Transactional
    public SkillDto updateSkill(Long skillId, SkillDto skillDto) {
        Skill existingSkill = skillRepository.findById(skillId)
                .orElseThrow(() -> new EntityNotFoundException("Skill não encontrada com ID: " + skillId));
        skillMapper.updateEntityFromDto(skillDto, existingSkill);
        Skill updatedSkill = skillRepository.save(existingSkill);
        return skillMapper.toDto(updatedSkill);
    }
}
