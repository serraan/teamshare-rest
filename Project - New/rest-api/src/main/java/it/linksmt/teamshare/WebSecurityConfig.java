/*******************************************************************************
 * Copyright (c) 2019 Link Management & Technology S.p.A. 
 * via R. Scotellaro, 55 - 73100 - Lecce - http://www.linksmt.it
 * All rights reserved. 
 *
 * Contributors:
 *     Links Management & Technology S.p.A. - initial API and implementation
 *******************************************************************************/
package it.linksmt.teamshare;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import it.linksmt.teamshare.architecture.security.MyJwtAuthenticationProvider;
import it.linksmt.teamshare.architecture.web.MyJwtSecurityFilter;

/**
 * Configurazione della sicurezza web.
 * 
 * @author mario
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {
	@Autowired
	private MyJwtAuthenticationProvider authenticationProvider;	

	@Autowired
	private MyJwtSecurityFilter jwtFilter;
	
	/* (non-Javadoc)
	 * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.web.builders.HttpSecurity)
	 */
	@Override
	protected void configure( HttpSecurity http ) throws Exception {
		http
			.csrf().disable()
		.headers()
			.frameOptions().disable()
		.and()
			.sessionManagement().sessionCreationPolicy( SessionCreationPolicy.STATELESS )
		.and()
			.addFilterBefore( jwtFilter, BasicAuthenticationFilter.class )
			.authorizeRequests()
			.antMatchers( "/public/**" ).permitAll() // Logged and anonymous users
			.antMatchers( "/system/**" ).anonymous() // XXX For anonymous external systems only: we may want a custom role?
			.antMatchers( "/private/**" ).authenticated(); // Authenticated users only
	}
    /* (non-Javadoc)
     * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurer#addCorsMappings(org.springframework.web.servlet.config.annotation.CorsRegistry)
     */
    @Override
    public void addCorsMappings( CorsRegistry registry ) {
        registry
				.addMapping( "/**" )
				.allowedMethods( "HEAD", "GET", "PUT", "POST", "DELETE", "PATCH", "OPTIONS" );
    }
	
	/* (non-Javadoc)
	 * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder)
	 */
	@Override
	protected void configure( AuthenticationManagerBuilder auth ) throws Exception {
		auth.authenticationProvider( authenticationProvider );
	}
}