package hasa.hafia.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableAutoConfiguration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.jdbcAuthentication()
			.dataSource(dataSource)
			.usersByUsernameQuery("SELECT email as principal, password as credentials, etat FROM users WHERE email =  ?")
			.authoritiesByUsernameQuery("SELECT email as principal, nom as role FROM user_roles WHERE email = ?")
			.passwordEncoder(new BCryptPasswordEncoder());
			
		
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {	
		http.authorizeRequests().antMatchers("/login");
		
		http.formLogin().loginPage("/login");
				
		http.authorizeRequests().antMatchers("/Candidat/liste").hasAnyAuthority("ROLE_DEMANDEUR");
		
		http.authorizeRequests().antMatchers("/Offre/liste").hasAuthority("ROLE_RECRUTEUR");
		
		http.exceptionHandling().accessDeniedPage("/Candidat/403");
		
		http.csrf().disable();
	}

}
