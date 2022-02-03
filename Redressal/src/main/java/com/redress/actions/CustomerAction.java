package com.redress.actions;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.redress.dao.Customer;
import com.redress.models.Complaint;
import com.redress.models.CustomerDefect;
import com.redress.models.Product;
import com.redress.models.ProductOwned;
import com.redress.models.User;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.apache.log4j.Logger;

public class CustomerAction {

    HttpSession session = ServletActionContext.getRequest().getSession(false);
    User validUser = (User) session.getAttribute("validUser");

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
    private String message;
    private String submitType;
    private int complid;
    private String compltime;
    private String subject;
    private String description;
    private int techid;
    private int compl_status;
    private String startprog;
    private String ongoingprog;
    private String endprog;
    private int res_status;
    private int fbackid;
    private int ownid;

    private String feedback;
    private int rating;
    private List<User> userList = null;
    private List<Complaint> complaintList = null;
    private List<Product> productList = null;
    private List<CustomerDefect> CustomerDefectList = null;
    private List<ProductOwned> ProductOwnedList = null;
    
    private int ctr = 0;
    private boolean noData = false;
    private ResultSet rs = null;
    Customer customer = null;
    private String msg = "";
    Timestamp date = new Timestamp(new Date().getTime());

    private static final Logger logger = Logger.getLogger(CustomerAction.class);

    public String execute() {
        logger.info("inside CustomerAction execute method");
        return SUCCESS;
    }

