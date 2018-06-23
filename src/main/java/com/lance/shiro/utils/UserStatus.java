package com.lance.shiro.utils;

import org.apache.commons.lang3.StringUtils;

public class UserStatus {
    public static String INACTIVE = "inactive";
    public static String ACTIVE = "active";
    public static String PENDING = "pending";
    public static String DRAFT = "draft";



    public static boolean validate(String status){
       if(StringUtils.equals(status, INACTIVE) || StringUtils.equals(status, ACTIVE)
               || StringUtils.equals(status, PENDING) || StringUtils.equals(status, DRAFT) ){
           return true;
       }
       return false;
   }

}
