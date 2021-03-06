package com.hithaui.configs;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import com.hithaui.services.JwtRequestFilter;
import com.hithaui.services.MyUserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
		
		@Autowired 
		private MyUserDetailsService myUserDetailsService;
		
		@Autowired
		private JwtRequestFilter jwtRequestFilter;
		
		@Bean
		public PasswordEncoder passwordEncoder() {
			
			return new BCryptPasswordEncoder();
		}
		
		@Override
		protected void configure(AuthenticationManagerBuilder auth)  throws Exception {
				auth.userDetailsService(myUserDetailsService).passwordEncoder(passwordEncoder());
		}
		
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			
			http.cors().configurationSource(request -> corsConfiguration()).and()
						.csrf().disable().authorizeRequests()
						.antMatchers("/api/login").permitAll()
						.antMatchers("/api/person").permitAll()
						.and().sessionManagement()
						.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
			
			http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
		}
		
		CorsConfiguration corsConfiguration() {
				CorsConfiguration corsConfiguration = new CorsConfiguration();
				corsConfiguration.applyPermitDefaultValues();
				corsConfiguration.addAllowedMethod(HttpMethod.PATCH);
				corsConfiguration.addAllowedMethod(HttpMethod.POST);
				corsConfiguration.addAllowedMethod(HttpMethod.DELETE);
				return corsConfiguration;
		}
		
		@Override
		@Bean
		protected AuthenticationManager authenticationManager() throws Exception {
			return super.authenticationManager();
				
		}
}
