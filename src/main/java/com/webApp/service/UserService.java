package com.webApp.service;

import com.webApp.shared.AdminDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    AdminDto getUser(String email);

}
