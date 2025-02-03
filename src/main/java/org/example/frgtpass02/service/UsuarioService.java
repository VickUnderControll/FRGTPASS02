package org.example.frgtpass02.service;

import org.example.frgtpass02.model.Usuario;

public interface UsuarioService {
    void registrarUsuario(Usuario usuario);
    boolean validarUsuario(Usuario usuario);
}