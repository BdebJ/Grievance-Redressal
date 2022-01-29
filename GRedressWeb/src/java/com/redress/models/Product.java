/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.redress.models;

/**
 *
 * @author ANIRBAN
 */
public class Product {

    private int prodid;
    private int deptid;
    private String prodmodel;
    private String prodname;

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
}
