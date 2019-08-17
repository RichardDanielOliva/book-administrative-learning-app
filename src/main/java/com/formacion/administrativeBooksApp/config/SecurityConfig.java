package com.formacion.administrativeBooksApp.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		
		auth.inMemoryAuthentication().withUser("user1").password(encoder.encode("12345678")).roles("USER");
		auth.inMemoryAuthentication().withUser("admin").password(encoder.encode("12345678")).roles("ADMIN");
		auth.inMemoryAuthentication().withUser("dba").password(encoder.encode("12345678")).roles("ADMINISTRADOR");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	  http.authorizeRequests()
		.antMatchers("/publicBook/book/administrative/**").access("hasRole('ROLE_ADMIN')")
		.antMatchers("/publicBook/book/administrative/**").access("hasRole('ROLE_ADMIN') or hasRole('ADMINISTRADOR')")
		.and().formLogin()
			  .loginPage("/admin/formLogin")
	          .loginProcessingUrl("/perform_login")
	          .defaultSuccessUrl("/admin/", false);
	  
	  http.cors().and().csrf().disable();
	}
	
	@Bean
	protected CorsConfigurationSource corsConfigurationSource() {
	        CorsConfiguration configuration = new CorsConfiguration();
	        configuration.setAllowedOrigins(Arrays.asList("*"));
	        configuration.setAllowedMethods(Arrays.asList("*"));
	        configuration.setAllowedHeaders(Arrays.asList("*"));
	        configuration.setAllowCredentials(true);
	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	        source.registerCorsConfiguration("/**", configuration);
	        return source;
	    }
}
