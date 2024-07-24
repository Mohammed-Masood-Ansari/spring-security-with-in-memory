package com.ibm.spring_boot_security_latest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {
	
	/*
	 * this method is used to encode password because spring security by default
	 * bcrypt the password
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/*
	 * this configuration is for only basic authentication
	 */
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeHttpRequests((a)->a.anyRequest().authenticated()).httpBasic(Customizer.withDefaults());
		return http.build();
	}
	
	/*
	 * with the help of this method we store the data in memory that is local memory....
	 */
	@Bean
	public UserDetailsService detailsService() {
		
		UserDetails user = User.builder()
				.username("amir")
				.password(passwordEncoder().encode("amir@123"))
				.roles("USER")
				.build();
		
		UserDetails admin = User.builder()
				.username("rohan")
				.password(passwordEncoder().encode("rohan@123"))
				.roles("ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(user,admin);
	}
	
}
