package com.alura.forumhub.controllers;

import com.alura.forumhub.domain.user.User;
import com.alura.forumhub.infra.AuthenticationData;
import com.alura.forumhub.infra.JwtTokenData;
import com.alura.forumhub.infra.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping ("/login")
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    TokenService tokenService;

    @PostMapping
    public ResponseEntity login (@RequestBody @Valid AuthenticationData data) {
        var token = new UsernamePasswordAuthenticationToken(
                data.login(),
                data.password());
        var authentication = authenticationManager.authenticate(token);
        var tokenJWT = tokenService.generateToken((User) authentication.getPrincipal());

        return ResponseEntity.ok(new JwtTokenData(tokenJWT));
}}
