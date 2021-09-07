package com.webApp.service;

import com.webApp.entities.AdminsEntity;
import com.webApp.responses.AdminResponse;
import com.webApp.shared.AdminDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.ArrayList;

public interface AdminService extends UserDetailsService{
    AdminDto getAdminById(long id);
    AdminDto createAdmin(AdminDto admin);
    AdminDto getAdminByUsername(String username);
    AdminResponse getUserDetailsSecurity(String email);
}
