package com.amithchalana.fileuploadbackend;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@SpringBootApplication
public class AppInitializer {

	public static void main(String[] args) {
		SpringApplication.run(AppInitializer.class, args);
	}


//	@Bean
//	public HttpSecurity securityFilterChain(HttpSecurity http) throws Exception {
//		return http.authorizeHttpRequests( authz -> authz
////				.mvcMatchers(HttpMethod.POST,"/api/v1/users").permitAll()
////				.requestMatchers("/api/v1/users/**").permitAll()
//				.anyRequest().authenticated() );
//
//	}


	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}


	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.authorizeHttpRequests()
				.mvcMatchers(HttpMethod.POST,"/api/v1/users/create").permitAll()
				.anyRequest().authenticated()
				.and()
				.csrf().disable()       // Cross site request forgery
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER)
				.and()
				.httpBasic()
				.and().build();
	}





}
