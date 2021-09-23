package com.example.fitness.security;

import com.example.fitness.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    private UserAuthenticationSuccessHandler successHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/index.html").permitAll()
                .antMatchers("/registrationTrainer.html").permitAll()
                .antMatchers("/js/**" , "/css/**").permitAll()
                .antMatchers("/api/registration/**").permitAll()
                .antMatchers("/registrationMember.html").permitAll()
                .antMatchers("/registrationUser.html").permitAll()
                .antMatchers("/adminpanel.html").hasAuthority(Role.ADMIN.getAuthority())
                .antMatchers("/api/admin").hasAuthority(Role.ADMIN.getAuthority())
                .antMatchers("/api/admin/**").hasAuthority(Role.ADMIN.getAuthority())
                .anyRequest().authenticated().and()
                .formLogin().permitAll()
                .and().formLogin().successHandler(successHandler)
//                .loginProcessingUrl("/login")
//                .defaultSuccessUrl("/index.html", true)
                .and()
                .logout().permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/403")
                .and()
                .csrf().disable();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {return NoOpPasswordEncoder.getInstance();}



}
