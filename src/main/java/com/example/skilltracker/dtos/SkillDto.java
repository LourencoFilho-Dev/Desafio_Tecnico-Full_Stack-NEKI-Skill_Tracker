package com.example.skilltracker.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SkillDto {
    private Long id;
    private String name;
    private String description;
    private String imageUrl;
}

