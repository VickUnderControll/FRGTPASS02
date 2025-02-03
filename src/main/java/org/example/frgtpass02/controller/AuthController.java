package org.example.frgtpass02.controller;

import org.example.frgtpass02.model.Usuario;
import org.example.frgtpass02.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class AuthController {

    private final UsuarioService usuarioService;

    public AuthController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(Usuario usuario, RedirectAttributes redirectAttributes) {
        if(usuarioService.validarUsuario(usuario)) {
            redirectAttributes.addFlashAttribute("errorMessage", "El usuario ya está registrado.");
            return "redirect:/register";
        }else {
            usuarioService.registrarUsuario(usuario);
            return "redirect:/login";
        }

    }
}