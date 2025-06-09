package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
@EnableMethodSecurity
public class SecurityConfig {
	
	//Creacion de ususarios en memoria
	 @Bean
	 public UserDetailsService userDetailsService() {
		 UserDetails admin = User.builder()
	                .username("Celia")
	                .password(this.passwordEncoder().encode("celia"))
	                .roles("ADMIN") // asigna rol ADMIN
	                .authorities("READ", "CREATE")
	                .build();

	        UserDetails user1 = User.builder()
	                .username("Ana")
	                .password(this.passwordEncoder().encode("ana"))
	                .roles("USER") // asigna rol USER
	                .authorities("READ")
	                .build();

	        UserDetails user2 = User.builder()
	                .username("Juan")
	                .password(this.passwordEncoder().encode("juan"))
	                .roles("USER") // asigna rol USER
	                .authorities("READ")
	                .build();

	        return new InMemoryUserDetailsManager(admin, user1, user2);
		
	 }
	
	 @Bean
	 public PasswordEncoder passwordEncoder() {
	 return new BCryptPasswordEncoder();
	 }
}