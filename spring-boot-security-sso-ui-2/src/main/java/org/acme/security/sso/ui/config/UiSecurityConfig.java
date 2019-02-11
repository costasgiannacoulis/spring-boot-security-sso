package org.acme.security.sso.ui.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableOAuth2Sso
@Configuration
public class UiSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(final HttpSecurity http) throws Exception {
		http.antMatcher("/**")// @formatter:off
			.authorizeRequests().antMatchers("/", "/login**")
			.permitAll()
			.anyRequest()
			.authenticated();// @formatter:on
	}
}
