package com.springevenings.springdatarestsample.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private DetailsService detailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(detailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .csrf().disable();

        /*http.httpBasic().and().authorizeRequests().antMatchers(HttpMethod.POST, "/events").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/events/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PATCH, "/events/**").hasRole("ADMIN")
                .and().csrf().disable();*/
    }

    @Autowired
    public void setDetailsService(DetailsService detailsService) {
        this.detailsService = detailsService;
    }
}
