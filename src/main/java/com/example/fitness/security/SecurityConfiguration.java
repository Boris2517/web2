package com.example.fitness.security;

import com.example.fitness.entity.Role;
import com.example.fitness.entity.User;
import com.example.fitness.repository.AdminRepository;
import com.example.fitness.repository.MemberRepository;
import com.example.fitness.repository.TrainerRepository;
import com.example.fitness.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/index.html").permitAll()
                .antMatchers("/registrationUser.html").hasAuthority(Role.TRAINER.getAuthority())
                .antMatchers("/adminpanel.html").hasAuthority(Role.ADMIN.getAuthority())
                .antMatchers("/api/admin").hasAuthority(Role.ADMIN.getAuthority())
                .antMatchers("/api/admin/**").hasAuthority(Role.ADMIN.getAuthority())
                .and()
                .formLogin().permitAll()
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/index.html", true)
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
