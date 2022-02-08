/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.redress.actions;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import com.lambdaworks.crypto.SCryptUtil;
import com.redress.dao.LoginDAO;
import com.redress.models.User;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author bjena
 */
public class LoginAction implements SessionAware {

    private SessionMap<String, Object> sessionMap;
    HttpSession session = ServletActionContext.getRequest().getSession(false);
    User valUser = (User) session.getAttribute("validUser");
    private String hash;
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
    private String msg = "";
    private int ctr = 0;

    LoginDAO login = null;

    @Override
    public void setSession(Map<String, Object> map) {

        setSessionMap((SessionMap<String, Object>) map);
    }

    public boolean validatePassword(String username, String password) throws Exception {
        login = new LoginDAO();
        boolean check = false;
        setHash(login.getPasswordHash(username));
        try {
        check = SCryptUtil.check(password, getHash());
        } catch(Exception e){
            e.printStackTrace();
        }
        return check;
    }
    
    public String validateLoginCredentials() throws Exception {

        login = new LoginDAO();
        try {
                         
            User validUser = login.validLoginCredential(username);
            if(validatePassword(username,password)){
                validUser.setValidUser(true);
            }
            
            if (validUser.isValidUser()) {

                sessionMap.put("validUser", validUser);
                sessionMap.put("roleid", validUser.getRoleid());

                username = validUser.getUsername();
                password = validUser.getPassword();
                firstname = validUser.getFirstname();
                lastname = validUser.getLastname();
                email = validUser.getEmail();
                phno = validUser.getPhno();
                roleid = validUser.getRoleid();
                userstatus = validUser.getUserstatus();

                System.out.println("roleid = " + validUser.getRoleid());

//                    success = (user.getRole());
                if (roleid == 1) {
                    success = "successAdmin";
                } else if (roleid == 2) {

                    success = "successCSR";
                } else {
                    if (userstatus == 0) {
                        success = "changePassword";
                    } else {
                        success = "successCustomer";
                    }
                }
            } else {
                this.msg = "Invalid Username or Password!!";
                return "failure";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return success;
    }

    public String changePassword() throws Exception {
        login = new LoginDAO();
        try {
            String generatedSecuredPasswordHash = SCryptUtil.scrypt(password, 2048, 8, 1);
            setCtr(login.changePassword(generatedSecuredPasswordHash, valUser.getPid()));
            if (getCtr() > 0) {
                setMsg("Password Changed Successfully.");
                return "successchangepassword";
            } else {
                setMsg("Some error!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "failurechangepassword";
    }

    public String logout() {
        if (sessionMap != null) {
            sessionMap.invalidate();
        }
        return "success";
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

    /**
     * @return the sessionMap
     */
    public SessionMap<String, Object> getSessionMap() {
        return sessionMap;
    }

    /**
     * @param sessionMap the sessionMap to set
     */
    public void setSessionMap(SessionMap<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    /**
     * @return the ctr
     */
    public int getCtr() {
        return ctr;
    }

    /**
     * @param ctr the ctr to set
     */
    public void setCtr(int ctr) {
        this.ctr = ctr;
    }

    /**
     * @return the hash
     */
    public String getHash() {
        return hash;
    }

    /**
     * @param hash the hash to set
     */
    public void setHash(String hash) {
        this.hash = hash;
    }

}
