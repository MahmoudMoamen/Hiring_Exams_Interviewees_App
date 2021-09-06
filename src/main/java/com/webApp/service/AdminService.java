package com.webApp.service;

import com.webApp.entities.AdminsEntity;
import com.webApp.shared.AdminDto;

import java.util.ArrayList;

public interface AdminService {
    AdminDto getAdminById(long id);
    AdminDto createAdmin(AdminDto admin);
}
