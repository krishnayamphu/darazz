package com.aptech.controllers.admin.media;

import com.aptech.dao.CategoryDao;
import com.aptech.helpers.MediaFiles;
import com.aptech.models.Category;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.RegexFileFilter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@WebServlet("/admin/media")
public class MediaController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();

        /** Check that we have a file upload request */
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (isMultipart) {
            /** Create a factory for disk-based file items */
            DiskFileItemFactory factory = new DiskFileItemFactory();

            /** Configure a repository (to ensure a secure temp location is used) */
            ServletContext servletContext = this.getServletConfig().getServletContext();
            File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
            factory.setRepository(repository);

            /** Create a new file upload handler */
            ServletFileUpload upload = new ServletFileUpload(factory);

            /** Parse the request */
            List<FileItem> items = null;
            try {
                items = upload.parseRequest(request);

                /** Process the uploaded items */
                Iterator<FileItem> iter = items.iterator();
                while (iter.hasNext()) {
                    FileItem item = iter.next();
                    if (item.isFormField()) {
                        //processFormField(item);
                    } else {
                        String root = getServletContext().getRealPath("/");
                        MediaFiles.processUploadedFile(item,new File(root));
                    }
                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            }
        } else {
            //no file upload request made.
        }
        response.sendRedirect("media");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String root = getServletContext().getRealPath("/");
        File path = new File(root + "/uploads");
        if(path.exists()){
            List<File> files = MediaFiles.getMediaFiles(path);
            request.setAttribute("files",files);
        }
        request.getRequestDispatcher("media/index.jsp").forward(request,response);
    }
}
