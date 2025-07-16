package com.example.backend.auth.Customfilter;

import com.example.backend.auth.Models.Userdetails;
import com.example.backend.auth.Service.Userdetailsservice;
import com.example.backend.auth.Serviceimpl.JWTserviceimpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JWTFilter extends OncePerRequestFilter {

    @Autowired
    private JWTserviceimpl jwTserviceimpl;

    @Autowired
    private ApplicationContext applicationContext;
    

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        if(request.getRequestURI().equals("/api/user/register") || request.getRequestURI().equals("/api/user/login")){
            filterChain.doFilter(request,response);
            return;
        }

        String username = null;
        String token = null;

        String authorization = request.getHeader("Authorization");




        if(authorization != null && SecurityContextHolder.getContext().getAuthentication() == null){

            token = authorization.substring(7);
            username = jwTserviceimpl.extractUsername(token);

        }

        Userdetails userdetails = (Userdetails) applicationContext.getBean(Userdetailsservice.class).loadUserByUsername(username);

        if(jwTserviceimpl.isValidToken(token,userdetails)){

            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userdetails,null,userdetails.getAuthorities());
            usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

        }


        filterChain.doFilter(request,response);


    }

}
