/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.svm.lrp.exp.kmn.vo;

import java.io.Serializable;

/**
 *
 * @author Kavithanjali.M
 */
public class BkdVo implements Serializable{
    public String Booknumber;
    public int amount;

    public String getContainernumber() {
        return containernumber;
    }

    public void setContainernumber(String containernumber) {
        this.containernumber = containernumber;
    }
    public String containernumber;
    public String Package;

    public String getCommodity() {
        return Commodity;
    }

    public void setCommodity(String Commodity) {
        this.Commodity = Commodity;
    }
    public String Commodity;
    
    public String paytype;
    public String paymode;
    public String prepaid;
    public String payat;

    public String getPayat() {
        return payat;
    }

    public void setPayat(String payat) {
        this.payat = payat;
    }
    public String collect;
    
    public String paylocation;
    public String Export;
    public String Import;
    public int Totalprepaidcount;
    public int Totalcollectcount;
    public int Totalpayatcount;
    public int TotalAmount;

    public String getBooknumber() {
        return Booknumber;
    }

    public void setBooknumber(String Booknumber) {
        this.Booknumber = Booknumber;
    }

   

    public String getPackage() {
        return Package;
    }

    public void setPackage(String Package) {
        this.Package = Package;
    }

   

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getPaytype() {
        return paytype;
    }

    public void setPaytype(String paytype) {
        this.paytype = paytype;
    }

    public String getPaymode() {
        return paymode;
    }

    public void setPaymode(String paymode) {
        this.paymode = paymode;
    }

    public String getPrepaid() {
        return prepaid;
    }

    public void setPrepaid(String prepaid) {
        this.prepaid = prepaid;
    }

    public String getCollect() {
        return collect;
    }

    public void setCollect(String collect) {
        this.collect = collect;
    }

   

    public String getPaylocation() {
        return paylocation;
    }

    public void setPaylocation(String paylocation) {
        this.paylocation = paylocation;
    }

    public String getExport() {
        return Export;
    }

    public void setExport(String Export) {
        this.Export = Export;
    }

    public String getImport() {
        return Import;
    }

    public void setImport(String Import) {
        this.Import = Import;
    }

    public int getTotalprepaidcount() {
        return Totalprepaidcount;
    }

    public void setTotalprepaidcount(int Totalprepaidcount) {
        this.Totalprepaidcount = Totalprepaidcount;
    }

    public int getTotalcollectcount() {
        return Totalcollectcount;
    }

    public void setTotalcollectcount(int Totalcollectcount) {
        this.Totalcollectcount = Totalcollectcount;
    }

    public int getTotalpayatcount() {
        return Totalpayatcount;
    }

    public void setTotalpayatcount(int Totalpayatcount) {
        this.Totalpayatcount = Totalpayatcount;
    }

    public int getTotalAmount() {
        return TotalAmount;
    }

    public void setTotalAmount(int TotalAmount) {
        this.TotalAmount = TotalAmount;
    }

  

   

}
