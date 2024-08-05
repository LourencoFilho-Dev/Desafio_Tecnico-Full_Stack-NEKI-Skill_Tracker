package com.example.skilltracker.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private Long id;
    private String name;
    private String login;
    private String password;
}

