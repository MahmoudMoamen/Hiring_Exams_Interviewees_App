package com.webApp.shared;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Utils {
    public static String generateUserID(){
        return UUID.randomUUID()+"";
    }
}
