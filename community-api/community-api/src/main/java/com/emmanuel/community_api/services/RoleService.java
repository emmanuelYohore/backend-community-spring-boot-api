package com.emmanuel.community_api.services;

import java.util.List;

import com.emmanuel.community_api.dtos.RoleDto;

public interface RoleService {
    RoleDto createRole(RoleDto roleDto);
    RoleDto getRoleById(String id);
    List<RoleDto> getAllRole();
    RoleDto updateRole(String id, RoleDto roleDto);
    void deleteRole(String id);
}
