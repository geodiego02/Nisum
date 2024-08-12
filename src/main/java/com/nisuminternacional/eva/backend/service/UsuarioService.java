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

    @Autowired
    private UsuarioRepository usuarioRepository;

    private EmailValidator emailValidator;
    private PasswordValidator passwordValidator;

    public UsuarioService() {
        this.emailValidator = new RegexEmailValidator("^[A-Za-z0-9+_.-]+@(.+)$");
        this.passwordValidator = new RegexPasswordValidator("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,}$");
    }

    public Usuario registrarUsuario(Usuario usuario) throws UsuarioExistenteException {
        if (!emailValidator.validate(usuario.getEmail())) {
            throw new IllegalArgumentException("El correo tiene un formato inválido");
        }

        if (!passwordValidator.validate(usuario.getPassword())) {
            throw new IllegalArgumentException("La contraseña tiene un formato inválido");
        }

        if (usuarioRepository.findByEmail(usuario.getEmail()).isPresent()) {
            throw new UsuarioExistenteException("El correo ya registrado");
        }

        usuario.setCreated(new Date());
        usuario.setModified(new Date());
        usuario.setLastLogin(new Date());
        usuario.setToken(UUID.randomUUID().toString());
        usuario.setActive(true);
        return usuarioRepository.save(usuario);
    }
}

