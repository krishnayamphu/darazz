package com.aptech.controllers.auth;

import com.aptech.dao.AdminDao;
import com.aptech.models.Admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/admin/login")
public class AdminLoginController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String msg="<div class='alert alert-danger'> Invalid username or password.</div>";
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        Admin admin=new Admin();
        admin.setUsername(username);
        admin.setPassword(password);
        if(AdminDao.auth(admin)){
            HttpSession session =request.getSession();
            session.setAttribute("admin",username);
           response.sendRedirect("dashboard");
        }else {
            request.setAttribute("error",msg);
            request.getRequestDispatcher("/auth/admin-login.jsp").include(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/auth/admin-login.jsp").forward(request,response);
    }
}
