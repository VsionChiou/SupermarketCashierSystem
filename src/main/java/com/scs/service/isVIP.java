package com.scs.service;

import com.scs.dao.getConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class isVIP {
    private Connection conn = null;
    private Statement stmt;
    private PreparedStatement statement;
    private ResultSet res;
    private List list;


    public boolean Vip() {
        boolean i = false ;
        Scanner rd = new Scanner(System.in);
       list = new ArrayList();
        System.out.println("请输入VIP");
        String str = rd.nextLine();

        try {
            //查询当前条码商品//在Jtable中需要加一个序号
            String sql = "SELECT * FROM vip where VIP_ID =" + str;
            stmt = new getConnection().linkConnection().createStatement();
            i= stmt.execute(sql);

        } catch (SQLException e) {
            System.out.println("SQLException");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }




}
