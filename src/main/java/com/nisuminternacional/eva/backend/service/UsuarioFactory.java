package com.nisuminternacional.eva.backend.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.nisuminternacional.eva.backend.model.Usuario;
import com.nisuminternacional.eva.backend.model.Telefono;

public class UsuarioFactory {

    public static Usuario createUsuario(String name, String email, String password, List<Telefono> phones) {
        Usuario usuario = new Usuario();
        usuario.setName(name);
        usuario.setEmail(email);
        usuario.setPassword(password);
        usuario.setPhones(phones);
        usuario.setCreated(new Date());
        usuario.setModified(new Date());
        usuario.setLastLogin(new Date());
        usuario.setToken(UUID.randomUUID().toString());
        usuario.setActive(true);
        return usuario;
    }
}

