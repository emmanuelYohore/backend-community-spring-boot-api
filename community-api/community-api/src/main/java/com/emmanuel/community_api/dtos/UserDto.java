package com.emmanuel.community_api.dtos;

import lombok.Data;

@Data
public class UserDto {
    private String id;
    private String pseudo;
    private String email;
    private String password;
}
