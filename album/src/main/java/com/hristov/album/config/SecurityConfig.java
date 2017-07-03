package com.hristov.album.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	private static final String ADMIN = "ADMIN";

	@Override
	public void configure(HttpSecurity httpSecurity) throws Exception{
		httpSecurity.authorizeRequests()
			.antMatchers("/admin/**").hasRole(ADMIN)
			.antMatchers(
                    HttpMethod.GET,
                    "/",
                    "/*.html",
                    "/favicon.ico",
                    "/**/*.html",
                    "/**/*.css",
                    "/**/*.js"
            ).permitAll()
			.and()
			.formLogin();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication()
		.withUser("admin").password("12345q").roles(ADMIN);
	}
	
}
