package com.nisuminternacional.eva.backend.service;

public class RegexPasswordValidator implements PasswordValidator {
    private String regex;

    public RegexPasswordValidator(String regex) {
        this.regex = regex;
    }

    @Override
    public boolean validate(String password) {
        return password.matches(regex);
    }
}
