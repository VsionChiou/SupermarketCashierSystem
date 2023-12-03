package com.scs.dao;

import com.scs.entity.Commodity;
import com.scs.service.isVIP;

import java.sql.*;
import java.util.*;


public class queryInfo {

    public String name,price,inprice,barcode,data,life;
    public int surplus;

    private Connection conn = null;
    private Statement stmt;
    private PreparedStatement statement;
    private ResultSet res;
    public String str = "6908512108245";


    //判断输入值是否为数字
//    public static boolean isNumeric(String str) {
//        for (int i = 0; i < str.length(); i++) {
//            System.out.println(str.charAt(i));
//            if (!Character.isDigit(str.charAt(i))) {
//                return false;
//            }
//        }
//        return true;
//    }

    public Vector queryFromCommodity() {
        Commodity comm;
        Vector vector2 = new Vector();
        List<Commodity> list = new ArrayList<Commodity>();
        try {

            String sql = "SELECT * FROM commodity";
            stmt = new getConnection().linkConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            res = stmt.executeQuery(sql);
            res.beforeFirst();
            while (res.next()) {
                comm = new Commodity();

                comm.setCo_Name(res.getString("Co_Name"));
                comm.setCo_Price(res.getString("Co_Price"));
                comm.setCo_InPrice(res.getString("Co_InPrice"));
                comm.setCo_BarCode(res.getString("Co_BarCode"));
                comm.setCo_Date(res.getString("Co_Date"));
                comm.setShelf_Life(res.getString("Shelf_Life"));
                comm.setCo_Surplus(res.getInt("Co_Surplus"));

                vector2.add(comm.getAllData());
            }

        } catch (SQLException e) {
            System.out.println("SQLException");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vector2;
    }

    public static void main(String args[]) {
        queryInfo inf = new queryInfo();
        inf.queryFromCommodity();

    }
}
