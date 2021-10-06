package com.aptech.controllers.admin;

import com.aptech.dao.AdminDao;
import com.aptech.models.Admin;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/admin/users")
public class AdminUserController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Admin> users= AdminDao.getAllUsers();
        request.setAttribute("users",users);
        ServletContext context=getServletContext();
        String url=context.getInitParameter("homeUrl");
        PrintWriter pw=response.getWriter();
//        pw.println(url);
        request.getRequestDispatcher("/admin/profile.jsp").forward(request,response);
    }
}
