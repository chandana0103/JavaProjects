package com.project.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

//for doing our own configuration instead of spring

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private UserDetailsService userDetailsService; //object for to set authentication provider
	
	//csrf disabled and it doesn't ask for login credentials even though we used security dependencies
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		
		
//		//simple lambda bulidup pattern
		http.csrf(customizer -> customizer.disable())
		.authorizeHttpRequests(request -> request
				.requestMatchers("register","login")
				.permitAll()
				.anyRequest().authenticated())
		//.httpBasic(Customizer.withDefaults())
		.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

		return http.build();
	}
	
	//to create userdetail service intsted of writing in application properties
//	@Bean
//	public UserDetailsService userDetailsService() {
//		
//		UserDetails user=User
//				.withDefaultPasswordEncoder()
//				.username("chandana")
//				.password("chandu")
//				.roles("USER")
//				.build();
//		
//		UserDetails admin=User
//				.withDefaultPasswordEncoder()
//				.username("admin")
//				.password("admin")
//				.roles("ADMIN")
//				.build();
//		
//		return new InMemoryUserDetailsManager(user,admin);
//		
//	}
	
	//to deal with database 
	@Bean
	public AuthenticationProvider authProvider() {
		DaoAuthenticationProvider provider =new DaoAuthenticationProvider();
		
		provider.setUserDetailsService(userDetailsService);
		//provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());		//befor using bcrypt of encoded password for authentication
		
		provider.setPasswordEncoder(new BCryptPasswordEncoder(12));		

		return provider;
	}
		
	//for JWT authentication 
	@Bean
	public AuthenticationManager authenticationManger(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}
		
//		http.csrf(customizer -> customizer.disable());	//for disabling csrf using lmbda
//		http.authorizeHttpRequests(request -> request.anyRequest().authenticated()); //for enabling security for request
//	//	http.formLogin(Customizer.withDefaults());	//for login form //no need when session is stateless
//		http.httpBasic(Customizer.withDefaults());
//		
//		//to make stateless 
//		http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//		
//		
		
		//without lambda mostly we use lamda 
		
//		Customizer<CsrfConfigurer<HttpSecurity>> custCsrf = new Customizer<CsrfConfigurer<HttpSecurity>>() {
//				  
//				  @Override
//				  public void customize(CsrfConfigurer<HttpSecurity> configurer) {
//				  
//					  configurer.disable(); 
//				  
//				  }
//				  
//		};
//				  http.csrf(custCsrf);
//				  
//				  Customizer<AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry> custHttp = new Customizer<AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry>() {
//
//					@Override
//					public void customize(AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry registry) {
//						// TODO Auto-generated method stub
//						registry.anyRequest().authenticated();
//					}
//				  };
//					http.authorizeHttpRequests(custHttp);
//				  
//				  
		
}
