package com.aptech.controllers.admin.category;

import com.aptech.dao.CategoryDao;
import com.aptech.models.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/category-add")
public class CategoryAddController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("name");
        String desc=request.getParameter("desc");

        Category category=new Category(name,desc);
        if(CategoryDao.addCategory(category)){
            response.sendRedirect("category");
        }else{
            String msg = "<div class='alert alert-danger'>Error while adding new category</div>";
            request.setAttribute("err", msg);
            request.getRequestDispatcher("category/signup.jsp").include(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("category/signup.jsp").forward(request,response);
    }
}
