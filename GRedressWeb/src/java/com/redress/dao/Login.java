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

    public String getPasswordHash(String username) throws SQLException, Exception {
        ResultSet rs = null;
        Connection con = null;
        String hash = null;
        try {
            con = ConnectionManager.getConnection();
            String sql = "SELECT password FROM userinfo WHERE username=?";
            PreparedStatement ps = con.prepareStatement(sql);
            System.out.println("userName = " + username);
            ps.setString(1, username);
            System.out.println("Select SQL = " + ps);

            rs = ps.executeQuery();
            if (rs.next()) {
                
                hash = rs.getString("password");
                System.out.println("Password hash:" + hash);
               
            }
            return hash;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }
    
    public User validLoginCredential(String username) throws SQLException, Exception {
        ResultSet rs = null;
        Connection con = null;
        User user = new User();
        user.setValidUser(false);
        try {
            con = ConnectionManager.getConnection();
            String sql = "SELECT pid,username,password,firstname,lastname,address,email,phno,roleid,userstatus FROM userinfo WHERE username=?";
            PreparedStatement ps = con.prepareStatement(sql);
            System.out.println("userName = " + username);
            ps.setString(1, username);
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

    public int changePassword(String password,int pid)throws Exception {
        int i = 0;
        Connection con = null;
        try {
//            System.out.println("all etch"+ techname + techid);
            con = ConnectionManager.getConnection();
            String sql = "UPDATE userinfo SET password =?,userstatus = 1 WHERE pid = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, password);
            ps.setInt(2, pid);
             System.out.println("SQL for insert=" + ps);
            i = ps.executeUpdate();
            return i;
             } catch (Exception e) {
            e.printStackTrace();
            return i;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }
}
