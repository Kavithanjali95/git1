/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.svm.lrp.exp.bkd;

import com.svm.lrp.exp.kmn.vo.BkdVo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kavithanjali.M
 */
public abstract interface bkdLocal {
      public  ArrayList<BkdVo> getdata();//retrieving data from table
    public String  save(BkdVo vo);//save thdtae value in all parameters state =save or update
    public String deleteaction(String Booknumber1);
//     public ArrayList<BkdVo> getdatass();
//     public ArrayList<BkdVo> getdatass1();
//     public ArrayList<BkdVo> getdatass2();
//     public ArrayList<BkdVo> getdatass3();
     
}
