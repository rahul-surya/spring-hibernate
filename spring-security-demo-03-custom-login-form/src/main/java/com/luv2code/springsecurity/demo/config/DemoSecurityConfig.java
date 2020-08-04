package com.luv2code.springsecurity.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	
	
	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		
//		UserBuilder users = User.withDefaultPasswordEncoder();  //deprecated
//
//		 auth.inMemoryAuthentication().withUser(users.username("rahul").password("123456").roles("USER"));
//		  auth.inMemoryAuthentication().withUser(users.username("admin").password("123456").roles("ADMIN"));
//		  auth.inMemoryAuthentication().withUser(users.username("dba").password("123456").roles("DBA"));
//		
//		
//	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		
		  auth.inMemoryAuthentication().withUser("rahul").password(passwordEncoder().encode("test123")).roles("USER");
		  auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder().encode("test123")).roles("ADMIN");
		  auth.inMemoryAuthentication().withUser("dba").password(passwordEncoder().encode("test123")).roles("DBA");
		
	}
	
	
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests().anyRequest().authenticated().and().formLogin().loginPage("/showMyLoginPage").loginProcessingUrl("/authenticateTheUser").permitAll();
	}





	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	
	

}
