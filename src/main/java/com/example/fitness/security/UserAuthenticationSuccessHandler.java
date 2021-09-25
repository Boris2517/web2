package com.example.fitness.security;

import com.example.fitness.entity.Role;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@Component
public class UserAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        boolean hasUserRole = false;
        boolean hasTrainerRole = false;
        boolean hasAdminRole = false;

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        if(authorities == null){
            System.out.println("authorities is null");
        }

        for(GrantedAuthority grantedAuthority : authorities) {
            System.out.println("enter the for");
            if (grantedAuthority.getAuthority().equals(Role.MEMBER.toString())) {
                System.out.println("role is memeber");
                hasUserRole = true;
                break;
            } else if (grantedAuthority.getAuthority().equals(Role.TRAINER.toString())) {
                System.out.println("role is trainer");
                hasTrainerRole = true;
                break;
            } else if (grantedAuthority.getAuthority().equals(Role.ADMIN.toString())) {
                System.out.println("role is admin");
                hasAdminRole = true;
                break;
            }
        }

            if(hasUserRole){
                redirectStrategy.sendRedirect(httpServletRequest, httpServletResponse, "/memberprofile.html");
            } else if(hasTrainerRole) {
                redirectStrategy.sendRedirect(httpServletRequest,httpServletResponse ,"/");
            } else if(hasAdminRole) {
                redirectStrategy.sendRedirect(httpServletRequest, httpServletResponse, "/adminpanel.html");
            } else {
                System.out.println(authentication.getName());
                throw new IllegalStateException();

            }
        }

}
