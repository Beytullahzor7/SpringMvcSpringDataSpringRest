package com.innova.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class _10_Authorization extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/","/index").permitAll()
                    .antMatchers("/security/writer").hasRole("USER") //Bu kısımlar controllerdaki endpointlerdir
                    .antMatchers("/security/admin").hasRole("ADMIN")
                    .anyRequest()
                    .authenticated()
                .and()
                    .formLogin();
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authentication) throws Exception {
        authentication
                .inMemoryAuthentication()
                    .withUser("admin")
                    .password("{noop}root")
                    .roles("ADMIN","USER") //admin hem user hem de admin sayfasına girebilsin
                .and()
                    .withUser("writer")
                    .password("{noop}root")
                    .roles("USER") //Writer sadece user sayfasına erisim saglasın
                .and();

    }
}
