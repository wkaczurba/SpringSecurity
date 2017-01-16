package com.some.config;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http
			.authorizeRequests()
				.anyRequest()
				.authenticated()
				.and()
			.formLogin()
				.and()
			.requiresChannel()
			    .antMatchers("/sec/**").requiresSecure()
			    .and()
	        .requiresChannel()
	            .antMatchers("/insec/**").requiresInsecure()
	            .and()
			.httpBasic();
	}
	
	@Autowired DataSource dataSource;
	boolean basicAuthentication = false;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		if (basicAuthentication) {		
			// Basic in-memory authentication:
			auth
				.inMemoryAuthentication()
				.withUser("user").password("password").roles("USER").and()
				.withUser("admin").password("password").roles("USER", "ADMIN");
		} else {
			// JDBC authentication
			auth
				.jdbcAuthentication()
				.dataSource(dataSource)
				.passwordEncoder(passwordEncoder());
		}
		
		// other methods that are possible to apply:
		//   accountExpired(boolean)
		//   accountLocked(boolean)
		//   and()
		//   authorities(GrantedAuthority... )             - one or more authorities to grant to user
		//   authorities(List<? extends GrantedAuthority>) - same
		//   authorities(String ...)                       - same
		//   credentialsExpired(boolean)
		//   disabled(boolean)
		//   password(String)
		//   roles(String ...)
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		StandardPasswordEncoder encoder = new StandardPasswordEncoder("12d4kv");
		//System.out.println("abc123 encoded:   '" + encoder.encode("abc123") + "'");
		//System.out.println("password encoded: '" + encoder.encode("password") + "'");
		return encoder;
	}
	
}
