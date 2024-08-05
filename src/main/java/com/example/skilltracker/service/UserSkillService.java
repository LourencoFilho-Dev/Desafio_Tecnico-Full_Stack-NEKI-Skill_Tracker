package com.example.skilltracker.service;

import com.example.skilltracker.dtos.UserSkillDto;
import com.example.skilltracker.mapper.UserSkillMapper;
import com.example.skilltracker.model.Skill;
import com.example.skilltracker.model.User;
import com.example.skilltracker.model.UserSkill;
import com.example.skilltracker.reposiroty.SkillRepository;
import com.example.skilltracker.reposiroty.UserRepository;
import com.example.skilltracker.reposiroty.UserSkillRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserSkillService {

    private final UserSkillRepository userSkillRepository;
    private final UserRepository userRepository;
    private final SkillRepository skillRepository;
    private final UserSkillMapper userSkillMapper;

    @Autowired
    public UserSkillService(UserSkillRepository userSkillRepository, UserRepository userRepository,
                            SkillRepository skillRepository, UserSkillMapper userSkillMapper) {
        this.userSkillRepository = userSkillRepository;
        this.userRepository = userRepository;
        this.skillRepository = skillRepository;
        this.userSkillMapper = userSkillMapper;
    }

    public List<UserSkillDto> getUserSkills(Long userId) {
        List<UserSkill> userSkills = userSkillRepository.findByUserId(userId);
        return userSkills.stream()
                .map(userSkillMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public UserSkillDto createUserSkill(Long userId, UserSkillDto userSkillDto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com ID: " + userId));
        Skill skill = skillRepository.findById(userSkillDto.getSkillId())
                .orElseThrow(() -> new EntityNotFoundException("Skill não encontrada com ID: " + userSkillDto.getSkillId()));

        UserSkill userSkill = userSkillMapper.toEntity(userSkillDto);
        userSkill.setUser(user);
        userSkill.setSkill(skill);

        UserSkill savedUserSkill = userSkillRepository.save(userSkill);
        return userSkillMapper.toDto(savedUserSkill);
    }

    @Transactional
    public UserSkillDto updateUserSkill(Long userSkillId, UserSkillDto userSkillDto) {
        UserSkill userSkill = userSkillRepository.findById(userSkillId)
                .orElseThrow(() -> new EntityNotFoundException("Associação usuário-skill não encontrada com ID: " + userSkillId));

        userSkillMapper.updateEntityFromDto(userSkillDto, userSkill);

        UserSkill updatedUserSkill = userSkillRepository.save(userSkill);
        return userSkillMapper.toDto(updatedUserSkill);
    }

    @Transactional
    public void deleteUserSkill(Long userSkillId) {
        userSkillRepository.findById(userSkillId)
                .orElseThrow(() -> new EntityNotFoundException("Associação usuário-skill não encontrada com ID: " + userSkillId));
        userSkillRepository.deleteById(userSkillId);
    }
}
