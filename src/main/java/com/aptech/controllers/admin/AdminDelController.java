package com.aptech.controllers.admin;

import com.aptech.dao.AdminDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/admin-del")
public class AdminDelController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        if(AdminDao.delUser(id)){
            response.sendRedirect("users");
        }else{
            String msg = "<div class='alert alert-danger'> Error occur while deleting user</div>";
            request.setAttribute("err", msg);
            request.getRequestDispatcher("/admin/profile.jsp").include(request,response);
        }
    }
}
