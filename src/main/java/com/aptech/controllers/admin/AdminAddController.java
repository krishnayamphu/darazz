package com.aptech.controllers.admin;

import com.aptech.dao.AdminDao;
import com.aptech.models.Admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/admin/admin-add")
public class AdminAddController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter pw = response.getWriter();
        String pass = request.getParameter("password");
        String cpass = request.getParameter("cpassword");
        if (pass.equals(cpass)) {
            pw.println("ok");
        } else {
            String msg = "<div class='alert alert-danger'> password do not match</div>";
            request.setAttribute("err", msg);
            request.getRequestDispatcher("/admin/add.jsp").include(request, response);
        }

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/admin/add.jsp").forward(request, response);
    }
}
