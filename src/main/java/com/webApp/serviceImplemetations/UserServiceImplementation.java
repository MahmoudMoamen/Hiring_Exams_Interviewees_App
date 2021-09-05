package com.webApp.serviceImplemetations;

import com.webApp.entities.AdminsEntity;
import com.webApp.repositories.AdminsRepository;
import com.webApp.shared.AdminDto;
import com.webApp.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService {
    @Autowired
    AdminsRepository adminsRepository;

    public AdminDto getUser(String email){
        AdminsEntity AdminsEntity=adminsRepository.findByEmail(email);
        AdminDto returnValue= new AdminDto();
        BeanUtils.copyProperties(AdminsEntity,returnValue);
        return returnValue;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
