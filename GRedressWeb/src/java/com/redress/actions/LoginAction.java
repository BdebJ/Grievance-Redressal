/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.redress.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.redress.dao.Login;
import com.redress.models.User;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author bjena
 */
public class LoginAction extends ActionSupport {

    private int pid;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String address;
    private String email;
    private String phno;
    private int roleid;
    private int userstatus;
    private boolean validUser;
    private static String success;
    private String msg ="";
    
    Login login = null;
    
    public String validateLoginCredentials() throws Exception{
        
        login = new Login();
        try{
            
                User user = login.validLoginCredential(username,password);
                
                if (user.isValidUser()) {
                    Map<String,Object> session = ActionContext.getContext().getSession();
                    session.put("user", user);
                    
                    username = user.getUsername();
                    password = user.getPassword();
                    firstname = user.getFirstname();
                    lastname = user.getLastname();
                    email = user.getEmail();
                    phno = user.getPhno();
                    roleid = user.getRoleid();
                    System.out.println("roleid = "+ user.getRoleid());
                   
//                    success = (user.getRole());
                    if (roleid == 1){
                        success = "successAdmin";
                    }
                    else if(roleid == 2){
                        success = "successCSR";
                    }
                    else{
                        success = "successCustomer";
                    }
                }
             else {
                    this.msg = "Invalid Username or Password!!";
                return "failure";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return success;
    }

    /**
     * @return the pid
     */
    public int getPid() {
        return pid;
    }

    /**
     * @param pid the pid to set
     */
    public void setPid(int pid) {
        this.pid = pid;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname the firstname to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname the lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the phno
     */
    public String getPhno() {
        return phno;
    }

    /**
     * @param phno the phno to set
     */
    public void setPhno(String phno) {
        this.phno = phno;
    }

    /**
     * @return the roleid
     */
    public int getRoleid() {
        return roleid;
    }

    /**
     * @param roleid the roleid to set
     */
    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    /**
     * @return the userstatus
     */
    public int getUserstatus() {
        return userstatus;
    }

    /**
     * @param userstatus the userstatus to set
     */
    public void setUserstatus(int userstatus) {
        this.userstatus = userstatus;
    }

    /**
     * @return the validUser
     */
    public boolean isValidUser() {
        return validUser;
    }

    /**
     * @param validUser the validUser to set
     */
    public void setValidUser(boolean validUser) {
        this.validUser = validUser;
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

}
