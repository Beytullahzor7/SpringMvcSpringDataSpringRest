package com.innova.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

//@EnableWebSecurity
public class _07_AddUserEncrypedBean extends WebSecurityConfigurerAdapter {

//    @Bean //Bunu yapı herkesin kullanabilmesini saglar önceki yaptıgımız yapılar ise sadece local yapısındaki birimler kullanır
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
//        authenticationManagerBuilder
//                .inMemoryAuthentication() //bellek üzerinde olsun db olmasın
//                .withUser("root") //username
//                .password(passwordEncoder().encode("root")) //sifrelenmis data
//                .roles("USER");
//    }
}
