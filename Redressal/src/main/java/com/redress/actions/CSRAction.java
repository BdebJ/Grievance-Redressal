/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.redress.actions;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.redress.dao.CSR;
import com.redress.models.Complaint;
import com.redress.models.CustomerDefect;
import com.redress.models.Department;
import com.redress.models.Technician;
import com.redress.models.User;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author bjena
 */
public class CSRAction {

    private List<User> customerList = null;
    CSR csr = new CSR();
    private boolean noData = false;

    private static final Logger logger = Logger.getLogger(CSRAction.class);

    public String execute() {
        logger.info("inside CSRAction execute method");
        return SUCCESS;
    }
    public String showCustomers() {

        try {
            setCustomerList(new ArrayList<User>());
            setCustomerList(csr.customerList());

            if (!customerList.isEmpty()) {
                setNoData(false);
            } else {
                setNoData(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "CUSTOMERLIST";
    }
    private List<Department> departmentList = null;

    public String showDepartments() {

        try {
            setDepartmentList(new ArrayList<Department>());
            setDepartmentList(csr.departmentList());

            if (!departmentList.isEmpty()) {
                setNoData(false);
                System.out.println("Users retrieve = " + getDepartmentList().size());
                System.out.println("setting nodata=false");
            } else {
                setNoData(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "DEPARTEMNTLIST";
    }

    private List<Complaint> complaintList = null;

    public String showComplaint() {

        try {
            setComplaintList(new ArrayList<Complaint>());
            setComplaintList(csr.complaintList());

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
        return "COMPLAINTLIST";
    }
       private List<Complaint> csrcomplaintList = null;

    public String showcsrComplaint() {

        try {
            setCsrcomplaintList(new ArrayList<Complaint>());
            setCsrcomplaintList(csr.csrcomplaintList());

            if (!csrcomplaintList.isEmpty()) {
                setNoData(false);
                System.out.println("Users retrieve = " + getCsrcomplaintList().size());
                System.out.println("setting nodata=false");
            } else {
                setNoData(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "CSRCOMPLAINTLIST";
    }
    public String showResolvedComplaint() {

        try {
            setComplaintList(new ArrayList<Complaint>());
            setComplaintList(csr.resolvedComplaintList());

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
        return "COMPLAINTLIST";
    }
    
    public String showUnresolvedComplaint() {

        try {
            setComplaintList(new ArrayList<Complaint>());
            setComplaintList(csr.unResolvedComplaintList());

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
        return "COMPLAINTLIST";
    }
    
    public String showNewComplaint() {

        try {
            setComplaintList(new ArrayList<Complaint>());
            setComplaintList(csr.newComplaintList());

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
        return "NEWCOMPLAINTLIST";
    }
    
    
    public String showRejectedComplaint() {

        try {
            setComplaintList(new ArrayList<Complaint>());
            setComplaintList(csr.rejectedComplaintList());

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
        return "COMPLAINTLIST";
    }
    
    private List<CustomerDefect> customerdefect = null;

    public String customerDefects() {

        try {
            setCustomerdefect(new ArrayList<CustomerDefect>());
            setCustomerdefect(csr.customerDefect());

            if (!customerdefect.isEmpty()) {
                setNoData(false);
                System.out.println("Users retrieve = " + getCustomerdefect().size());
                System.out.println("setting nodata=false");
            } else {
                setNoData(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "DEFECTS";
    }

    private int deptid;
    private List<Technician> technician = null;

    public String showTechnicians() throws Exception {

        try {

            setTechnician(new ArrayList<Technician>());
            setTechnician(csr.fetchTechnician(getDeptid()));

            if (!technician.isEmpty()) {
                setNoData(false);
                System.out.println("Users retrieve = " + getTechnician().size());
                System.out.println("setting nodata=false");
            } else {
                setNoData(true);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "TECHNICIAN";
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

    private String submitType;
    private String msg = "";
    private int complid;
    private String compltime;
    private String subject;
    private String description;
    private int pid;
    private int techid;
    private int compl_status;
    private String startprog;
    private String ongoingprog;
    private String endprog;
    private String prodname;
    private String prodmodel;
    private String firstname;
    private String lastname;
    private int ctr;
    private int res_status;

    public String updateComplaints() throws Exception {

        try {
            if (getSubmitType().equals("updatedata")) {
                Complaint complaint = csr.fetchComplaintDetails(getComplid());
                if (complaint != null) {
                    setFirstname(complaint.getFirstname());
                    setLastname(complaint.getLastname());
                    setComplid(complaint.getComplid());
                    setCompltime(complaint.getCompltime());
                    setSubject(complaint.getSubject());
                    setDescription(complaint.getDescription());
                    setProdname(complaint.getProdname());
                    setProdmodel(complaint.getProdmodel());
                    setPid(complaint.getPid());
                    setTechid(complaint.getTechid());
                    setCompl_status(complaint.getCompl_status());
                    setStartprog(complaint.getStartprog());
                    setOngoingprog(complaint.getOngoingprog());
                    setEndprog(complaint.getEndprog());
                    setRes_status(complaint.getRes_status());
                }
            } else {
                setCtr(csr.updateComplaintDetails(complid, getTechid(), getCompl_status(), getStartprog(), getOngoingprog(), getEndprog(), getRes_status()));
                if (ctr > 0) {
                    setMsg("Record Updated Successfuly");
                } else {
                    setCtr(-1);
                    setMsg("some error occured.. Try again!");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "UPDATECOMPLAINT";
    }
    
    /**
     * @return the customerList
     */
    public List<User> getCustomerList() {
        return customerList;
    }

    /**
     * @param customerList the customerList to set
     */
    public void setCustomerList(List<User> customerList) {
        this.customerList = customerList;
    }

    /**
     * @return the csr
     */
    public CSR getCsr() {
        return csr;
    }

    /**
     * @param csr the csr to set
     */
    public void setCsr(CSR csr) {
        this.csr = csr;
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
     * @return the departmentList
     */
    public List<Department> getDepartmentList() {
        return departmentList;
    }

    /**
     * @param departmentList the departmentList to set
     */
    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
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
     * @return the customerdefect
     */
    public List<CustomerDefect> getCustomerdefect() {
        return customerdefect;
    }

    /**
     * @param customerdefect the customerdefect to set
     */
    public void setCustomerdefect(List<CustomerDefect> customerdefect) {
        this.customerdefect = customerdefect;
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
     * @return the technician
     */
    public List<Technician> getTechnician() {
        return technician;
    }

    /**
     * @param technician the technician to set
     */
    public void setTechnician(List<Technician> technician) {
        this.technician = technician;
    }

    /**
     * @return the csrcomplaintList
     */
    public List<Complaint> getCsrcomplaintList() {
        return csrcomplaintList;
    }

    /**
     * @param csrcomplaintList the csrcomplaintList to set
     */
    public void setCsrcomplaintList(List<Complaint> csrcomplaintList) {
        this.csrcomplaintList = csrcomplaintList;
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
}
