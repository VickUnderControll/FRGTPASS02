package org.example.frgtpass02.controller;

import org.example.frgtpass02.model.Usuario;
import org.example.frgtpass02.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AuthController {

    private final UsuarioService usuarioService;

    public AuthController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/login")
    public String login() {
        return "login"; // Esto debe coincidir con el nombre del archivo HTML (login.html)
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(Usuario usuario) {
        usuarioService.registrarUsuario(usuario);
        return "redirect:/login";
    }
}