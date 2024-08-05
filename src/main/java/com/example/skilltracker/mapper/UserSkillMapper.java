package com.example.skilltracker.mapper;

import com.example.skilltracker.dtos.UserSkillDto;
import com.example.skilltracker.model.UserSkill;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {SkillMapper.class, UserMapper.class})
public interface UserSkillMapper {
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "skill.id", target = "skillId")
    UserSkillDto toDto(UserSkill userSkill);

    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "skillId", target = "skill.id")
    UserSkill toEntity(UserSkillDto userSkillDto);

    void updateEntityFromDto(UserSkillDto userSkillDto, @MappingTarget UserSkill userSkill);
}