    public String showUser() throws Exception {
        customer = new Customer();

        try {
            setUserList(new ArrayList<User>());
            setUserList(customer.report(getPid()));

            if (!userList.isEmpty()) {
                setNoData(false);
                System.out.println("Users retrieve = " + getUserList().size());
                System.out.println("setting nodata=false");
            } else {
                setNoData(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "REPORT";
    }

    public String addComplaint() throws Exception {
        customer = new Customer();
        System.out.println("MY PID" + validUser.getPid());
        try {
            setCtr(customer.ComplaintRegister(date, subject, description, validUser.getPid(), ownid));
            if (getCtr() > 0) {
                setMsg("Complaint Registered Successfully");
            } else {
                setMsg("Some error occured! Try again..");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "ADDCOMPLAINT";
    }

    public String addFeedback() throws Exception {
        System.out.println("in action");
        customer = new Customer();

        try {
            setCtr(customer.FeedbackRegister(feedback, rating));
            if (getCtr() > 0) {
                System.out.println(getCtr());
                setMsg("Feedback Submitted Successfully");
            } else {
                setMsg("Some error");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "ADDFEEDBACK";
    }

    public String showComplaint() throws Exception {

        Customer customer = new Customer();

        try {
            setComplaintList(new ArrayList<Complaint>());
            setComplaintList(customer.showcomplaints(getPid()));

            if (!complaintList.isEmpty()) {

                setNoData(false);
                System.out.println("Complaints retrieve = " + getComplaintList().size());
                System.out.println("setting nodata=false");
            } else {
                setNoData(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "SHOWCOMPLAINT";
    }

    public String showComplaintbyPid() {

        try {
            customer = new Customer();
            setComplaintList(new ArrayList<Complaint>());
            setComplaintList(customer.complaintListbyPid(validUser.getPid()));

            if (!complaintList.isEmpty()) {
                setNoData(false);
                System.out.println("Users retrieve = " + getComplaintList().size());
                System.out.println("setting nodata=false");
            } else {
                setNoData(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "PIDCOMPLAINTLIST";
    }

    public String closeComplaint() throws Exception {
        Customer customer = new Customer();
        try {
            setComplaintList(new ArrayList<Complaint>());
            setComplaintList(customer.closedComplaintDetails(getPid()));

            if (!complaintList.isEmpty()) {

                setNoData(false);
                System.out.println("Complaints retrieve = " + getComplaintList().size());
                System.out.println("setting nodata=false");
            } else {
                setNoData(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "CLOSEDCUSTOMERCOMPLAINT";
    }

    public String showProductOwned() throws Exception {

        Customer customer = new Customer();

        try {
            setProductList(new ArrayList<Product>());
            setProductList(customer.productOwn(getPid()));

            if (!productList.isEmpty()) {
                setNoData(false);
            } else {
                setNoData(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "SHOWPRODUCTOWNED";
    }

    public String viewDefect() throws Exception {

        Customer customer = new Customer();

        try {

            setCustomerDefectList(new ArrayList<CustomerDefect>());
            setCustomerDefectList(customer.viewDefect());

            if (!CustomerDefectList.isEmpty()) {
                setNoData(false);
                System.out.println("CustomerDefect retrieve = " + getCustomerDefectList().size());
                System.out.println("setting nodata=false");
            } else {
                setNoData(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "VIEWDEFECT";
    }

    public String fetchProductsByPid() throws Exception {

        Customer customer = new Customer();
        try {

            setProductOwnedList(new ArrayList<ProductOwned>());
            setProductOwnedList(customer.productsByPid(validUser.getPid()));

            if (!ProductOwnedList.isEmpty()) {
                setNoData(false);
                System.out.println("Product Owned retrieve = " + getProductOwnedList().size());
                System.out.println("setting nodata=false");
            } else {
                setNoData(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "PRODUCTOWNEDLIST";
    }

    public String sendMessage() throws Exception {
        customer = new Customer();
        System.out.println("MY PID" + validUser.getPid());
        try {
            setCtr(customer.sendMessage(firstname, email, phno, message, validUser.getPid(), validUser.getUsername()));
            if (getCtr() > 0) {
                setMsg("Message sent Successfully");
            } else {
                setMsg("Some error occured! Try again..");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "SENDMESSAGE";
    }

    public List<User> getUserList() {

        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
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
//    public boolean isValidUser() {
//        return validUser;
//    }
//
//    /**
//     * @param validUser the validUser to set
//     */
//    public void setValidUser(boolean validUser) {
//        this.validUser = validUser;
//    }
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
     * @return the rs
     */
    public ResultSet getRs() {
        return rs;
    }

    /**
     * @param rs the rs to set
     */
    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public String getSubmitType() {
        return submitType;
    }

    /**
     * @param submitType the submitType to set
     */
    public void setSubmitType(String submitType) {
        this.submitType = submitType;
    }

    public String getMsg() {
        return msg;
    }

    private void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * @return the complid
     */
    public int getComplid() {
        return complid;
    }

    /**
     * @param complid the complid to set
     */
    public void setComplid(int complid) {
        this.complid = complid;
    }

    /**
     * @return the compltime
     */
    public String getCompltime() {
        return compltime;
    }

    /**
     * @param compltime the compltime to set
     */
    public void setCompltime(String compltime) {
        this.compltime = compltime;
    }

    /**
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
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
     * @return the compl_status
     */
    public int getCompl_status() {
        return compl_status;
    }

    /**
     * @param compl_status the compl_status to set
     */
    public void setCompl_status(int compl_status) {
        this.compl_status = compl_status;
    }

    /**
     * @return the startprog
     */
    public String getStartprog() {
        return startprog;
    }

    /**
     * @param startprog the startprog to set
     */
    public void setStartprog(String startprog) {
        this.startprog = startprog;
    }

    /**
     * @return the ongoingprog
     */
    public String getOngoingprog() {
        return ongoingprog;
    }

    /**
     * @param ongoingprog the ongoingprog to set
     */
    public void setOngoingprog(String ongoingprog) {
        this.ongoingprog = ongoingprog;
    }

    /**
     * @return the endprog
     */
    public String getEndprog() {
        return endprog;
    }

    /**
     * @param endprog the endprog to set
     */
    public void setEndprog(String endprog) {
        this.endprog = endprog;
    }

    /**
     * @return the res_status
     */
    public int getRes_status() {
        return res_status;
    }

    /**
     * @param res_status the res_status to set
     */
    public void setRes_status(int res_status) {
        this.res_status = res_status;
    }

    /**
     * @return the fbackid
     */
    public int getFbackid() {
        return fbackid;
    }

    /**
     * @param fbackid the fbackid to set
     */
    public void setFbackid(int fbackid) {
        this.fbackid = fbackid;
    }

    /**
     * @return the feedback
     */
    public String getFeedback() {
        return feedback;
    }

    /**
     * @param feedback the feedback to set
     */
    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    /**
     * @return the rating
     */
    public int getRating() {
        return rating;
    }

    /**
     * @param rating the rating to set
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    public List<Complaint> getComplaintList() {
        return complaintList;
    }

    public void setComplaintList(List<Complaint> complaintList) {
        this.complaintList = complaintList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public List<CustomerDefect> getCustomerDefectList() {
        return CustomerDefectList;
    }

    public void setCustomerDefectList(List<CustomerDefect> CustomerDefectList) {
        this.CustomerDefectList = CustomerDefectList;
    }

    public List<ProductOwned> getProductOwnedList() {
        return ProductOwnedList;
    }

    public void setProductOwnedList(List<ProductOwned> ProductOwnedList) {
        this.ProductOwnedList = ProductOwnedList;
    }

    /**
     * @return the ownid
     */
    public int getOwnid() {
        return ownid;
    }

    /**
     * @param ownid the ownid to set
     */
    public void setOwnid(int ownid) {
        this.ownid = ownid;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

}
