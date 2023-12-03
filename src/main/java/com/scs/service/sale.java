package com.scs.service;

import com.scs.dao.getConnection;

import java.sql.*;

public class sale {

    private Connection conn = null;
    private Statement stmt;
    private PreparedStatement statement;
    private ResultSet res;
    //private List list;

    //利润
    public void saleProfit() {
        int  i = 0;
        try {
            String sql = "SELECT SUM(Co_Price - Co_InPrice) FROM commodity;";

            //// //COON==getConnection().linkConnection()
            stmt = new getConnection().linkConnection().createStatement();

            res = stmt.executeQuery(sql);

        } catch (SQLException e) {
            System.out.println("SQLException");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //return i;
    }
//销售总额
    public double saleVolume() {
        double i = 0;
        try {
            String sql = "SELECT SUM(Co_Price) FROM commodity;";

            //// //COON==getConnection().linkConnection()
            stmt = new getConnection().linkConnection().createStatement();

            res = stmt.executeQuery(sql);
while (res.next()) i=res.getDouble("SUM(Co_Price)");
        } catch (SQLException e) {
            System.out.println("SQLException");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

//查询销售量
    public void saleCount() {
        int  i = 0;
        try {
            String sql = "SELECT * count(Co_Surplus) FROM Record GROUP BY Co_BarCode ORDER BY sale_Number ;";

            //// //COON==getConnection().linkConnection()
            stmt = new getConnection().linkConnection().createStatement();

            res = stmt.executeQuery(sql);

        } catch (SQLException e) {
            System.out.println("SQLException");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //return i;
    }
//计算总价



}
