package com.aptech.controllers.admin.category;

import com.aptech.dao.AdminDao;
import com.aptech.dao.CategoryDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/category-del")
public class CategoryDelController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        if(CategoryDao.delCategory(id)){
            response.sendRedirect("category");
        }else{
            String msg = "<div class='alert alert-danger'> Error occur while deleting category</div>";
            request.setAttribute("err", msg);
            request.getRequestDispatcher("/category/index.jsp").include(request,response);
        }
    }
}
