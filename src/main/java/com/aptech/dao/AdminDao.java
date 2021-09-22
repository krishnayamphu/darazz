package com.aptech.dao;

import com.aptech.helpers.ConnectDB;
import com.aptech.models.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDao {
    public static boolean auth(Admin admin){
        boolean status=false;
        try {
            Connection con= ConnectDB.connect();
            String sql="SELECT username,password FROM admins WHERE username=? AND password=? AND active=1";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,admin.getUsername());
            ps.setString(2,admin.getPassword());
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                status=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public static List<Admin> getAllUsers(){
        List<Admin> users=new ArrayList<>();
        try {
            Connection con=ConnectDB.connect();
            String sql="SELECT * FROM admins WHERE active=1";
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                Admin admin=new Admin();
                admin.setId(rs.getInt("id"));
                admin.setFirstname(rs.getString("fname"));
                admin.setLastname(rs.getString("lname"));
                admin.setAddress(rs.getString("address"));
                admin.setEmail(rs.getString("email"));
                admin.setContact(rs.getString("contact"));
                admin.setCreatedAt(rs.getString("created_at"));

                users.add(admin);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
