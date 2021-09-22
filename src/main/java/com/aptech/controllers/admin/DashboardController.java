package com.aptech.controllers.admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/admin/dashboard")
public class DashboardController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession(true);
        String user=(String)session.getAttribute("admin");
        request.setAttribute("user",user);
        request.getRequestDispatcher("/admin/dashboard.jsp").forward(request,response);
    }
}
