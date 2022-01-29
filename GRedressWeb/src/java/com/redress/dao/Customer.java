/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.redress.dao;

import com.redress.core.ConnectionManager;
import com.redress.models.Complaint;
import com.redress.models.CustomerDefect;
import com.redress.models.Product;
import com.redress.models.ProductOwned;
import com.redress.models.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Customer {

    public List report(int pid) throws SQLException, Exception {
        ResultSet rs = null;
        Connection con = null;
        List<User> userList = new ArrayList<>();
        try {
            String sql = "SELECT pid, username, firstname, lastname, address, email, phno  FROM userinfo WHERE pid=?";
            con = ConnectionManager.getConnection();
            System.out.println("Connection is " + con);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, pid);
            rs = ps.executeQuery();
            while (rs.next()) {

                User user = new User();
                user.setPid(rs.getInt("pid"));
                user.setUsername(rs.getString("username"));
                user.setFirstname(rs.getString("firstname"));
                user.setLastname(rs.getString("lastname"));
                user.setAddress(rs.getString("address"));
                user.setEmail(rs.getString("email"));
                user.setPhno(rs.getString("phno"));

                userList.add(user);
            }
            return userList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    public ProductOwned fetchUserDetails(String pid) throws SQLException, Exception {
        ResultSet rs = null;
        Connection con = null;
        ProductOwned productowned = new ProductOwned();
        try {
            con = ConnectionManager.getConnection();
            String sql = "SELECT ownid, prodid users WHERE pid=?";
            PreparedStatement ps = con.prepareStatement(sql);
            System.out.println("pid = " + pid);
            ps.setString(1, pid);
            System.out.println("Select SQL = " + ps);

            rs = ps.executeQuery();
            if (rs.next()) {

                productowned.setOwnid(rs.getInt("ownid"));
                productowned.setProdid(rs.getInt("prodid"));
            }
            return productowned;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    public int ComplaintRegister(int complid, String compltime, String subject, String description,
            int pid, int techid, int Compl_status, String startprog, String ongoingprog, String endprog, int res_status)
            throws Exception {
        int i = 0;
        Connection con = null;
        try {
            con = ConnectionManager.getConnection();
            System.out.println("Into dao");
            String sql = "INSERT INTO complaint VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, complid);
            ps.setString(2, compltime);
            ps.setString(3, subject);
            ps.setString(4, description);
            ps.setInt(5, pid);
            ps.setInt(6, techid);
            ps.setInt(7, Compl_status);
            ps.setString(8, startprog);
            ps.setString(9, ongoingprog);
            ps.setString(10, endprog);
            ps.setInt(11, res_status);

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

    public int FeedbackRegister(String feedback, int rating) throws SQLException {
        int i = 0;
        Connection con = null;
        try {
            con = ConnectionManager.getConnection();

            String sql = "INSERT INTO feedback (feedback,rating)VALUES(?,?);";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, feedback);
            ps.setInt(2, rating);

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

    public List showcomplaints() throws SQLException, Exception {
        ResultSet rs = null;
        Connection con = null;
        List<Complaint> complaintList = new ArrayList<>();
        try {
            String sql = "SELECT complid,compltime,subject,description,pid,techid,compl_status,startprog,ongoingprog,endprog,res_status FROM complaint WHERE pid=3";
            con = ConnectionManager.getConnection();
            System.out.println("Connection is " + con);
            PreparedStatement ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("In showcomplaints");
                Complaint complaint = new Complaint();
                complaint.setComplid(rs.getInt("complid"));
                complaint.setCompltime(rs.getString("compltime"));
                complaint.setSubject(rs.getString("subject"));
                complaint.setDescription(rs.getString("description"));
                complaint.setPid(rs.getInt("pid"));
                complaint.setTechid(rs.getInt("techid"));
                complaint.setCompl_status(rs.getInt("compl_status"));
                complaint.setStartprog(rs.getString("startprog"));
                complaint.setOngoingprog(rs.getString("ongoingprog"));
                complaint.setEndprog(rs.getString("endprog"));
                complaint.setRes_status(rs.getInt("res_status"));

                complaintList.add(complaint);
            }
            return complaintList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    public int deleteComplaintDetails(int complid) throws SQLException, Exception {
        Connection con = ConnectionManager.getConnection();
        int i = 0;

        try {
            String sql = "UPDATE complaint SET compl_status = 0 WHERE complid = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, complid);
            i = ps.executeUpdate();
            System.out.println(i);
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    public List productOwn() throws SQLException, Exception {
        ResultSet rs = null;
        Connection con = null;
        List<ProductOwned> ProductOwnedList = new ArrayList<>();
        try {
            String sql = "SELECT ownid, pid,prodid FROM productowned";
            con = ConnectionManager.getConnection();
            System.out.println("Connection is " + con);
            PreparedStatement ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                ProductOwned productowned = new ProductOwned();
                productowned.setOwnid(rs.getInt("ownid"));
                productowned.setPid(rs.getInt("pid"));
                productowned.setProdid(rs.getInt("prodid"));

                ProductOwnedList.add(productowned);
            }
            return ProductOwnedList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    public List viewProduct() throws SQLException, Exception {

        ResultSet rs = null;
        Connection con = null;
        List<Product> productList = new ArrayList<>();
        try {

            String sql = "SELECT prodid,deptid,prodmodel,prodname FROM product WHERE prodid=2";
            con = ConnectionManager.getConnection();
            System.out.println("Connection is " + con);
            PreparedStatement ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("Products");
                Product product = new Product();

                product.setProdid(rs.getInt("prodid"));
                product.setDeptid(rs.getInt("deptid"));
                product.setProdmodel(rs.getString("prodmodel"));
                product.setProdname(rs.getString("prodname"));

                productList.add(product);
            }
            return productList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    public List viewDefect() throws SQLException, Exception {

        ResultSet rs = null;
        Connection con = null;
        List<CustomerDefect> CustomerDefectList = new ArrayList<>();
        try {

            String sql = "SELECT cusdefid,ownid,cus_def FROM customerdefects";
            con = ConnectionManager.getConnection();
            System.out.println("Connection is " + con);
            PreparedStatement ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                CustomerDefect customerdefect = new CustomerDefect();
                customerdefect.setCus_def(rs.getString("cus_def"));
                customerdefect.setCusdefid(rs.getInt("cusdefid"));
                customerdefect.setOwnid(rs.getInt("ownid"));

                CustomerDefectList.add(customerdefect);
            }
            return CustomerDefectList;
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
