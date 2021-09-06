package com.webApp.serviceImplemetations;

import com.webApp.entities.AdminsEntity;
import com.webApp.repositories.AdminsRepository;
import com.webApp.shared.AdminDto;
import com.webApp.service.AdminService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;

@Service
public class AdminServiceImplementation implements AdminService {
    @Autowired
    AdminsRepository adminsRepository;

//    @Autowired
//    BCryptPasswordEncoder bCryptPasswordEncoder;

    public AdminDto getAdminById(long id){
        AdminsEntity adminsEntity = adminsRepository.findById(id);
        AdminDto returnValue= new AdminDto();
        BeanUtils.copyProperties(adminsEntity,returnValue);
        return returnValue;
    }

    public AdminDto createAdmin(AdminDto admin){
        if(adminsRepository.findByEmail(admin.getEmail())!=null){
            throw new RuntimeException("Email is already taken");
        }
        AdminsEntity adminsEntity= new AdminsEntity();
        BeanUtils.copyProperties(admin,adminsEntity);
        adminsEntity.setCreated_at(new Date(System.currentTimeMillis()));
        adminsEntity.setEncrypted_password(admin.getPassword());


        AdminsEntity storedAdminDetails= adminsRepository.save(adminsEntity);
        AdminDto returnValue = new AdminDto();
        BeanUtils.copyProperties(storedAdminDetails,returnValue);
        return returnValue;
    }

//    @Override
//    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        return null;
//    }
}
