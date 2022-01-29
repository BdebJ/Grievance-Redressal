/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.redress.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.redress.models.User;
import com.redress.core.ConnectionManager;
import com.redress.models.Department;
import com.redress.models.Product;
import com.redress.models.Technician;

/**
 *
 * @author bjena
 */
public class Admin {
    
    public List<User> getAllCSR() throws SQLException, Exception {

        ResultSet rs = null;
        Connection con = null;

        List<User> csrList = new ArrayList<>();
        try {
            String sql = "SELECT pid,username,firstname,lastname,address,email,phno,userstatus FROM userinfo WHERE roleid=2";
            con = ConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                User csr = new User();
                csr.setPid(rs.getInt("pid"));
                csr.setUsername(rs.getString("username"));
                csr.setFirstname(rs.getString("firstname"));
                csr.setLastname(rs.getString("lastname"));
                csr.setAddress(rs.getString("address"));
                csr.setEmail(rs.getString("email"));
                csr.setPhno(rs.getString("phno"));
                csr.setUserstatus(rs.getInt("userstatus"));

                csrList.add(csr);
            }
            return csrList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (con != null) {
                con.close();
            }
        }

    }
    
    public int addUser(String username, String password, String firstname, String lastname, String address,
            String email, String phno) throws Exception {
        int i = 0;
        Connection con = null;
        try {
            con = ConnectionManager.getConnection();
            String sql = "INSERT INTO userinfo(username,password,firstname,lastname,address,email,phno,roleid,userstatus) VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, "1234");
            ps.setString(3, firstname);
            ps.setString(4, lastname);
            ps.setString(5, address);
            ps.setString(6, email);
            ps.setString(7, phno);
            ps.setInt(8, 3);
            ps.setInt(9, 0);
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

    public int addProduct(int deptid, String prodname, String prodmodel) throws Exception {
        int i = 0;
        Connection con = null;
        try {
            con = ConnectionManager.getConnection();
            String sql = "INSERT INTO product(deptid,prodmodel,prodname) VALUES(?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, deptid);
            ps.setString(2, prodmodel);
            ps.setString(3, prodname);
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

    public int addTechnician(int deptid, String techname)throws Exception  {
      int i = 0;
        Connection con = null;
        try {
            con = ConnectionManager.getConnection();
            String sql = "INSERT INTO technician(techname,deptid) VALUES(?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, techname);
            ps.setInt(2, deptid);
            
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

    public int addDepartment(String deptname)throws Exception {
        int i = 0;
        Connection con = null;
        try {
            con = ConnectionManager.getConnection();
            String sql = "INSERT INTO department(deptname) VALUES(?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, deptname);
         
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
    
    // Update Methods
    
    public int updateDepartment(int deptid, String deptname)throws Exception {
       int i = 0;
        Connection con = null;
        try {
            con = ConnectionManager.getConnection();
            String sql = "UPDATE department SET deptname = ? WHERE deptid = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, deptname);
            ps.setInt(2, deptid);
         
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

    public int updateTechnician(int techid,int deptid, String techname)throws Exception {
        int i = 0;
        Connection con = null;
        try {
            System.out.println("all etch"+ techname + techid);
            con = ConnectionManager.getConnection();
            String sql = "UPDATE technician SET techname = ?, deptid =? WHERE techid = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, techname);
         
            ps.setInt(2, deptid);
            ps.setInt(3, techid);
         
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

    public int updateProduct(int prodid, String prodname, int deptid, String prodmodel)throws Exception {
        
    int i = 0;
        Connection con = null;
        try {
//            System.out.println("all etch"+ techname + techid);
            con = ConnectionManager.getConnection();
            String sql = "UPDATE product SET prodname = ?, deptid =?, prodmodel =? WHERE prodid = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, prodname);
         
            ps.setInt(2, deptid);
            ps.setString(3, prodmodel);
            ps.setInt(4, prodid);
         
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

    public int updateUser(int pid, String username, String password, String firstname, String lastname, String address, String email, String phno) throws Exception {
    int i = 0;
        Connection con = null;
        try {
//            System.out.println("all etch"+ techname + techid);
            con = ConnectionManager.getConnection();
            String sql = "UPDATE userinfo SET password = ? , firstname =? , lastname = ?, address =?, email =?, phno =? WHERE pid = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, password);
         
            ps.setString(2, firstname);
            ps.setString(3, lastname);
            ps.setString(4, address);
            ps.setString(5, email);
            ps.setString(6, phno);
            
            ps.setInt(7, pid);
         
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
    
    public int deleteUserDetails(int pid) throws SQLException, Exception {
        Connection con = ConnectionManager.getConnection();
        int i = 0;
        try {
            String sql = "UPDATE userinfo SET userstatus=2 WHERE pid=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, pid);
            i = ps.executeUpdate();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            if (con != null) {
                con.rollback();
                con.close();
            }
        }
    }
    
    public int deleteDeptDetails(int deptid) throws SQLException, Exception {
        Connection con = ConnectionManager.getConnection();
        int i = 0;
        try {
            String sql = "UPDATE department SET deptstatus=0 WHERE deptid=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, deptid);
            i = ps.executeUpdate();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            if (con != null) {
                con.rollback();
                con.close();
            }
        }
    }
    
    public int deleteTechDetails(int techid) throws SQLException, Exception {
        Connection con = ConnectionManager.getConnection();
        int i = 0;
        try {
            String sql = "UPDATE technician SET techstatus=0 WHERE techid=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, techid);
            i = ps.executeUpdate();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            if (con != null) {
                con.rollback();
                con.close();
            }
        }
    }
    
    public int deleteProdDetails(int prodid) throws SQLException, Exception {
        Connection con = ConnectionManager.getConnection();
        int i = 0;
        try {
            String sql = "UPDATE product SET prodstatus=0 WHERE prodid=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, prodid);
            i = ps.executeUpdate();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            if (con != null) {
                con.rollback();
                con.close();
            }
        }
    }
   
}
