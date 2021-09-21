package com.aptech.config;

import com.aptech.config.autotables.CreateAdminTable;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        CreateAdminTable.createTable();
        CreateAdminTable.defaultData();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
       // CreateAdminTable.dropTable();
    }
}
