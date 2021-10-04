package com.webApp.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.webApp.service.AdminService;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;

import javax.servlet.http.HttpServletRequest;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
    private final UserDetailsService adminDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ObjectMapper objectMapper;

    public WebSecurity(UserDetailsService adminDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder, ObjectMapper objectMapper) {
        this.adminDetailsService = adminDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.objectMapper = objectMapper;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.POST, SecurityConstants.SIGN_UP_URL)
                .permitAll()
                .antMatchers("/v2/api-docs", "/configuration/**", "/swagger*/**", "/webjars/**")
                .permitAll()
                .antMatchers(HttpMethod.POST,"/questions","/questions/*","/registration/PersonalInfo","/registration/EducationalInfo/*","/registration/WorkExperienceInfo/*","/registration/JobQuestions/*","/registration/ExtraQuestions/*")
                .permitAll()
                .antMatchers(HttpMethod.DELETE,"/questions/*")
                .permitAll()
                .antMatchers(HttpMethod.PUT,"/registration/PersonalInfo/*","/registration/EducationalInfo/*","/registration/WorkExperienceInfo/*","/registration/JobQuestions/*")
                .permitAll()
                .anyRequest().authenticated().and()
                .addFilter(getAuthenticationFilter())
                .addFilterBefore(new CorsFilter(), ChannelProcessingFilter.class)
                //.addFilter(new AuthorizationFilter(authenticationManager(), objectMapper))
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(adminDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    public AuthenticationFilter getAuthenticationFilter() throws Exception {
        final AuthenticationFilter filter = new AuthenticationFilter(authenticationManager(), adminDetailsService);
        filter.setFilterProcessesUrl("/admins/login");
        return filter;
    }
}
