package com.webApp.controllers;

import com.webApp.shared.AdminDto;
import com.webApp.responses.AdminResponse;
import com.webApp.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admins")
public class AdminController {
    @Autowired
    UserService userService;

    @GetMapping(path="/{id}",produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public AdminResponse getUser(@PathVariable String email) {
        AdminResponse returnValue = new AdminResponse();
        AdminDto adminDto = userService.getUser(email);
        BeanUtils.copyProperties(adminDto, returnValue);
        return returnValue;
    }
}
