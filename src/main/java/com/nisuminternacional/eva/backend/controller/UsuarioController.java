package com.nisuminternacional.eva.backend.controller;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nisuminternacional.eva.backend.exception.UsuarioExistenteException;
import com.nisuminternacional.eva.backend.model.Usuario;
import com.nisuminternacional.eva.backend.service.UsuarioService;
import com.nisuminternacional.eva.backend.util.UsuarioResponseAdapter;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/registro")
    public ResponseEntity<?> registrarUsuario(@RequestBody Usuario usuario) {
        try {
            Usuario usuarioRegistrado = usuarioService.registrarUsuario(usuario);
            Map<String, Object> response = UsuarioResponseAdapter.adapt(usuarioRegistrado);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (UsuarioExistenteException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonMap("mensaje", e.getMessage()));
        }
    }
}
