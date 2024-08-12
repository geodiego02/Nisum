package com.nisuminternacional.eva.backend.exception;

public class UsuarioExistenteException extends Exception {
    public UsuarioExistenteException(String mensaje) {
        super(mensaje);
    }
}

