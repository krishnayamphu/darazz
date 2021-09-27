package com.aptech;

import com.aptech.dao.AdminDao;
import com.aptech.models.Admin;
import org.apache.commons.codec.digest.DigestUtils;

public class MainApp {
    public static void main(String[] args) {
        Admin admin=new Admin();
        admin.setFirstname("Krishna");
        admin.setLastname("Yamphu");
        admin.setGender("m");
        admin.setUsername("krishnayamphu");
        admin.setEmail("krishnayamphu@gmail.com");
        admin.setContact("1234567890");
        admin.setPassword("krishna123");
        admin.setAddress("Kumaripati, Lalitpur");
        admin.setActive(1);
//        if(AdminDao.addUser(admin)){
//            System.out.println("data inserted");
//        }else {
//            System.out.println("error");
//        }

        String sha256hex = DigestUtils.sha256Hex("hello");
        System.out.println(sha256hex);
    }
}
