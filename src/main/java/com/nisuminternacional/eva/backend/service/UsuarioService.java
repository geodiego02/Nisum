package com.nisuminternacional.eva.backend.service;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nisuminternacional.eva.backend.exception.UsuarioExistenteException;
import com.nisuminternacional.eva.backend.model.Usuario;
import com.nisuminternacional.eva.backend.repository.UsuarioRepository;

@Service
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;
    private final EmailValidator emailValidator;
    private final PasswordValidator passwordValidator;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, EmailValidator emailValidator, PasswordValidator passwordValidator) {
        this.usuarioRepository = usuarioRepository;
        this.emailValidator = emailValidator;
        this.passwordValidator = passwordValidator;
    }

    public Usuario registrarUsuario(Usuario usuario) throws UsuarioExistenteException {
        if (!emailValidator.validate(usuario.getEmail())) {
            throw new IllegalArgumentException("El correo tiene un formato inválido. Se debe cambiar.");
        }

        if (!passwordValidator.validate(usuario.getPassword())) {
            throw new IllegalArgumentException("La contraseña tiene un formato inválido. Se debe cambiar.");
        }

        if (usuarioRepository.findByEmail(usuario.getEmail()).isPresent()) {
            throw new UsuarioExistenteException("El correo ingresado ya se encuentra registrado. Debe escoger otro correo.");
        }

        usuario.setCreated(new Date());
        usuario.setModified(new Date());
        usuario.setLastLogin(new Date());
        usuario.setToken(UUID.randomUUID().toString());
        usuario.setActive(true);
        return usuarioRepository.save(usuario);
    }
}

