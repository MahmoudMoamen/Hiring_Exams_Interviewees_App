package com.webApp.security;

import com.webApp.WebApplicationContext;

public class SecurityConstants {
    public static final long EXPIRATION_TIME=2000000000;
    public static final String TOKEN_PREFIX="Bearer ";
    public static final String HEADER_STRING="Authorization";
    public static final String SIGN_UP_URL="/admins";

    public static String getTokenSecret(){
        AppProperties appProperties=(AppProperties) WebApplicationContext.getBean("AppProperties");
        return appProperties.getTokenSecret();
    }
}
