package com.scs.dao;

import java.sql.*;
import java.util.List;

public class deleteInfo {
    private Connection conn = null;
    private Statement stmt;
    private PreparedStatement statement;
    private ResultSet res;
    private List list;
    public int saleNum = 0;//顾客编号
    public String str;


    public void deleFromstaff() {
//        Scanner rd = new Scanner(System.in);

//        int Surplus = 0;
//        list = new ArrayList();
//        System.out.println("请输入条码");
//        String str = rd.nextLine();
        //boolean tf = isNumeric(str);
        //是数字，即条码
        try {
            //查询当前条码商品//在Jtable中需要加一个序号
            String sql = "DELETE FROM staff WHERE Staff_ID = " + str;
            stmt = new getConnection().linkConnection().createStatement();
            stmt.executeUpdate(sql);
            String userSql = "DELETE FROM users WHERE User_ID = " + str;
            stmt.executeUpdate(userSql);


          /*  while (res.next()) {
                commodity comm = new commodity();*/
            //String s =res.getString("Co_Name");
            // System.out.println(s);

//            }
        } catch (SQLException e) {
            System.out.println("SQLException");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        return list;
    }


    public static void main(String args[]) {


    }
}

