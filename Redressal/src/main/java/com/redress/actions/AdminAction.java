/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.redress.actions;

import com.lambdaworks.crypto.SCryptUtil;
import com.opensymphony.xwork2.ActionSupport;
import com.redress.dao.AdminDAO;
import com.redress.models.Department;
import com.redress.models.Product;
import com.redress.models.Technician;
import java.util.List;

import com.redress.models.User;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author bjena
 */
public class AdminAction extends ActionSupport {



	//User
    private int pid;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String address;
    private String email;
    private String phno;
    private int roleid;
    private String role;
    private int userstatus;
    private boolean validUser;
    private boolean noData = false;

    private String msg = "";    //for error or success message
    AdminDAO admin = new AdminDAO();
    private int ctr = 0;

    // Product 
    private int prodid;
    private int deptid;
    private String prodmodel;
    private String prodname;
    private int prodstatus;

    // Technician
    private int techid;
    private String techname;
    private int techstatus;

    // Department
    private String deptname;
    private List<User> userList = null;
    private List<Department> deptList = null;
    private String submitType;
    Department dept = null;
    Product prod = null;
    Technician tech = null;

    private static final Logger logger = Logger.getLogger(AdminAction.class);

    public String execute() {
        logger.info("inside AdminAction execute method");
        return SUCCESS;
    }

