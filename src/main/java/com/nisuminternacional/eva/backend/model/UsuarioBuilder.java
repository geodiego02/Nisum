package com.nisuminternacional.eva.backend.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class UsuarioBuilder {
    private String name;
    private String email;
    private String password;
    private List<Telefono> phones = new ArrayList<>();
    private String token;
    private boolean isActive;

    public UsuarioBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public UsuarioBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public UsuarioBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public UsuarioBuilder addPhone(Telefono phone) {
        this.phones.add(phone);
        return this;
    }

    public UsuarioBuilder setToken(String token) {
        this.token = token;
        return this;
    }

    public UsuarioBuilder setActive(boolean isActive) {
        this.isActive = isActive;
        return this;
    }

    public Usuario build() {
        Usuario usuario = new Usuario();
        usuario.setName(this.name);
        usuario.setEmail(this.email);
        usuario.setPassword(this.password);
        usuario.setPhones(this.phones);
        usuario.setCreated(new Date());
        usuario.setModified(new Date());
        usuario.setLastLogin(new Date());
        usuario.setToken(this.token != null ? this.token : UUID.randomUUID().toString());
        usuario.setActive(this.isActive);
        return usuario;
    }
}
