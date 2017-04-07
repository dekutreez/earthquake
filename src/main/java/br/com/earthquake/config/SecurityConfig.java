package br.com.earthquake.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource; 
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("SELECT logusr, senusr, stausr FROM usuario WHERE logusr=?")
		.authoritiesByUsernameQuery("SELECT u.logusr, p.dscprf FROM usuario u INNER JOIN usuario_perfil up ON up.codusr = u.codusr INNER JOIN perfil p ON p.codprf = up.codprf WHERE u.logusr = ?");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
			.antMatchers("/dashboard**").access("hasRole('ROLE_MEMBER')")
			.and().formLogin().loginPage("/login").failureUrl("/login?error")
			.usernameParameter("username").passwordParameter("password")
			.and()
			.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/login?logout").deleteCookies("JSESSIONID")
			.invalidateHttpSession(true);

		http.rememberMe()
		.rememberMeParameter("remember-me").tokenRepository(persistentTokenRepository())
		.tokenValiditySeconds(86400).rememberMeCookieName("JSESSIONIDEQ")
		.key("!34R7h9u4K3@")
		.and().csrf();
		
		http.sessionManagement()
        .maximumSessions(1)
        .maxSessionsPreventsLogin(false)
        .expiredUrl("/login?expired")
        .and()
        .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
        .invalidSessionUrl("/");
		
		
		http.authorizeRequests().antMatchers("/css/**", "/js/**", "/images/**").permitAll();
		
	}
	
	 // Work around https://jira.spring.io/browse/SEC-2855
    @Bean
    public SessionRegistry sessionRegistry() {
        SessionRegistry sessionRegistry = new SessionRegistryImpl();
        return sessionRegistry;
    }
	
	@Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl tokenRepositoryImpl = new JdbcTokenRepositoryImpl();
        tokenRepositoryImpl.setDataSource(dataSource);
        return tokenRepositoryImpl;
    }
	
}