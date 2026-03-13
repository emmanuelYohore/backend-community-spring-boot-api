package com.emmanuel.community_api.dtos;

import com.emmanuel.community_api.enums.RoleType;

import lombok.Data;

@Data
public class RoleDto {
    private String id;
    private RoleType name;
}
