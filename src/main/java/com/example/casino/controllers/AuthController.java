package com.example.casino.controllers;

import com.example.casino.exceptions.AuthException;
import com.example.casino.model.JwtRequest;
import com.example.casino.model.JwtResponse;
import com.example.casino.model.RefreshJwtRequest;
import com.example.casino.services.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest authRequest) {
        final JwtResponse token = authService.login(authRequest);
        return ResponseEntity.ok(token);
    }

    @PostMapping("token")
    public ResponseEntity<JwtResponse> getNewAccessToken(@RequestBody RefreshJwtRequest request){
        final JwtResponse token = authService.getAccessToken(request.getRefreshToken());
        return ResponseEntity.ok(token);
    }

    @PostMapping("refresh")
    public ResponseEntity<JwtResponse> getNewRefreshToken(@RequestBody RefreshJwtRequest request){
        final JwtResponse token = authService.refresh(request.getRefreshToken());
        return ResponseEntity.ok(token);
    }

    @ExceptionHandler(AuthException.class)
    public String handle(IllegalArgumentException e){
        log.error(e.getMessage());
        return "Auth_Exception!";
    }

    @ExceptionHandler()
    public String handle(Exception e){
        log.error(e.getMessage());
        return "Internal Server Error";
    }

}
