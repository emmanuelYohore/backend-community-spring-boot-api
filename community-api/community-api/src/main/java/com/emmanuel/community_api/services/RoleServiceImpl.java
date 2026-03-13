package com.emmanuel.community_api.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emmanuel.community_api.dtos.RoleDto;
import com.emmanuel.community_api.entities.Role;
import com.emmanuel.community_api.mappers.RoleMapperImpl;
import com.emmanuel.community_api.repositories.RoleRepository;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;
    private RoleMapperImpl roleMapper;

    public RoleServiceImpl(RoleRepository roleRepository, RoleMapperImpl roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }

    public RoleDto createRole(RoleDto roleDto) {
        Role role = roleMapper.fromRoleDto(roleDto);
        Role savedRole = roleRepository.save(role);
        return roleMapper.fromRole(savedRole);
    }

    public RoleDto getRoleById(String id) {
        Role role = roleRepository.findById(id).orElseThrow(() -> new RuntimeException("Role not found"));
        return roleMapper.fromRole(role);
    }

    public List<RoleDto> getAllRole() {
        List<Role> roles = roleRepository.findAll();
        return roles.stream().map(role -> roleMapper.fromRole(role)).collect(Collectors.toList());
    }

    public RoleDto updateRole(String id, RoleDto roleDto) {
        Role existingRole = roleRepository.findById(id).orElseThrow(() -> new RuntimeException("Role not found"));
        existingRole.setName(roleDto.getName());

        Role updatedRole = roleRepository.save(existingRole);
        return roleMapper.fromRole(updatedRole);
    }

    public void deleteRole(String id) {
        Role role = roleRepository.findById(id).orElseThrow(() -> new RuntimeException("Role not found"));
        roleRepository.delete(role);
    }
}
