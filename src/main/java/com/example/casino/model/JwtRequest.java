package com.example.casino.model;

import lombok.Data;

@Data
public class JwtRequest {

    private String login;
    private String password;
}
