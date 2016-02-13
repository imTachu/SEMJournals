package com.sem.journal.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

import com.sem.journal.filters.CorsFilter;
import com.sem.journal.services.security.UserDetailService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailService userDetailsService;
	
	@Autowired
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http				
			.antMatcher("/rest/**")
			.authorizeRequests()				
				.antMatchers("/rest/journals","/rest/subscription/{journalUser}", "/rest/user/public").permitAll()
				.anyRequest().authenticated()
				.and()			
			.logout()				
				.logoutUrl("/rest/logout")
				.logoutSuccessUrl("/rest/doLogin").permitAll()				
				.and()
			.csrf().disable()	
			 .addFilterBefore(new CorsFilter(),ChannelProcessingFilter.class)
			.httpBasic();
	}
	
	@SuppressWarnings("unused")
	private CsrfTokenRepository csrfTokenRepository(){
		HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
		repository.setHeaderName("X-XSRF-TOKEN");
		return repository;
	}
}