package com.example.fitness.entity;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN,
    TRAINER,
    MEMBER;

    @Override
    public String getAuthority() {
        return name();
    }
}
