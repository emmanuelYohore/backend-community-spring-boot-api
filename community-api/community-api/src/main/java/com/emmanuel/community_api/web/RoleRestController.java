package com.emmanuel.community_api.web;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emmanuel.community_api.dtos.RoleDto;
import com.emmanuel.community_api.services.RoleService;

@RestController
public class RoleRestController {

    private RoleService roleService;

    public RoleRestController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping(path = "/api/v1/roles")
    public List<RoleDto> getAllRoles() {
        return roleService.getAllRole();
    }

    @GetMapping(path = "/api/v1/roles/{roleId}")
    public RoleDto getRoleById(@PathVariable String roleId) {
        return roleService.getRoleById(roleId);
    }

    @PostMapping("/api/v1/roles")
    public RoleDto saveRole(@RequestBody RoleDto roleDto) {
        return roleService.createRole(roleDto);
    }

    @PutMapping("/api/v1/roles/{roleId}")
    public RoleDto updateRole(@PathVariable String roleId, @RequestBody RoleDto roleDto) {
        return roleService.updateRole(roleId, roleDto);
    }

    @DeleteMapping("/api/v1/roles/{roleId}")
    public void deleteRole(@PathVariable String roleId) {
        roleService.deleteRole(roleId);
    }
}
