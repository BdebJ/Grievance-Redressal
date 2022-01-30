/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.redress.actions;

import com.redress.dao.CSR;
import com.redress.models.Complaint;
import com.redress.models.CustomerDefect;
import com.redress.models.Department;
import com.redress.models.Technician;
import com.redress.models.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bjena
 */
public class CSRAction {

    private List<User> customerList = null;
    CSR csr = new CSR();
    private boolean noData = false;

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
    private int res_status;

    public String updateComplaints() throws Exception {

        try {
            if (getSubmitType().equals("updatedata")) {
                Complaint complaint = csr.fetchComplaintDetails(complid);
                if (complaint != null) {
                    complid = complaint.getComplid();
                    compltime = complaint.getCompltime();
                    subject = complaint.getSubject();
                    description = complaint.getDescription();
                    pid = complaint.getPid();
                    techid = complaint.getTechid();
                    compl_status = complaint.getCompl_status();
                    startprog = complaint.getStartprog();
                    ongoingprog = complaint.getOngoingprog();
                    endprog = complaint.getEndprog();
                    res_status = complaint.getRes_status();
                }
            } else {
                int i = csr.updateComplaintDetails(complid, compltime, subject, description,
                        pid, techid, compl_status, startprog, ongoingprog, endprog, res_status);
                if (i > 0) {
                    setMsg("Record Updated Successfuly");
                } else {
                    setMsg("error");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "UPDATE";
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
}
