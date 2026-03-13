package com.emmanuel.community_api.mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.emmanuel.community_api.dtos.RoleDto;
import com.emmanuel.community_api.entities.Role;

@Service
public class RoleMapperImpl {

    public RoleDto fromRole(Role role) {
        RoleDto roleDto = new RoleDto();
        BeanUtils.copyProperties(role, roleDto);
        return roleDto;
    }

    public Role fromRoleDto(RoleDto roleDto) {
        Role role = new Role();
        BeanUtils.copyProperties(roleDto, role);
        return role;
    }
}
