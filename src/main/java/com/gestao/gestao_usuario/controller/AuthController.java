package com.gestao.gestao_usuario.controller;

import com.gestao.gestao_usuario.dto.UserRegisterRequest;
import com.gestao.gestao_usuario.entity.User;
import com.gestao.gestao_usuario.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody @Valid UserRegisterRequest request) {

        User user = userService.register(request);
        return ResponseEntity.ok(user);
    }
}
