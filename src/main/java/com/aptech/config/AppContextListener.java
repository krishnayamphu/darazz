package com.aptech.config;

import com.aptech.config.autotables.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

@WebListener
public class AppContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();

        ServletContext servletContext = sce.getServletContext();

        servletContext.setInitParameter("homeUrl", "http://localhost:8080/darazz");
        CreateAdminTable.createTable();
        CreateAdminTable.defaultData();
        CreateUserTable.createTable();
        CreateUserTable.defaultData();

//        CreateCategoryTable.createTable();
//        CreateInventoryTable.createTable();
//        CreateDiscountTable.createTable();
//        CreateProductTable.createTable();

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        CreateAdminTable.dropTable();
        CreateUserTable.dropTable();

//        CreateProductTable.dropTable();
//        CreateCategoryTable.dropTable();
//        CreateInventoryTable.dropTable();
//        CreateDiscountTable.dropTable();
    }

    public static String getURLWithContextPath(HttpServletRequest request) {
        return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }
}