    // Update Methods
    public String updateDepartment() throws Exception {
        admin = new AdminDAO();
        try {
            setCtr(admin.updateDepartment(deptid, deptname));
            if (getCtr() > 0) {
                setMsg("Department updated Successfully!");
            } else {
                setMsg("Some error");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "UPDATEDEPARTMENT";
    }

    public String updateTechnician() throws Exception {
        admin = new AdminDAO();
        try {
            admin = new AdminDAO();

            if (getSubmitType().equals("updatedata")) {
                System.out.println("Here I am");
                Technician tech = admin.fetchTechnicianDetails(techid);
                if (tech != null) {
                    techid = tech.getTechid();
                    techname = tech.getTechname();
                    deptid = tech.getDeptid();
                    techstatus = tech.getTechstatus();
                    deptname = tech.getDeptname();

                }
            } else {
                setCtr(admin.updateTechnician(techid, deptid, techname, techstatus));
                if (getCtr() > 0) {
                    setMsg("Technician updated Successfully!");
                } else {
                    setCtr(-1);
                    setMsg("Some error");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "UPDATETECHNICIAN";
    }

    public String updateProduct() throws Exception {
        admin = new AdminDAO();
        try {
            if (getSubmitType().equals("updatedata")) {
                System.out.println("Here I am");
                Product product = admin.fetchProductDetails(prodid);
                if (product != null) {
                    prodid = product.getProdid();
                    deptid = product.getDeptid();
                    deptname = product.getDeptname();
                    prodname = product.getProdname();
                    prodmodel = product.getProdmodel();
                    prodstatus = product.getProdstatus();
                }
            } else {
                setCtr(admin.updateProduct(prodid, prodname, deptid, prodmodel, prodstatus));
                if (getCtr() > 0) {
                    setMsg("Product updated Successfully!");
                } else {
                    setMsg("Some error");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "UPDATEPRODUCT";
    }

    public String updateUser() throws Exception {
        admin = new AdminDAO();
        try {
            if (getSubmitType().equals("updatedata")) {
                System.out.println("Here I am");
                User user = admin.fetchUserDetails(pid);
                if (user != null) {
                    pid = user.getPid();
                    username = user.getUsername();
                    password = user.getPassword();
                    firstname = user.getFirstname();
                    lastname = user.getLastname();
                    address = user.getAddress();
                    email = user.getEmail();
                    phno = user.getPhno();
                    userstatus = user.getUserstatus();
                }
            } else {
                setCtr(admin.updateUser(pid, username, password, firstname, lastname, address, email, phno, userstatus));
                if (getCtr() > 0) {
                    setMsg("User updated Successfully!");
                } else {
                    setCtr(-1);
                    setMsg("Some error occured!");
                }
//            }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "UPDATEUSER";
    }

    public String editProfile() throws Exception {
        admin = new AdminDAO();
        try {
            setCtr(admin.editProfile(pid, firstname, lastname, address, email, phno));
            if (getCtr() > 0) {
                User validUser = admin.fetchUserDetails(pid);
                HttpSession session = ServletActionContext.getRequest().getSession(false);
                session.setAttribute("validUser", validUser);
               
                setMsg("Profile updated Successfully!");
            } else {
                setCtr(-1);
                setMsg("Some error occured!");
            }
//            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "EDITUSER";
    }

    public String addCustomers() throws Exception {
        admin = new AdminDAO();

        try {
            password = SCryptUtil.scrypt("1234", 2048, 8, 1);
            setCtr(admin.addCustomers(getUsername(), getPassword(), getFirstname(), getLastname(), getAddress(), getEmail(), getPhno()));
            if (getCtr() > 0) {
                setMsg("Customer added successfully");
            } else {
                setCtr(-1);
                setMsg("Username or email id is already registered!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ADDCUSTOMERS";
    }

    public String addCSR() throws Exception {
        admin = new AdminDAO();

        try {
            password = SCryptUtil.scrypt("1234", 2048, 8, 1);
            setCtr(admin.addCSR(getUsername(), getPassword(), getFirstname(), getLastname(), getAddress(), getEmail(), getPhno()));
            if (getCtr() > 0) {
                setMsg("CSR added successfully");
            } else {
                setCtr(-1);
                setMsg("Username or email id is already registered!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ADDCSR";
    }

    public String addProduct() throws Exception {
        admin = new AdminDAO();
        try {
            setCtr(admin.addProduct(getDeptid(), getProdname(), getProdmodel()));
            if (getCtr() > 0) {
                setMsg("Product added Successfully!");
            } else {
                setMsg("Some error occured!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "ADDPRODUCT";
    }

    public String addTechnician() throws Exception {
        admin = new AdminDAO();
        try {
            setCtr(admin.addTechnician(getDeptid(), getTechname()));
            if (getCtr() > 0) {
                setMsg("Technician added Successfully!");
            } else {
                setMsg("Some error");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "ADDTECHNICIAN";
    }

    public String addDepartment() throws Exception {
        admin = new AdminDAO();
        try {
            setCtr(admin.addDepartment(getDeptname()));
            if (getCtr() > 0) {
                setMsg("Department added Successfully!");
            } else {
                setMsg("Some error");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "ADDDEPARTMENT";
    }

    public String deleteProd() throws Exception {
        try {
            setCtr(admin.deleteProdDetails(getProdid()));
            if (getCtr() > 0) {
                setMsg("Product deleted successfully");
            } else {
                setCtr(-1);
                setMsg("Some error");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "DELETEPRODUCT";
    }

    public String deleteTech() throws Exception {
        try {
            int isDeleted = admin.deleteTechDetails(getTechid());
            if (isDeleted > 0) {
                setMsg("Technician deleted successfully");
            } else {
                setMsg("Some error");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "DELETETECHNICIAN";
    }

    public String deleteDept() throws Exception {
        try {
            int isDeleted = admin.deleteDeptDetails(getDeptid());
            if (isDeleted > 0) {
                setMsg("Department deleted successfully");
            } else {
                setMsg("Some error");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "DELETEDEPARTMENT";
    }

    public String deleteUser() throws Exception {
        try {
            int isDeleted = admin.deleteUserDetails(getPid());
            if (isDeleted > 0) {
                setMsg("User deleted successfully");
            } else {
                setMsg("Some error");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "user_delete_success";
    }

    public String listCustomer() throws Exception {
        try {
            setUserList(new ArrayList<User>());
            setUserList(admin.getAllCustomers());

            if (!userList.isEmpty()) {
                setNoData(false);
            } else {
                setNoData(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "customer_list_success";
    }

    public String showActiveCustomers() throws Exception {
        try {
            setUserList(new ArrayList<User>());
            setUserList(admin.getActiveCustomers());
            if (!userList.isEmpty()) {
                setNoData(false);
            } else {
                setNoData(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "SHOWACTIVECUSTOMERS";
    }

    public String showInactiveCustomers() throws Exception {
        try {
            setUserList(new ArrayList<User>());
            setUserList(admin.getInactiveCustomers());
            if (!userList.isEmpty()) {
                setNoData(false);
            } else {
                setNoData(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "SHOWINACTIVECUSTOMERS";
    }

    public String showDeletedCustomers() throws Exception {
        try {
            setUserList(new ArrayList<User>());
            setUserList(admin.getDeletedCustomers());
            if (!userList.isEmpty()) {
                setNoData(false);
            } else {
                setNoData(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "SHOWDELETEDCUSTOMERS";
    }

    private List<User> csrList = null;

    public String showCSR() {
        try {
            setCsrList(new ArrayList<User>());
            setCsrList(admin.getAllCSR());
            if (!csrList.isEmpty()) {
                setNoData(false);
            } else {
                setNoData(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "SHOWCSR";
    }

    public String showActiveCSR() {
        try {
            setCsrList(new ArrayList<User>());
            setCsrList(admin.getActiveCSR());
            if (!csrList.isEmpty()) {
                setNoData(false);
            } else {
                setNoData(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "SHOWACTIVECSR";
    }

    public String showInactiveCSR() {
        try {
            setCsrList(new ArrayList<User>());
            setCsrList(admin.getInactiveCSR());
            if (!csrList.isEmpty()) {
                setNoData(false);
            } else {
                setNoData(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "SHOWINACTIVECSR";
    }

    public String showDeletedCSR() {
        try {
            setCsrList(new ArrayList<User>());
            setCsrList(admin.getDeletedCSR());
            if (!csrList.isEmpty()) {
                setNoData(false);
            } else {
                setNoData(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "SHOWDELETEDCSR";
    }

    private List<Technician> technicianList = null;

    public String showTechnician() {
        try {
            setTechnicianList(new ArrayList<Technician>());
            setTechnicianList(admin.getAllTechnician());
            if (!technicianList.isEmpty()) {
                setNoData(false);
            } else {
                setNoData(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "SHOWTECHNICIAN";
    }

    public String showActiveTechnician() {
        try {
            setTechnicianList(new ArrayList<Technician>());
            setTechnicianList(admin.getActiveTechnician());
            if (!technicianList.isEmpty()) {
                setNoData(false);
            } else {
                setNoData(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "SHOWACTIVETECHNICIAN";
    }

    public String showInactiveTechnician() {
        try {
            setTechnicianList(new ArrayList<Technician>());
            setTechnicianList(admin.getInactiveTechnician());
            if (!technicianList.isEmpty()) {
                setNoData(false);
            } else {
                setNoData(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "SHOWINACTIVETECHNICIAN";
    }

    private List<Product> productList = null;

    public String showProducts() {
        try {
            setProductList(new ArrayList<Product>());
            setProductList(admin.getAllProducts());
            if (!productList.isEmpty()) {
                setNoData(false);
            } else {
                setNoData(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "SHOWPRODUCTS";
    }

    public String showDeletedProducts() {
        try {
            setProductList(new ArrayList<Product>());
            setProductList(admin.getDeletedProducts());
            if (!productList.isEmpty()) {
                setNoData(false);
            } else {
                setNoData(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "SHOWPRODUCTS";
    }

    public String listDepartmentComplaints() {
        try {
            setDeptList(new ArrayList<Department>());
            setDeptList(admin.getDeptComplaintsNum());
            if (!deptList.isEmpty()) {
                setNoData(false);
            } else {
                setNoData(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "DEPTCOMPLAINTSNUM";
    }

    /**
     * @return the noData
     */
    public boolean isNoData() {
        return noData;
    }

    /**
     * @param noData the noData to set
     */
    public void setNoData(boolean noData) {
        this.noData = noData;
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
     * @return the deptid
     */
    public int getDeptid() {
        return deptid;
    }

    /**
     * @param deptid the deptid to set
     */
    public void setDeptid(int deptid) {
        this.deptid = deptid;
    }

    /**
     * @return the techid
     */
    public int getTechid() {
        return techid;
    }

    /**
     * @param techid the techid to set
     */
    public void setTechid(int techid) {
        this.techid = techid;
    }

    /**
     * @return the prodid
     */
    public int getProdid() {
        return prodid;
    }

    /**
     * @param prodid the prodid to set
     */
    public void setProdid(int prodid) {
        this.prodid = prodid;
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
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(String role) {
        this.role = role;
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
     * @return the prodmodel
     */
    public String getProdmodel() {
        return prodmodel;
    }

    /**
     * @param prodmodel the prodmodel to set
     */
    public void setProdmodel(String prodmodel) {
        this.prodmodel = prodmodel;
    }

    /**
     * @return the prodname
     */
    public String getProdname() {
        return prodname;
    }

    /**
     * @param prodname the prodname to set
     */
    public void setProdname(String prodname) {
        this.prodname = prodname;
    }

    /**
     * @return the techname
     */
    public String getTechname() {
        return techname;
    }

    /**
     * @param techname the techname to set
     */
    public void setTechname(String techname) {
        this.techname = techname;
    }

    /**
     * @return the deptname
     */
    public String getDeptname() {
        return deptname;
    }

    /**
     * @param deptname the deptname to set
     */
    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    /**
     * @return the csrList
     */
    public List<User> getCsrList() {
        return csrList;
    }

    /**
     * @param csrList the csrList to set
     */
    public void setCsrList(List<User> csrList) {
        this.csrList = csrList;
    }

    /**
     * @return the submitType
     */
    public String getSubmitType() {
        return submitType;
    }

    /**
     * @param submitType the submitType to set
     */
    public void setSubmitType(String submitType) {
        this.submitType = submitType;
    }

    /**
     * @return the technicianList
     */
    public List<Technician> getTechnicianList() {
        return technicianList;
    }

    /**
     * @param technicianList the technicianList to set
     */
    public void setTechnicianList(List<Technician> technicianList) {
        this.technicianList = technicianList;
    }

    /**
     * @return the techstatus
     */
    public int getTechstatus() {
        return techstatus;
    }

    /**
     * @param techstatus the techstatus to set
     */
    public void setTechstatus(int techstatus) {
        this.techstatus = techstatus;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    /**
     * @return the prodstatus
     */
    public int getProdstatus() {
        return prodstatus;
    }

    /**
     * @param prodstatus the prodstatus to set
     */
    public void setProdstatus(int prodstatus) {
        this.prodstatus = prodstatus;
    }

    /**
     * @return the deptList
     */
    public List<Department> getDeptList() {
        return deptList;
    }

    /**
     * @param deptList the deptList to set
     */
    public void setDeptList(List<Department> deptList) {
        this.deptList = deptList;
    }
}
