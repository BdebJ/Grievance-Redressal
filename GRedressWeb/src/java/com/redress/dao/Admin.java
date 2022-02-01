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

    public int addCustomers(String username, String password, String firstname, String lastname, String address,
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

    public int addCSR(String username, String password, String firstname, String lastname, String address,
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
            ps.setInt(8, 2);
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

    public int addTechnician(int deptid, String techname) throws Exception {
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

    public int addDepartment(String deptname) throws Exception {
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
    public int updateDepartment(int deptid, String deptname) throws Exception {
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

    public int updateTechnician(int techid, int deptid, String techname, int techstatus) throws Exception {
        int i = 0;
        Connection con = null;
        try {
            System.out.println("all etch" + techname + techid);
            con = ConnectionManager.getConnection();
            String sql = "UPDATE technician SET techname = ?, deptid =? , techstatus = ? WHERE techid = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, techname);

            ps.setInt(2, deptid);
            ps.setInt(3, techstatus);
            ps.setInt(4, techid);

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

    public int updateProduct(int prodid, String prodname, int deptid, String prodmodel, int prodstatus) throws Exception {

        int i = 0;
        Connection con = null;
        try {
//            System.out.println("all etch"+ techname + techid);
            con = ConnectionManager.getConnection();
            String sql = "UPDATE product SET prodname = ?, deptid =?, prodmodel =?,prodstatus = ? WHERE prodid = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, prodname);

            ps.setInt(2, deptid);
            ps.setString(3, prodmodel);
            ps.setInt(4, prodstatus);
            ps.setInt(5, prodid);
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

    public int updateUser(int pid, String username, String password, String firstname, String lastname, String address, String email, String phno, int userstatus) throws Exception {
        int i = 0;
        Connection con = null;
        try {
//            System.out.println("all etch"+ techname + techid);
            con = ConnectionManager.getConnection();
            String sql = "UPDATE userinfo SET firstname =? , lastname = ?, address =?, email =?, phno =?, userstatus = ? WHERE pid = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, firstname);
            ps.setString(2, lastname);
            ps.setString(3, address);
            ps.setString(4, email);
            ps.setString(5, phno);
            ps.setInt(6, userstatus);
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

    public List getAllCustomers() throws SQLException, Exception {
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

    public List getActiveCustomers() throws SQLException, Exception {
        ResultSet rs = null;
        Connection con = null;

        List<User> customerList = new ArrayList<>();
        try {
            String sql = "SELECT pid,username,firstname,lastname,address,email,phno,userstatus FROM userinfo WHERE roleid= 3 AND userstatus=1";
            con = ConnectionManager.getConnection();
            System.out.println(sql);
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

    public List getInactiveCustomers() throws SQLException, Exception {
        ResultSet rs = null;
        Connection con = null;

        List<User> customerList = new ArrayList<>();
        try {
            String sql = "SELECT pid,username,firstname,lastname,address,email,phno,userstatus FROM userinfo WHERE roleid= 3 AND userstatus=0";
            con = ConnectionManager.getConnection();
            System.out.println(sql);
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

    public List getDeletedCustomers() throws SQLException, Exception {
        ResultSet rs = null;
        Connection con = null;

        List<User> customerList = new ArrayList<>();
        try {
            String sql = "SELECT pid,username,firstname,lastname,address,email,phno,userstatus FROM userinfo WHERE roleid= 3 AND userstatus=2";
            con = ConnectionManager.getConnection();
            System.out.println(sql);
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

    public List<User> getActiveCSR() throws SQLException, Exception {

        ResultSet rs = null;
        Connection con = null;

        List<User> csrList = new ArrayList<>();
        try {
            String sql = "SELECT pid,username,firstname,lastname,address,email,phno,userstatus FROM userinfo WHERE roleid=2 AND userstatus=1";
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

    public List<User> getInactiveCSR() throws SQLException, Exception {

        ResultSet rs = null;
        Connection con = null;

        List<User> csrList = new ArrayList<>();
        try {
            String sql = "SELECT pid,username,firstname,lastname,address,email,phno,userstatus FROM userinfo WHERE roleid=2 AND userstatus=0";
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

    public List<User> getDeletedCSR() throws SQLException, Exception {

        ResultSet rs = null;
        Connection con = null;

        List<User> csrList = new ArrayList<>();
        try {
            String sql = "SELECT pid,username,firstname,lastname,address,email,phno,userstatus FROM userinfo WHERE roleid=2 AND userstatus=2";
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

    public List<Technician> getAllTechnician() throws SQLException, Exception {

        ResultSet rs = null;
        Connection con = null;

        List<Technician> technicianList = new ArrayList<>();
        try {
            String sql = "SELECT techid,techname,technician.deptid,deptname,techstatus "
                    + "FROM technician,department WHERE technician.deptid = department.deptid";
            con = ConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Technician tech = new Technician();
                tech.setTechid(rs.getInt("techid"));
                tech.setTechname(rs.getString("techname"));
                tech.setDeptid(rs.getInt("deptid"));
                tech.setTechstatus(rs.getInt("techstatus"));
                tech.setDeptname(rs.getString("deptname"));

                technicianList.add(tech);
            }
            return technicianList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (con != null) {
                con.close();
            }
        }

    }

    public List<Technician> getActiveTechnician() throws SQLException, Exception {

        ResultSet rs = null;
        Connection con = null;

        List<Technician> technicianList = new ArrayList<>();
        try {
            String sql = "SELECT techid,techname,technician.deptid,deptname,techstatus "
                    + "FROM technician,department WHERE technician.deptid = department.deptid AND techstatus = 1";
            con = ConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Technician tech = new Technician();
                tech.setTechid(rs.getInt("techid"));
                tech.setTechname(rs.getString("techname"));
                tech.setDeptid(rs.getInt("deptid"));
                tech.setTechstatus(rs.getInt("techstatus"));
                tech.setDeptname(rs.getString("deptname"));
                

                technicianList.add(tech);
            }
            return technicianList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (con != null) {
                con.close();
            }
        }

    }

    public List<Technician> getInactiveTechnician() throws SQLException, Exception {

        ResultSet rs = null;
        Connection con = null;

        List<Technician> technicianList = new ArrayList<>();
        try {
            String sql = "SELECT techid,techname,technician.deptid,deptname,techstatus "
                    + "FROM technician,department WHERE technician.deptid = department.deptid AND techstatus = 0";
            con = ConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Technician tech = new Technician();
                tech.setTechid(rs.getInt("techid"));
                tech.setTechname(rs.getString("techname"));
                tech.setDeptid(rs.getInt("deptid"));
                tech.setTechstatus(rs.getInt("techstatus"));
                tech.setDeptname(rs.getString("deptname"));
                

                technicianList.add(tech);
            }
            return technicianList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
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
            String sql = "UPDATE userinfo SET userstatus= 2 WHERE pid=?";
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
            System.out.println(i);
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

//    
    public User fetchUserDetails(int pid) throws Exception {
        ResultSet rs = null;
        Connection con = null;
        User user = new User();
        try {
            con = ConnectionManager.getConnection();
            String sql = "SELECT pid,username,password,firstname,lastname,address,email,phno,userstatus FROM userinfo WHERE pid=?";
            PreparedStatement ps = con.prepareStatement(sql);
            System.out.println("pid in fetch = " + pid);
            ps.setInt(1, pid);
            System.out.println("Select SQL = " + ps);

            rs = ps.executeQuery();
            if (rs.next()) {
                user.setPid(rs.getInt(1));
                user.setUsername(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setFirstname(rs.getString(4));
                user.setLastname(rs.getString(5));
                user.setAddress(rs.getString(6));
                user.setEmail(rs.getString(7));
                user.setPhno(rs.getString(8));
                user.setUserstatus(rs.getInt(9));
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

    public Product fetchProductDetails(int prodid) throws Exception {
        ResultSet rs = null;
        Connection con = null;
        Product product = new Product();
        try {
            con = ConnectionManager.getConnection();
            String sql = "SELECT prodid,deptid,prodname,prodmodel,prodstatus FROM product WHERE prodid=?";
            PreparedStatement ps = con.prepareStatement(sql);
            System.out.println("pid in fetch = " + prodid);
            ps.setInt(1, prodid);
            System.out.println("Select SQL = " + ps);

            rs = ps.executeQuery();
            if (rs.next()) {
                product.setProdid(rs.getInt("prodid"));
                product.setProdname(rs.getString("prodname"));
                product.setProdmodel(rs.getString("prodmodel"));
                product.setDeptid(rs.getInt("deptid"));
                product.setProdstatus(rs.getInt("prodstatus"));
            }
            return product;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    public Technician fetchTechnicianDetails(int techid) throws Exception {
        ResultSet rs = null;
        Connection con = null;
        Technician tech = new Technician();
        try {
            con = ConnectionManager.getConnection();
            String sql = "SELECT techid,techname,deptid,techstatus FROM technician WHERE techid =?";
            PreparedStatement ps = con.prepareStatement(sql);
            System.out.println("techid in fetch = " + techid);
            ps.setInt(1, techid);
            System.out.println("Select SQL = " + ps);

            rs = ps.executeQuery();
            if (rs.next()) {
                tech.setTechid(rs.getInt("techid"));
                tech.setTechname(rs.getString("techname"));
                tech.setDeptid(rs.getInt("deptid"));
                tech.setTechstatus(rs.getInt("techstatus"));
            }
            return tech;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    public List<Product> getAllProducts() throws SQLException, Exception {
        ResultSet rs = null;
        Connection con = null;

        List<Product> productList = new ArrayList<>();
        try {
            String sql = "SELECT prodid,prodname,prodmodel,deptname,prodstatus FROM product,department where product.deptid = department.deptid AND prodstatus = 1";
            con = ConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            System.out.println(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setProdname(rs.getString("prodname"));
                product.setProdid(rs.getInt("prodid"));
                product.setProdmodel(rs.getString("prodmodel"));
                product.setDeptname(rs.getString("deptname"));
                product.setProdstatus(rs.getInt("prodstatus"));
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

    public List<Product> getDeletedProducts() throws SQLException, Exception {
        ResultSet rs = null;
        Connection con = null;

        List<Product> productList = new ArrayList<>();
        try {
            String sql = "SELECT prodid,prodname,prodmodel,deptname,prodstatus FROM product,department where product.deptid = department.deptid and prodstatus = 0";
            con = ConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            System.out.println(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setProdname(rs.getString("prodname"));
                product.setProdid(rs.getInt("prodid"));
                product.setProdmodel(rs.getString("prodmodel"));
                product.setDeptname(rs.getString("deptname"));
                product.setProdstatus(rs.getInt("prodstatus"));
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

}
