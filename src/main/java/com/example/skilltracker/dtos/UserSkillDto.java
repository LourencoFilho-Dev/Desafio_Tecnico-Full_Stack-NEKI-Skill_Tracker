package com.example.skilltracker.dtos;

import com.example.skilltracker.enums.SkillLevel;
import lombok.*;
@Getter
@Setter
@RequiredArgsConstructor
public class UserSkillDto {
    private Long id;
    private Long userId;
    @NonNull
    private Long skillId;
    private SkillLevel level;


}
