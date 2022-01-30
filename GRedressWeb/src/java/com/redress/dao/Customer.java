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

    public List<Complaint> complaintListbyPid(int pid) throws SQLException, Exception {
        ResultSet rs = null;
        Connection con = null;
        List<Complaint> complaintList = new ArrayList<>();

        try {

            con = ConnectionManager.getConnection();
            String sql = "SELECT c.complid,ui.firstname,ui.lastname,c.compltime,p.prodmodel,"
                    + "p.prodname,c.subject,c.description, c.compl_status,t.techid,t.techname, "
                    + "c.startprog, c.ongoingprog,c.endprog, c.res_status FROM complaint c "
                    + "LEFT JOIN userinfo ui ON c.pid = ui.pid "
                    + "LEFT JOIN technician t ON c.techid = t.techid "
                    + "LEFT JOIN productowned po ON c.ownid = po.ownid "
                    + "LEFT JOIN product p ON c.ownid = p.prodid WHERE c.pid = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, pid);
            rs = ps.executeQuery();

            while (rs.next()) {
                Complaint complaint = new Complaint();

                complaint.setComplid(rs.getInt("complid"));
                complaint.setFirstname(rs.getString("firstname"));
                complaint.setLastname(rs.getString("lastname"));
                complaint.setCompltime(rs.getString("compltime"));
                complaint.setProdmodel(rs.getString("prodmodel"));
                complaint.setProdname(rs.getString("prodname"));
                complaint.setSubject(rs.getString("subject"));
                complaint.setDescription(rs.getString("description"));
                complaint.setTechid(rs.getInt("techid"));
                complaint.setTechname(rs.getString("techname"));
                complaint.setCompl_status(rs.getInt("compl_status"));
                complaint.setStartprog(rs.getString("startprog"));
                complaint.setOngoingprog(rs.getString("ongoingprog"));
                complaint.setEndprog(rs.getString("endprog"));
                complaint.setRes_status(rs.getInt("res_status"));

// System.out.println("pid" + rs.getInt("pid"));
                complaintList.add(complaint);

            }
            System.out.println("Total number of customers = " + complaintList.size());

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return complaintList;
    }
    
    public List<Complaint> activeComplaintListbyPid(int pid) throws SQLException, Exception {
        ResultSet rs = null;
        Connection con = null;
        List<Complaint> complaintList = new ArrayList<>();

        try {

            con = ConnectionManager.getConnection();
            String sql = "SELECT c.complid,ui.firstname,ui.lastname,c.compltime,p.prodmodel,"
                    + "p.prodname,c.subject,c.description, c.compl_status,t.techid,t.techname, "
                    + "c.startprog, c.ongoingprog,c.endprog, c.res_status FROM complaint c "
                    + "LEFT JOIN userinfo ui ON c.pid = ui.pid "
                    + "LEFT JOIN technician t ON c.techid = t.techid "
                    + "LEFT JOIN productowned po ON c.ownid = po.ownid "
                    + "LEFT JOIN product p ON c.ownid = p.prodid WHERE c.pid = ? AND c.compl_status = 1";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, pid);
            rs = ps.executeQuery();

            while (rs.next()) {
                Complaint complaint = new Complaint();

                complaint.setComplid(rs.getInt("complid"));
                complaint.setFirstname(rs.getString("firstname"));
                complaint.setLastname(rs.getString("lastname"));
                complaint.setCompltime(rs.getString("compltime"));
                complaint.setProdmodel(rs.getString("prodmodel"));
                complaint.setProdname(rs.getString("prodname"));
                complaint.setSubject(rs.getString("subject"));
                complaint.setDescription(rs.getString("description"));
                complaint.setTechid(rs.getInt("techid"));
                complaint.setTechname(rs.getString("techname"));
                complaint.setCompl_status(rs.getInt("compl_status"));
                complaint.setStartprog(rs.getString("startprog"));
                complaint.setOngoingprog(rs.getString("ongoingprog"));
                complaint.setEndprog(rs.getString("endprog"));
                complaint.setRes_status(rs.getInt("res_status"));

// System.out.println("pid" + rs.getInt("pid"));
                complaintList.add(complaint);

            }
            System.out.println("Total number of customers = " + complaintList.size());

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return complaintList;
    }
    
    public List<Complaint> rejectedComplaintListbyPid(int pid) throws SQLException, Exception {
        ResultSet rs = null;
        Connection con = null;
        List<Complaint> complaintList = new ArrayList<>();

        try {

            con = ConnectionManager.getConnection();
            String sql = "SELECT c.complid,ui.firstname,ui.lastname,c.compltime,p.prodmodel,"
                    + "p.prodname,c.subject,c.description, c.compl_status,t.techid,t.techname, "
                    + "c.startprog, c.ongoingprog,c.endprog, c.res_status FROM complaint c "
                    + "LEFT JOIN userinfo ui ON c.pid = ui.pid "
                    + "LEFT JOIN technician t ON c.techid = t.techid "
                    + "LEFT JOIN productowned po ON c.ownid = po.ownid "
                    + "LEFT JOIN product p ON c.ownid = p.prodid WHERE c.pid = ? AND c.compl_status = 0";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, pid);
            rs = ps.executeQuery();

            while (rs.next()) {
                Complaint complaint = new Complaint();

                complaint.setComplid(rs.getInt("complid"));
                complaint.setFirstname(rs.getString("firstname"));
                complaint.setLastname(rs.getString("lastname"));
                complaint.setCompltime(rs.getString("compltime"));
                complaint.setProdmodel(rs.getString("prodmodel"));
                complaint.setProdname(rs.getString("prodname"));
                complaint.setSubject(rs.getString("subject"));
                complaint.setDescription(rs.getString("description"));
                complaint.setTechid(rs.getInt("techid"));
                complaint.setTechname(rs.getString("techname"));
                complaint.setCompl_status(rs.getInt("compl_status"));
                complaint.setStartprog(rs.getString("startprog"));
                complaint.setOngoingprog(rs.getString("ongoingprog"));
                complaint.setEndprog(rs.getString("endprog"));
                complaint.setRes_status(rs.getInt("res_status"));

// System.out.println("pid" + rs.getInt("pid"));
                complaintList.add(complaint);

            }
            System.out.println("Total number of customers = " + complaintList.size());

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return complaintList;
    }
    
    public List<Complaint> resolvedComplaintListbyPid(int pid) throws SQLException, Exception {
        ResultSet rs = null;
        Connection con = null;
        List<Complaint> complaintList = new ArrayList<>();

        try {

            con = ConnectionManager.getConnection();
            String sql = "SELECT c.complid,ui.firstname,ui.lastname,c.compltime,p.prodmodel,"
                    + "p.prodname,c.subject,c.description, c.compl_status,t.techid,t.techname, "
                    + "c.startprog, c.ongoingprog,c.endprog, c.res_status FROM complaint c "
                    + "LEFT JOIN userinfo ui ON c.pid = ui.pid "
                    + "LEFT JOIN technician t ON c.techid = t.techid "
                    + "LEFT JOIN productowned po ON c.ownid = po.ownid "
                    + "LEFT JOIN product p ON c.ownid = p.prodid WHERE c.pid = ? AND c.res_status = 1";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, pid);
            rs = ps.executeQuery();

            while (rs.next()) {
                Complaint complaint = new Complaint();

                complaint.setComplid(rs.getInt("complid"));
                complaint.setFirstname(rs.getString("firstname"));
                complaint.setLastname(rs.getString("lastname"));
                complaint.setCompltime(rs.getString("compltime"));
                complaint.setProdmodel(rs.getString("prodmodel"));
                complaint.setProdname(rs.getString("prodname"));
                complaint.setSubject(rs.getString("subject"));
                complaint.setDescription(rs.getString("description"));
                complaint.setTechid(rs.getInt("techid"));
                complaint.setTechname(rs.getString("techname"));
                complaint.setCompl_status(rs.getInt("compl_status"));
                complaint.setStartprog(rs.getString("startprog"));
                complaint.setOngoingprog(rs.getString("ongoingprog"));
                complaint.setEndprog(rs.getString("endprog"));
                complaint.setRes_status(rs.getInt("res_status"));

// System.out.println("pid" + rs.getInt("pid"));
                complaintList.add(complaint);

            }
            System.out.println("Total number of customers = " + complaintList.size());

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return complaintList;
    }

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

    public int ComplaintRegister(String compltime, String subject, String description, int pid, int ownid)
            throws Exception {
        int i = 0;
        Connection con = null;
        try {
            con = ConnectionManager.getConnection();
            String sql = "INSERT INTO complaint(compltime,subject,description,pid,ownid) VALUES (?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, compltime);
            ps.setString(2, subject);
            ps.setString(3, description);
            ps.setInt(4, pid);
            ps.setInt(5, ownid);

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

            String sql = "INSERT INTO feedback(feedback,rating) VALUES(?,?);";
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

    public List showcomplaints(int pid) throws SQLException, Exception {
        ResultSet rs = null;
        Connection con = null;
        List<Complaint> complaintList = new ArrayList<>();
        try {
            String sql = "SELECT complid,compltime,subject,description,pid,techid,compl_status,startprog,ongoingprog,endprog,res_status FROM complaint WHERE pid = ?";
            con = ConnectionManager.getConnection();
            System.out.println("Connection is " + con);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, pid);
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

    public int closeComplaintDetails(int complid) throws SQLException, Exception {
        Connection con = ConnectionManager.getConnection();
        int i = 0;

        try {
            String sql = "UPDATE complaint SET res_status = 1 WHERE complid = ?";
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

    public List productOwn(int pid) throws SQLException, Exception {
        ResultSet rs = null;
        Connection con = null;
        List<Product> ProductOwnedList = new ArrayList<>();
        try {
            String sql = "SELECT prodname,prodmodel FROM productowned,product WHERE pid=? AND productowned.prodid=product.prodid;";
            con = ConnectionManager.getConnection();
            System.out.println("Connection is " + con);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, pid);
            rs = ps.executeQuery();

            while (rs.next()) {
                Product productowned = new Product();
                productowned.setProdname(rs.getString("prodname"));
                productowned.setProdmodel(rs.getString("prodmodel"));

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
