package com.aptech;

import com.aptech.controllers.admin.product.ProductAddController;
import com.aptech.dao.ProductDao;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.RegexFileFilter;

import java.io.File;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
//        String sha256hex = DigestUtils.sha256Hex("hello");
//        LocalDate today = LocalDate.now();
//        int month = today.getMonthValue();
//        int year = today.getYear();
//        File path = new File("/uploads/"+year+"/"+month);
//
//        File pa = new File(path+"/");
//        if (!path.exists()) {
//            path.mkdirs();
//            System.out.println("success" + path);
//        } else {
//            System.out.println("already exist." + path);
//        }

        List<String> categories= ProductDao.getCategoryByProductId(1);
        for(String s:categories)
            System.out.println(s);
    }
}
