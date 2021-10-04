package com.aptech;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.RegexFileFilter;

import java.io.File;
import java.time.LocalDate;
import java.util.Collection;

public class MainApp {
    public static void main(String[] args) {
        String sha256hex = DigestUtils.sha256Hex("hello");
        LocalDate today = LocalDate.now();
        int month = today.getMonthValue();
        int year = today.getYear();
        File path = new File("/uploads/"+year+"/"+month);

        File pa = new File(path+"/");
        if (!path.exists()) {
            path.mkdirs();
            System.out.println("success" + path);
        } else {
            System.out.println("already exist." + path);
        }

        Collection files = FileUtils.listFiles(
                pa,
                new RegexFileFilter("^(.*?)"),
                DirectoryFileFilter.DIRECTORY
        );
        for (Object s:files) {
            System.out.println(s);
        }
    }
}
