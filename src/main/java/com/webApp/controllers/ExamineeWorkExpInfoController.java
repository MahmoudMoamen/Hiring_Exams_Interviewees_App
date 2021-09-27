package com.webApp.controllers;

import com.webApp.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("registration")
public class ExamineeWorkExpInfoController {
    @Autowired
    FormService formService;
}
