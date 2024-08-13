package com.nisuminternacional.eva.backend.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RegexEmailValidator implements EmailValidator {
    private String regex;

    public RegexEmailValidator(@Value("${app.regex.email}") String regex) {
        this.regex = regex;
    }

    @Override
    public boolean validate(String email) {
        return email.matches(regex);
    }
}
