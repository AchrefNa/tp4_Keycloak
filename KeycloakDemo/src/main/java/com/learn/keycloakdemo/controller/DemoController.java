package com.learn.keycloakdemo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/demo")
public class DemoController {
    @PreAuthorize("hasAnyRole('ROLE_[client_user]','ROLE_[client_admin]')")
    @GetMapping("hello")
    public String helloUser() {
        return "hello peasant.";
    }

    @PreAuthorize("hasAnyRole('ROLE_[client_admin]')")
    @GetMapping("helloadmin")
    public String helloAdmin() {
        return "Copy That.";
    }

    @GetMapping("profile")
    public Authentication profile(Authentication auth) {
        return auth;
    }
}
