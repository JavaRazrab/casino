package com.example.casino;

import org.springframework.security.core.GrantedAuthority;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Role implements GrantedAuthority{

    ADMIN("ADMIN"),
    USER("USER");

    private final String vale;

    @Override
    public String getAuthority() {
        return vale;
    }
}
