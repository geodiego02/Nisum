package com.nisuminternacional.eva.backend.service;

import com.nisuminternacional.eva.backend.model.Telefono;

public class TelefonoFactory {

    public static Telefono createTelefono(String number, String citycode, String countrycode) {
        Telefono telefono = new Telefono();
        telefono.setNumber(number);
        telefono.setCitycode(citycode);
        telefono.setCountrycode(countrycode);
        return telefono;
    }
}

