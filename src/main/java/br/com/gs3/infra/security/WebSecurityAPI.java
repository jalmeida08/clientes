package br.com.gs3.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import br.com.gs3.infra.service.TokenService;


@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
@Configuration
public class WebSecurityAPI extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private TokenService tokenService;
	
	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
            .antMatchers(HttpMethod.POST, "/login").permitAll()
            .antMatchers("/h2-console/**").permitAll()
            .antMatchers("/h2/**").permitAll()
    		.anyRequest().authenticated()
    		.and().csrf().disable()
    		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    		.and().addFilterBefore(new AutenticacaoViaTokenFilter(tokenService, this.userDetailsService()), UsernamePasswordAuthenticationFilter.class);
        

    }
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.
			inMemoryAuthentication()
			.withUser("comum").password(passwordEncode().encode("123456"))
			.roles("USER")
			.and()
			.withUser("admin").password(passwordEncode().encode("123456"))
            .roles("USER", "ADMIN");
			
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncode() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected UserDetailsService userDetailsService() {
		return super.userDetailsService();
	}
	
	@Override
	public void configure(WebSecurity web)
			throws Exception {
		 web.ignoring().antMatchers("/h2-console/**")
		 .antMatchers("/h2/**");
	}
}