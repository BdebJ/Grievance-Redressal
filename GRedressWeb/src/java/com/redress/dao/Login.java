/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.redress.dao;

import com.redress.core.ConnectionManager;
import com.redress.models.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author PALLAB
 */
public class Login {

    public User validLoginCredential(String username, String password) throws SQLException, Exception {
        ResultSet rs = null;
        Connection con = null;
        User user = new User();
        user.setValidUser(false);
        try {
            con = ConnectionManager.getConnection();
            String sql = "SELECT pid,username,password,firstname,lastname,address,email,phno,roleid,userstatus FROM userinfo WHERE username=? and password = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            System.out.println("userName = " + username);
            ps.setString(1, username);
            ps.setString(2, password);
            System.out.println("Select SQL = " + ps);

            rs = ps.executeQuery();
            if (rs.next()) {
                
                user.setPid(rs.getInt("pid"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setFirstname(rs.getString("firstname"));
                user.setLastname(rs.getString("lastname"));
                user.setAddress(rs.getString("address"));
                user.setEmail(rs.getString("email"));
                user.setPhno(rs.getString("phno"));
                user.setRoleid(rs.getInt("roleid"));
                user.setUserstatus(rs.getInt("userstatus"));
//                user.setRole(rs.getString("role"));
                user.setValidUser(true);
                System.out.println("Username"+user.getUsername());
                System.out.println(user.getPhno());

                
            }
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }
    
}
