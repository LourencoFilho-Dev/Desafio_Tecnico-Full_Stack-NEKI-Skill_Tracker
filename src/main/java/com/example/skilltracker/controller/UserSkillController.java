package com.example.skilltracker.controller;

import com.example.skilltracker.dtos.UserSkillDto;
import com.example.skilltracker.service.UserSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/{userId}/skills")
public class UserSkillController {

    private final UserSkillService userSkillService;

    @Autowired
    public UserSkillController(UserSkillService userSkillService) {
        this.userSkillService = userSkillService;
    }

    @GetMapping
    public ResponseEntity<List<UserSkillDto>> getUserSkills(@PathVariable Long userId) {
        List<UserSkillDto> userSkills = userSkillService.getUserSkills(userId);
        return ResponseEntity.ok(userSkills);
    }

    @PostMapping
    public ResponseEntity<UserSkillDto> createUserSkill(@PathVariable Long userId, @RequestBody UserSkillDto userSkillDto) {
        UserSkillDto createdUserSkill = userSkillService.createUserSkill(userId, userSkillDto);
        return ResponseEntity.ok(createdUserSkill);
    }

    @PutMapping("/{userSkillId}")
    public ResponseEntity<UserSkillDto> updateUserSkill(@PathVariable Long userId, @PathVariable Long userSkillId, @RequestBody UserSkillDto userSkillDto) {
        UserSkillDto updatedUserSkill = userSkillService.updateUserSkill(userSkillId, userSkillDto);
        return ResponseEntity.ok(updatedUserSkill);
    }

    @DeleteMapping("/{userSkillId}")
    public ResponseEntity<Void> deleteUserSkill(@PathVariable Long userId, @PathVariable Long userSkillId) {
        userSkillService.deleteUserSkill(userSkillId);
        return ResponseEntity.noContent().build();
    }
}
