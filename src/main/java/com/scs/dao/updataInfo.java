package com.scs.dao;

import java.sql.*;

public class updataInfo {
    private Connection conn = null;
    private Statement stmt;
    private PreparedStatement statement;
    private ResultSet res;
    public String barCode, row, data;


    //private List list;

    //插入商品
    public int updateIntoCommodity() {
//        final String  A = "Co_Name",B="Co_Price",C="Co_InPrice",D="Co_BarCode",E="Co_Date",F="Shelf_Life",G="Co_Surplus";
//        Scanner co = new Scanner(System.in);
        int i = 0;

//        System.out.println("请输入商品信息：");
//        //文本控件
//        barCode = co.nextLine();
//        row = co.nextLine();
//        data = co.nextLine();
        try {
            String sql = "update commodity set  "+row+" = \""+data+"\"where Co_BarCode = \""+barCode+"\"";

            //// //COON==getConnection().linkConnection()
            stmt = new getConnection().linkConnection().createStatement();

            i = stmt.executeUpdate(sql);
            if (i > 0)
                System.out.println("数据插入成功");
        } catch (SQLException e) {
            System.out.println("SQLException");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }
    public static void main(String args[]){
        updataInfo uif = new updataInfo();
        uif.updateIntoCommodity();
    }
}
