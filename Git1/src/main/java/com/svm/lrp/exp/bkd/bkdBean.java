/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.svm.lrp.exp.bkd;

import com.svm.lrp.exp.kmn.vo.BkdVo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.annotation.Resources;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import lrp.serverutils.refs.ServerObject;

/**
 *
 * @author martin
 */
@Stateless
@LocalBean
//@Resource(name = "jdbc/ClientDB", mappedName = "java:/DOCDS")
@Resources({
    @javax.annotation.Resource(name = "jdbc/DOCDS", mappedName = "java:/DOCDS")})
public class bkdBean implements bkdLocal {

    Logger logger;

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    boolean flag = false;
    BkdVo voo = null;

    @Override
    public ArrayList<BkdVo> getdata() {
        ArrayList<BkdVo> data = new ArrayList<>();
        try {

            System.out.println("--inside getdata");
            con = new ServerObject("DOCDS").getConnection();
            ps = con.prepareStatement("select Booknumber,Commodity,amount,Package,paymode,paytype,containernumber,paylocation,Totalprepaidcount,Totalcollectcount,Totalpayatcount,TotalAmount  from BookDetails(nolock)");
            rs = ps.executeQuery();

            while (rs.next()) {
                //ctrl vo set panna
                voo = new BkdVo();
                voo.setBooknumber(rs.getString("Booknumber"));//getstring method used get the column value
                voo.setCommodity(rs.getString("Commodity"));
                voo.setAmount(rs.getInt("amount"));

                voo.setPackage(rs.getString("Package"));

                voo.setPaymode(rs.getString("paymode"));
                voo.setPaytype(rs.getString("paytype"));
                voo.setContainernumber(rs.getString("containernumber"));
                voo.setPaylocation(rs.getString("paylocation"));

                voo.setTotalprepaidcount(rs.getInt("Totalprepaidcount"));
                
                voo.setTotalcollectcount(rs.getInt("Totalcollectcount"));
                voo.setTotalpayatcount(rs.getInt("Totalpayatcount"));
                voo.setTotalAmount(rs.getInt("TotalAmount"));
                System.out.println("************vo details added**********");
                data.add(voo);
                System.out.println("--------------");

            }
            rs.close();
        } catch (Exception e) {
            System.out.println("retrive the vo details" + e);
            e.printStackTrace();
        } finally {
            try {
                con.close();
//            try {
//                if (con != null) {
//                    ps = null;
//                    con.close();
//                }
//
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
            } catch (SQLException ex) {
                Logger.getLogger(bkdBean.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return data;
    }

    @Override
    public String save(BkdVo vo) {
        //vo la set panna value get panran and query ku anupuran
        try {
            System.out.println("1.saved in vo");
            if (flag == false) {
                //con = new ServerObject().getConnection();
                con = new lrp.serverutils.refs.ServerObject("DOCDS").getConnection();
                ps = con.prepareStatement("insert into BookDetails(Booknumber,Commodity,amount,package,paymode,paytype,containernumber,paylocation,totalprepaidcount,totalcollectcount,totalpayatcount,totalamount)values(?,?,?,?,?,?,?,?,?,?,?,?)");
                ps.setString(1, vo.getBooknumber());
                ps.setString(2, vo.getCommodity());
                ps.setInt(3, vo.getAmount());
                ps.setString(4, vo.getPackage());
                ps.setString(5, vo.getPaymode());
                ps.setString(6, vo.getPaytype());
                ps.setString(7, vo.getContainernumber());
                ps.setString(8, vo.getPaylocation());
                ps.setInt(9, vo.getTotalprepaidcount());
                ps.setInt(10, vo.getTotalcollectcount());
                ps.setInt(11, vo.getTotalpayatcount());
                ps.setInt(12, vo.getTotalAmount());

                System.out.println("2.saved in vo");
                ps.executeUpdate();
                System.out.println("3.saved in vo");
            } else {
                //  con = new ServerObject().getConnection();
                con = new lrp.serverutils.refs.ServerObject("DOCDS").getConnection();
                ps = con.prepareStatement("update into BookDetails set package=?,paymode=?,paytype=?,containernumber=?,paylocation=?,totalprepaidcount=?,totalcollectcount=?,totalpayatcount=?,totalamount=? where Booknumber=?");
                ps.setString(1, vo.getBooknumber());
                ps.setString(2, vo.getCommodity());
                ps.setInt(3, vo.getAmount());
                ps.setString(4, vo.getPackage());
                ps.setString(5, vo.getPaymode());
                ps.setString(6, vo.getPaytype());
                ps.setString(7, vo.getContainernumber());
                ps.setString(8, vo.getPaylocation());
                ps.setInt(9, vo.getTotalprepaidcount());
                ps.setInt(10, vo.getTotalcollectcount());
                ps.setInt(11, vo.getTotalpayatcount());
                ps.setInt(12, vo.getTotalAmount());
                ps.executeUpdate();

            }

        } catch (Exception e) {
            System.out.println("com.svm.lrp.exp.bkd.bkdBean.save()" + e);
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public String deleteaction(String Booknumber1) {
        System.out.println("insdie delete method");
        String status = "unsucessfully";
        try {
            con = new lrp.serverutils.refs.ServerObject("DOCDS").getConnection();
            ps = con.prepareStatement("delete from BookDetails where Booknumber=?");
            ps.setString(1, Booknumber1);
          //  System.out.println("getbooknumber" + voo.getBooknumber());
            ps.executeUpdate();
            System.out.println("insdieee delete method");
            status = "sucessfully";
            System.out.println("com.svm.lrp.exp.bkd.bkdBean.deleteaction()");
        } catch (Exception e) {
            System.out.println("com.svm.lrp.exp.bkd.bkdBean.deleteaction()" + e);
            e.printStackTrace();
        }
        System.out.println("deleteaction()" + status);
        return status;

    }


//    public ArrayList<BkdVo> getdatass() {
//        ArrayList<BkdVo> data = new ArrayList<>();
//        try {
//
//            System.out.println("--inside 4getdatass");
//            con = new ServerObject("DOCDS").getConnection();
//            ps = con.prepareStatement("select Totalprepaidcount  from BookDetails(nolock)");
//            rs = ps.executeQuery();
//
//            while (rs.next()) {
//                
//              BkdVo  vo1 = new BkdVo();
//                
//
//                vo1.setTotalprepaidcount(rs.getInt("Totalprepaidcount"));
//                
//                ;
//                System.out.println("************vo detail111s added**********");
//                data.add(vo1);
//                System.out.println("--------------");
//
//            }
//            rs.close();
//        } catch (Exception e) {
//            System.out.println("retrive the141 vo details" + e);
//            e.printStackTrace();
//        } 
//
//        
//        return data;
//    }
//      public ArrayList<BkdVo> getdatass1() {
//        ArrayList<BkdVo> data = new ArrayList<>();
//        try {
//
//            System.out.println("--inside2 getdatass");
//            con = new ServerObject("DOCDS").getConnection();
//            ps = con.prepareStatement("select Totalcollectcount from BookDetails(nolock)");
//            rs = ps.executeQuery();
//
//            while (rs.next()) {
//                
//              BkdVo  vo1 = new BkdVo();
//                
//
//                
//                
//                vo1.setTotalcollectcount(rs.getInt("Totalcollectcount"));
//                
//                System.out.println("************vo detail111s added**********");
//                data.add(vo1);
//                System.out.println("--------------");
//
//            }
//            rs.close();
//        } catch (Exception e) {
//            System.out.println("retrive the112 vo details" + e);
//            e.printStackTrace();
//        } 
//
//        
//        return data;
//    }
//        public ArrayList<BkdVo> getdatass2() {
//        ArrayList<BkdVo> data = new ArrayList<>();
//        try {
//
//            System.out.println("--inside getggdatass");
//            con = new ServerObject("DOCDS").getConnection();
//            ps = con.prepareStatement("select Totalpayatcount from BookDetails(nolock)");
//            rs = ps.executeQuery();
//
//            while (rs.next()) {
//                
//              BkdVo  vo1 = new BkdVo();
//                
//
//              
//                vo1.setTotalpayatcount(rs.getInt("Totalpayatcount"));
//               
//                System.out.println("************vo detasdsdsd11s added**********");
//                data.add(vo1);
//                System.out.println("--------------");
//
//            }
//            rs.close();
//        } catch (Exception e) {
//            System.out.println("retrive tsdsd11 vo details" + e);
//            e.printStackTrace();
//        } 
//
//        
//        return data;
//    }
//          public ArrayList<BkdVo> getdatass3() {
//        ArrayList<BkdVo> data = new ArrayList<>();
//        try {
//
//            System.out.println("--inside getdatass");
//            con = new ServerObject("DOCDS").getConnection();
//            ps = con.prepareStatement("select TotalAmount  from BookDetails(nolock)");
//            rs = ps.executeQuery();
//
//            while (rs.next()) {
//                
//              BkdVo  vo1 = new BkdVo();
//                
//
//                
//                vo1.setTotalAmount(rs.getInt("TotalAmount"));
//                System.out.println("************vo ddfdfdfdfail111s added**********");
//                data.add(vo1);
//                System.out.println("-------dfdf-------");
//
//            }
//            rs.close();
//        } catch (Exception e) {
//            System.out.println("retrive df1 vo details" + e);
//            e.printStackTrace();
//        } 
//
//        
//        return data;
//    }
//}
}