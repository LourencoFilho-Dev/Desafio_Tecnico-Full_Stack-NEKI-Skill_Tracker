package com.example.skilltracker.model;

import com.example.skilltracker.enums.SkillLevel;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="user_skills")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "skill_id", nullable = false)
    private Skill skill;

    @Enumerated(EnumType.STRING)
    private SkillLevel level;
}
