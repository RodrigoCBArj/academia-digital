package me.dio.academia.digital.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping
    public String welcome() {
        return "Bem vindo à API da Academia Digital!";
    }

    @GetMapping("/users")
    @PreAuthorize("hasAnyRole('MANAGERS', 'USERS')")
    public String users() {
        return "Usuário autorizado!";
    }

    @GetMapping("/managers")
    @PreAuthorize("hasAnyRole('MANAGERS')")
    public String managers() {
        return "Administrador autorizado!";
    }
}
