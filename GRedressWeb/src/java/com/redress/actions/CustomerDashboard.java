/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.redress.actions;

import com.redress.dao.Admin;
import com.redress.dao.CSR;
import com.redress.dao.Customer;
import com.redress.models.Complaint;
import com.redress.models.User;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author PALLAB
 */
public class CustomerDashboard {
    private String msg = "";
     private List<User> userList = null;
     private List<Complaint> complaintList = null;
     private List<Complaint> closedComplaint = null;
     private List<Complaint> unresolvedComplaint = null;
     Admin admin = new Admin();
     CSR csr = new CSR();
     Customer customer = new Customer();

    public String execute() throws Exception {
        
        HttpSession session = ServletActionContext.getRequest().getSession(false);
        User validUser = (User) session.getAttribute("validUser");
        if (session == null || session.getAttribute("validUser") == null) {
            setMsg("You are not logged in. Please login first!! ");
            return "login";
        } else {
            setUserList(new ArrayList<User>());
            setUserList(admin.getAllCustomers());
            System.out.println(validUser.getPid());
            setComplaintList(new ArrayList<Complaint>());
            setComplaintList(customer.showcomplaints(validUser.getPid()));
            setClosedComplaint(customer.closedComplaintDetails(validUser.getPid()));
            return "success";
        }

    }

    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * @return the userList
     */
    public List<User> getUserList() {
        return userList;
    }

    /**
     * @param userList the userList to set
     */
    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    /**
     * @return the complaintList
     */
    public List<Complaint> getComplaintList() {
        return complaintList;
    }

    /**
     * @param complaintList the complaintList to set
     */
    public void setComplaintList(List<Complaint> complaintList) {
        this.complaintList = complaintList;
    }

    /**
     * @return the resolvedComplaint
     */
    public List<Complaint> getClosedComplaint() {
        return closedComplaint;
    }

    /**
     * @param resolvedComplaint the resolvedComplaint to set
     */
    public void setClosedComplaint(List<Complaint> resolvedComplaint) {
        this.closedComplaint = resolvedComplaint;
    }

    /**
     * @return the unresolvedComplaint
     */
    public List<Complaint> getUnresolvedComplaint() {
        return unresolvedComplaint;
    }

    /**
     * @param unresolvedComplaint the unresolvedComplaint to set
     */
    public void setUnresolvedComplaint(List<Complaint> unresolvedComplaint) {
        this.unresolvedComplaint = unresolvedComplaint;
    }
}
