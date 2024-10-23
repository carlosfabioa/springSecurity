package com.sesi.login.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.RequestMatcher;

public class ConfiguracaoSeguranca {

	
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http
			.authorizeHttpRequests((authorize)->
				authorize
					.requestMatchers("/login", "/registar").permitAll()
					.anyRequest().authenticated()
					)
			.formLogin((form)->
				form
					.loginPage("/login")
					.defaultSuccessUrl("/home", true)
					.permitAll()
					)
			.logout((logout) ->
				logout
					.logoutUrl("/logout")
					.logoutSuccessUrl("/login?logout")
					.invalidateHttpSession(true)
					.deleteCookies("JSESSIONID")
					.permitAll()
					);
		
		return http.build();
	}
}
