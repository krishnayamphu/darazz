package com.aptech.controllers.admin.category;

import com.aptech.dao.CategoryDao;
import com.aptech.models.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/category-edit")
public class CategoryEditController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String desc = request.getParameter("desc");

        Category category = new Category();
        category.setId(id);
        category.setName(name);
        category.setDescription(desc);
        if (CategoryDao.updateCategory(category)) {
            response.sendRedirect("category");
        } else {
            String msg = "<div class='alert alert-danger'>Error while updating category</div>";
            request.setAttribute("err", msg);
            request.getRequestDispatcher("category/signup.jsp").include(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Category category = CategoryDao.getCategoryById(id);
        request.setAttribute("category", category);
        request.getRequestDispatcher("category/show.jsp").forward(request, response);
    }
}
