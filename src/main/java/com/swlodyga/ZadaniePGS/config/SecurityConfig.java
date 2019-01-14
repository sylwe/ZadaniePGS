package com.swlodyga.ZadaniePGS.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private static String REALM="MY_TEST_REALM";
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception{
        authenticationMgr.inMemoryAuthentication()
                .withUser("administrator")
                .password("{noop}administrator")
                .authorities("ROLE_ADMIN", "ROLE_USER")
                .and()
                .withUser("student")
                .password("{noop}student")
                .authorities("ROLE_USER");
    }
    // AUTHORIZATION
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                .exceptionHandling()
                .and()
                .authorizeRequests()
                .antMatchers("/student/**").hasRole("USER")
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/").permitAll()
                .and()
                .httpBasic()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .logout();
    }

}
