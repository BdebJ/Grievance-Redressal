/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.redress.actions;

import com.redress.dao.Admin;
import com.redress.models.User;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author PALLAB
 */
public class AdminDashboard {
    private String msg = "";
     private List<User> userList = null;
     Admin admin = new Admin();

    public String execute() throws Exception {
        
        HttpSession session = ServletActionContext.getRequest().getSession(false);
        
        if (session == null || session.getAttribute("validUser") == null) {
            setMsg("You are not logged in. Please login first!! ");
            return "login";
        } else {
            setUserList(new ArrayList<User>());
            setUserList(admin.getAllCustomers());
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
}
