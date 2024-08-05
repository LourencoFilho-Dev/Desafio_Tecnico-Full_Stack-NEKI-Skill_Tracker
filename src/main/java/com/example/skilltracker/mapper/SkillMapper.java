package com.example.skilltracker.mapper;

import com.example.skilltracker.dtos.SkillDto;
import com.example.skilltracker.model.Skill;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface SkillMapper {
    SkillDto toDto(Skill skill);
    Skill toEntity(SkillDto skillDto);
    void updateEntityFromDto(SkillDto skillDto, @MappingTarget Skill skill);
}
