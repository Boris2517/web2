package com.example.fitness.entity.DTO;

import com.example.fitness.entity.Role;

public class UsernameAndRoleDTO {

    String username;
    Role role;

    public UsernameAndRoleDTO() {
    }

    public UsernameAndRoleDTO(String username, Role role) {
        this.username = username;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
