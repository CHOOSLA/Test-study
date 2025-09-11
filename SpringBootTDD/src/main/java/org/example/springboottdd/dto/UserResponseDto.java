package org.example.springboottdd.dto;

import lombok.Getter;
import org.example.springboottdd.entity.User;

@Getter
public class UserResponseDto {

    private final Long id;
    private final String name;
    private final String password;

    public UserResponseDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.password = user.getPassword();
    }
}
