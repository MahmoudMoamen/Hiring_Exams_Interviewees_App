package com.webApp.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.webApp.WebApplicationContext;
import com.webApp.requestModels.AdminLoginRequestModel;
import com.webApp.responses.AdminResponse;
import com.webApp.service.AdminService;
import com.webApp.shared.AdminDto;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    UserDetailsService as;
    private final AuthenticationManager authenticationManager;

    public AuthenticationFilter(AuthenticationManager authenticationManager, UserDetailsService as) {
        this.authenticationManager = authenticationManager;
        this.as=as;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) throws AuthenticationException {
        try {
            AdminLoginRequestModel creds = new ObjectMapper().readValue(req.getInputStream(), AdminLoginRequestModel.class);

            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(creds.getEmail(), creds.getPassword(), new ArrayList<>()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain Chain, Authentication auth) throws IOException, ServletException {
        String email = ((User) auth.getPrincipal()).getUsername();
        AdminService adminService= (AdminService) WebApplicationContext.getBean("adminServiceImplementation");

        AdminResponse adminResponse=adminService.getUserDetailsSecurity(email);
        String token = Jwts.builder().setSubject(email).claim("details",adminResponse).setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME)).signWith(SignatureAlgorithm.HS512,SecurityConstants.getTokenSecret()).compact();
        AdminDto adminDto=adminService.getAdminByUsername(email);
        res.addHeader(SecurityConstants.HEADER_STRING,SecurityConstants.TOKEN_PREFIX+token);
//        res.addHeader("hhs",adminService.getAdminByUsername());
    }
}
