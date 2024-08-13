package com.nisuminternacional.eva.backend.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RegexPasswordValidator implements PasswordValidator {
    private String regex;

    public RegexPasswordValidator(@Value("${app.regex.password}") String regex) {
        this.regex = regex;
    }

    @Override
    public boolean validate(String password) {
        return password.matches(regex);
    }
}
