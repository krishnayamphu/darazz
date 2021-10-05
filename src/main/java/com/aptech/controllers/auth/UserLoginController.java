package com.aptech.controllers.auth;

import com.aptech.dao.AdminDao;
import com.aptech.dao.UserDao;
import com.aptech.models.Admin;
import com.aptech.models.User;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/signin")
public class UserLoginController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String msg="<div class='alert alert-danger'> Invalid username or password.</div>";
        String username=request.getParameter("username");
        String password= DigestUtils.sha256Hex(request.getParameter("password"));
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        if(UserDao.auth(user)){
            HttpSession session =request.getSession();
            session.setAttribute("user",username);
           response.sendRedirect("dashboard");
        }else {
            request.setAttribute("error",msg);
            request.getRequestDispatcher("/auth/user-login.jsp").include(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/auth/user-login.jsp").forward(request,response);
    }
}
