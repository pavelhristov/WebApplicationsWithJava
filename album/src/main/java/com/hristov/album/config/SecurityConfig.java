package com.hristov.album.config;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private static final String ADMIN = "ADMIN";

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/**");
	}

	// @Override
	// public void configure(HttpSecurity httpSecurity) throws Exception{
	// httpSecurity.authorizeRequests()
	// //.antMatchers("/admin/**").hasRole(ADMIN)
	// .antMatchers("/**").permitAll()
	// .antMatchers(
	// HttpMethod.GET,
	// "/",
	// "/*.html",
	// "/favicon.ico",
	// "/**/*.html",
	// "/**/*.css",
	// "/**/*.js"
	// ).permitAll()
	// .and()
	// .formLogin();
	// }

//	@Autowired
//	public void addCorsMappings(CorsRegistry registry) {
//		registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "POST", "OPTIONS", "PUT")
//				.allowedHeaders("Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
//						"Access-Control-Request-Headers")
//				.exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials")
//				.allowCredentials(true).maxAge(3600);
//	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("12345q").roles(ADMIN);
	}

}
