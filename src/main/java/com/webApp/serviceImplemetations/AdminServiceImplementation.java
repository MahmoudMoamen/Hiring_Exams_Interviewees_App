package com.webApp.serviceImplemetations;

import com.webApp.entities.AdminsEntity;
import com.webApp.exceptions.AdminServiceException;
import com.webApp.repositories.AdminsRepository;
import com.webApp.responses.AdminResponse;
import com.webApp.responses.ErrorMessages;
import com.webApp.shared.AdminDto;
import com.webApp.service.AdminService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class AdminServiceImplementation implements AdminService , UserDetailsService {
    @Autowired
    AdminsRepository adminsRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

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
        adminsEntity.setEncrypted_password(bCryptPasswordEncoder.encode(admin.getPassword()));


        AdminsEntity storedAdminDetails= adminsRepository.save(adminsEntity);
        AdminDto returnValue = new AdminDto();
        BeanUtils.copyProperties(storedAdminDetails,returnValue);
        return returnValue;
    }

    public AdminDto getAdminByUsername(String username){
        AdminsEntity adminsEntity = adminsRepository.findByUsername(username);
        AdminDto returnValue= new AdminDto();
        BeanUtils.copyProperties(adminsEntity,returnValue);
        return returnValue;
    }

    @Override
    public AdminResponse getUserDetailsSecurity(String email) {
        AdminResponse returnValue= new AdminResponse();
        AdminsEntity adminsEntity=adminsRepository.findByEmail(email);
        if(adminsEntity==null) throw new AdminServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
        BeanUtils.copyProperties(adminsEntity,returnValue);
        return returnValue;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AdminsEntity adminsEntity=adminsRepository.findByUsername(username);
        if(adminsEntity==null)
            throw new UsernameNotFoundException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
        return new User(adminsEntity.getEmail(),adminsEntity.getEncrypted_password(),new ArrayList<>());
    }
}
