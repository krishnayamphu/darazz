package com.aptech.controllers.admin;

import com.aptech.dao.AdminDao;
import com.aptech.models.Admin;
import org.apache.commons.codec.digest.DigestUtils;

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
            Admin admin=new Admin();
            admin.setFirstname(request.getParameter("fname"));
            admin.setLastname(request.getParameter("lname"));
            admin.setGender(request.getParameter("gender"));
            admin.setUsername(request.getParameter("username"));
            admin.setEmail(request.getParameter("email"));
            admin.setContact(request.getParameter("contact"));
            admin.setPassword(DigestUtils.sha256Hex(pass));
            admin.setAddress(request.getParameter("address"));
            admin.setActive(1);
            if(AdminDao.addUser(admin)){
                response.sendRedirect("users");
                System.out.println("data inserted");
            }else {
                String msg = "<div class='alert alert-danger'>Error while adding new user</div>";
                request.setAttribute("errUser", msg);
                request.getRequestDispatcher("/admin/signup.jsp").include(request, response);
            }
        } else {
            String msg = "<div class='alert alert-danger'> password do not match</div>";
            request.setAttribute("err", msg);
            request.getRequestDispatcher("/admin/signup.jsp").include(request, response);
        }

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/admin/signup.jsp").forward(request, response);
    }
}
