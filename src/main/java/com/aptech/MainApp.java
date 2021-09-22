package com.aptech;

import com.aptech.dao.AdminDao;
import com.aptech.models.Admin;

public class MainApp {
    public static void main(String[] args) {
        Admin admin=new Admin();
        admin.setUsername("admin");
        admin.setPassword("aptech123");
        if(AdminDao.auth(admin)){
            System.out.println("welcome aptech");
        }else {
            System.out.println("invalid");
        }
    }
}
