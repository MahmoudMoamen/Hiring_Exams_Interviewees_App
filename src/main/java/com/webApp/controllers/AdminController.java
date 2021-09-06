package com.webApp.controllers;

import com.webApp.requestModels.AdminDetailsRequestModel;
import com.webApp.shared.AdminDto;
import com.webApp.responses.AdminResponse;
import com.webApp.service.AdminService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("admins")
public class AdminController {
    @Autowired
    AdminService adminService;

//    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
//    public AdminResponse getAdminById(long id) {
//        AdminResponse returnValue = new AdminResponse();
//        AdminDto adminDto = adminService.getAdminById(id);
//        BeanUtils.copyProperties(adminDto, returnValue);
//        return returnValue;
//    }

    @PostMapping(consumes ={MediaType.APPLICATION_JSON_VALUE},produces ={MediaType.APPLICATION_JSON_VALUE})
    public AdminResponse createAdmin(@RequestBody AdminDetailsRequestModel adminDetails) throws Exception {
        AdminResponse returnValue = new AdminResponse();
        if (adminDetails.getUsername().isEmpty()) throw new NullPointerException("The Object is null");
        AdminDto adminDto = new AdminDto();
        BeanUtils.copyProperties(adminDetails,adminDto);

        AdminDto createdAdmin=adminService.createAdmin(adminDto);
        BeanUtils.copyProperties(createdAdmin, returnValue);
        return returnValue;
    }
}
