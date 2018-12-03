package com.example.curso.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication().withUser("alberto").password("alberto").roles("ADMIN");
<<<<<<< HEAD
		auth.inMemoryAuthentication().withUser("user").password("b14361404c78ffd549c3db443c3fede2f3e534d73f78f7731ed97d4a436a9fd9db05ee8b325c0ad36438b43fec851c204fc1c1edb21d941c0e9e2c1ce2").roles("USER");
=======
		auth.inMemoryAuthentication().withUser("user").password("B14361404C078FFD549C03DB443C3FEDE2F3E534D73F78F77301ED97D4A436A9FD9DB05EE8B325C0AD36438B43FEC8510C204FC1C1EDB21D0941C00E9E2C1CE2").roles("USER");
>>>>>>> a6223e88de1126a514d7fa0d9e3ed3a4e7a59537
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable().authorizeRequests()
		.antMatchers("/todos_profesores_public").permitAll()
		.antMatchers("/todos_profesores_admin").hasRole("ADMIN")
		.antMatchers("/todos_profesores_user").hasRole("USER")
		.antMatchers("/*/escribirDB/**").hasRole("ADMIN")
		.and()
		.httpBasic();
	}
	
	@SuppressWarnings("deprecation")
	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}
}
