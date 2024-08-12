package com.nisuminternacional.eva.backend.service;

public class RegexEmailValidator implements EmailValidator {
    private String regex;

    public RegexEmailValidator(String regex) {
        this.regex = regex;
    }

    @Override
    public boolean validate(String email) {
        return email.matches(regex);
    }
}
