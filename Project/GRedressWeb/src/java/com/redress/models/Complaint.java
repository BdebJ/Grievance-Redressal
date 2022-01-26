/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.redress.models;

/**
 *
 * @author ANIRBAN
 */
public class Complaint {
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
}
