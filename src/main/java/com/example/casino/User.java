package com.example.casino;

import lombok.*;

import java.util.Set;

@Data
@AllArgsConstructor
public class User {
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private Set<Role> roles;
}
