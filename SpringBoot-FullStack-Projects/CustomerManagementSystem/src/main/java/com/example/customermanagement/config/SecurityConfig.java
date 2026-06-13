package com.example.customermanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(auth -> auth
						.requestMatchers("/web/customers/add", "/web/customers/save", "/web/customers/edit/**",
								"/web/customers/update/**", "/web/customers/delete/**")
						.hasRole("ADMIN").anyRequest().authenticated())
				.oauth2Login(oauth -> oauth.loginPage("/login").defaultSuccessUrl("/web/customers", true)
						.userInfoEndpoint(userInfo -> userInfo.userAuthoritiesMapper(authorities -> {
							return java.util.List
									.of(new org.springframework.security.core.authority.SimpleGrantedAuthority(
											"ROLE_GOOGLE"));
						})))
				.formLogin(form -> form.loginPage("/login").defaultSuccessUrl("/web/customers", true).permitAll())
				.logout(logout -> logout.logoutUrl("/logout").logoutSuccessUrl("/login?logout")
						.invalidateHttpSession(true).clearAuthentication(true).permitAll());

		return http.build();
	}

	@Bean
	public InMemoryUserDetailsManager userDetailsService() {
		UserDetails admin = User.withDefaultPasswordEncoder().username("jatin").password("12345").roles("ADMIN") // ADMIN
																													// role
				.build();

		UserDetails user = User.withDefaultPasswordEncoder().username("guest").password("guest123").roles("USER") // USER
																													// role
																													// -
																													// sirf
																													// read
				.build();

		return new InMemoryUserDetailsManager(admin, user);
	}

}
