package com.nisuminternacional.eva.backend.util;

import java.util.HashMap;
import java.util.Map;

import com.nisuminternacional.eva.backend.model.Usuario;

public class UsuarioResponseAdapter {

    public static Map<String, Object> adapt(Usuario usuario) {
        Map<String, Object> response = new HashMap<>();
        response.put("id", usuario.getId());
        response.put("email", usuario.getEmail());
        response.put("created", usuario.getCreated());
        response.put("modified", usuario.getModified());
        response.put("last_login", usuario.getLastLogin());
        response.put("token", usuario.getToken());
        response.put("isactive", usuario.isActive());
        return response;
    }
}

