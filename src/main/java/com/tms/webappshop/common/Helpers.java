package com.tms.webappshop.common;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Helpers {

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

    public static String toUpFirstSymbol(String s) {
        if (!s.isEmpty() && s != null) {
            return s.substring(0, 1).toUpperCase() + s.substring(1);
        }
        return s;
    }
}
