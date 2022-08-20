package me.dio.academia.digital.security;

import me.dio.academia.digital.service.impl.SecurityDatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SecurityDatabaseService securityService;

    @Autowired
    public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(securityService).passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
            .authorizeHttpRequests()
                .antMatchers("/").permitAll()
//                .antMatchers("/login").permitAll()
                .antMatchers(HttpMethod.POST,"/login").permitAll()    // possível uso restringindo o método http
                .antMatchers("/managers").hasAnyRole("MANAGER")
                .antMatchers("/users").hasAnyRole("USER", "MANAGER")
                .anyRequest().authenticated().and().httpBasic();
    }

    /*@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user")
                .password("{noop}123")
                .roles("USERS")
                .and()
                .withUser("admin")
                .password("{noop}admin")
                .roles("MANAGERS");
    }*/
}
