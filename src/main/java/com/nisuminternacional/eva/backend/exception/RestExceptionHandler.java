package com.nisuminternacional.eva.backend.exception;

import java.util.Collections;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UsuarioExistenteException.class)
    public ResponseEntity<Object> handleUsuarioExistente(UsuarioExistenteException ex, WebRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonMap("mensaje", ex.getMessage()));
    }
}

