package com.example.login.utils;

import org.springframework.context.MessageSource;

import java.util.Locale;

public class Common {

    public static String getMessage(String key, Locale locale, MessageSource messageSource) {
        String msg = messageSource.getMessage(key, null, locale);
        if (msg == null) {
            msg = key;
        }

        return msg;
    }
}
