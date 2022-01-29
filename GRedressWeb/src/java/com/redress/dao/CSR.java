/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.redress.dao;

import com.redress.core.ConnectionManager;
import com.redress.models.Complaint;
import com.redress.models.CustomerDefect;
import com.redress.models.Department;
import com.redress.models.Technician;
import com.redress.models.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bjena
 */
public class CSR {

    public List<User> getAllCustomers() throws SQLException, Exception {

        ResultSet rs = null;
        Connection con = null;

        List<User> customerList = new ArrayList<>();
        try {
            String sql = "SELECT pid,username,firstname,lastname,address,email,phno,userstatus FROM userinfo WHERE roleid=3";
            con = ConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                User customer = new User();
                customer.setPid(rs.getInt("pid"));
                customer.setUsername(rs.getString("username"));
                customer.setFirstname(rs.getString("firstname"));
                customer.setLastname(rs.getString("lastname"));
                customer.setAddress(rs.getString("address"));
                customer.setEmail(rs.getString("email"));
                customer.setPhno(rs.getString("phno"));
                customer.setUserstatus(rs.getInt("userstatus"));

                customerList.add(customer);
            }
            return customerList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (con != null) {
                con.close();
            }
        }

    }
    
    public int rejectComplaintDetails(int complid) throws SQLException, Exception {
        Connection con = ConnectionManager.getConnection();
        int i = 0;

        try {
            String sql = "UPDATE complaint SET compl_status=2 WHERE complid=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, complid);
            i = ps.executeUpdate();
            System.out.println("rows updated "+i);
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

    public List<Department> departmentList() throws SQLException, Exception {

        ResultSet rs = null;
        Connection con = null;
        List<Department> departmentList = new ArrayList<>();

        try {

            con = ConnectionManager.getConnection();
            String sql = "SELECT * FROM department";
            PreparedStatement ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Department department = new Department();

                department.setDeptid(rs.getInt("deptid"));
                department.setDeptname(rs.getString("deptname"));

                departmentList.add(department);

            }
            System.out.println("Total number of customers = " + departmentList.size());

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return departmentList;
    }

    public List<Complaint> complaintList() throws SQLException, Exception {
        ResultSet rs = null;
        Connection con = null;
        List<Complaint> complaintList = new ArrayList<>();

        try {

            con = ConnectionManager.getConnection();
            String sql = "SELECT * FROM complaint";
            PreparedStatement ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
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
                complaint.setPid(rs.getInt("res_status"));
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
    }  //To change body of generated methods, choose Tools | Templates.

    
    public List<CustomerDefect> customerDefect() throws SQLException, Exception {
        ResultSet rs = null;
        Connection con = null;
        List<CustomerDefect> customerdefect = new ArrayList<>();

        try {

            con = ConnectionManager.getConnection();
            String sql = "SELECT * FROM customerdefects";
            PreparedStatement ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                CustomerDefect defect = new CustomerDefect();

                defect.setCusdefid(rs.getInt("cusdefid"));
                defect.setOwnid(rs.getInt("ownid"));
                defect.setCus_def(rs.getString("cus_def"));

                customerdefect.add(defect);

            }
            System.out.println("Total number of customers = " + customerdefect.size());

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return customerdefect;
    } //To change body of generated methods, choose Tools | Templates.

    public Complaint fetchComplaintDetails(int complid) throws SQLException {
        ResultSet rs = null;
        Connection con = null;
        Complaint complaint = new Complaint();
        try {
            con = ConnectionManager.getConnection();
            String sql = "SELECT complid,compltime,subject,description,pid,techid,compl_status,startprog,ongoingprog,endprog,res_status\n"
                    + "FROM complaint where complid=?";
            PreparedStatement ps = con.prepareStatement(sql);
            System.out.println("ComplaintId = " + complid);
            ps.setInt(1, complid);
            System.out.println("Select SQL = " + ps);

            rs = ps.executeQuery();
            if (rs.next()) {

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
            }
            return complaint;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (con != null) {
                con.close();
            }
        } //To change body of generated methods, choose Tools | Templates.
    }

    public int updateComplaintDetails(int complid, String compltime, String subject, String description, int pid, int techid, int compl_status, String startprog, String ongoingprog, String endprog, int res_status) throws SQLException, Exception {
        Connection con = ConnectionManager.getConnection();
        int i = 0;
        try {
            String sql = "UPDATE complaint SET  compltime = ?, subject = ?, description =  ?,pid = ?,\n"
                    + "techid = ?, compl_status = ?, startprog = ?, ongoingprog = ?, endprog = ?, res_status = ?\n"
                    + "WHERE complid = ?;";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, compltime);
            ps.setString(2, subject);
            ps.setString(3, description);
            ps.setInt(4, pid);
            ps.setInt(5, techid);
            ps.setInt(6, compl_status);
            ps.setString(7, startprog);
            ps.setString(8, ongoingprog);
            ps.setString(9, endprog);
            ps.setInt(10, res_status);
            ps.setInt(11, complid);
            System.out.println("Select SQL = " + ps);
            i = ps.executeUpdate();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            if (con != null) {
                con.close();
            }
        }    //To change body of generated methods, choose Tools | Templates.
    }

    public List<Technician> fetchTechnician(int deptid) throws SQLException {
        ResultSet rs = null;
        Connection con = null;
        List<Technician> techList = new  ArrayList<>();
        
        try {
            con = ConnectionManager.getConnection();
            String sql = "SELECT techid,techname FROM technician where deptid = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, deptid);
            System.out.println("DepartmentId = " + deptid);        
            System.out.println("Select SQL = " + ps);

            rs = ps.executeQuery();
            while(rs.next()) {
                Technician technician = new Technician();
                technician.setTechid(rs.getInt("techid"));
                technician.setTechname(rs.getString("techname"));
                techList.add(technician);
            }
            return techList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (con != null) {
                con.close();
            }
        }//To change body of generated methods, choose Tools | Templates.
    }

}
