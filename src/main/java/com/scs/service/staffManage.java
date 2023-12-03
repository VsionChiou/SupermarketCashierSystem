package com.scs.service;

import com.scs.dao.getConnection;
import com.scs.dao.updataInfo;

import java.sql.*;
import java.util.Scanner;

public class staffManage {

    private Connection conn = null;
    private Statement stmt;
    private PreparedStatement statement;
    private ResultSet res;
    //private List list;

    //插入商品
    public int updateIntoStaff() {
        Scanner co = new Scanner(System.in);
        int i = 0;
        String ID, row, data;
        System.out.println("请输入员工信息：");
        //文本控件
        ID = co.nextLine();
        row = co.nextLine();
        data = co.nextLine();
        try {
            String sql = "update staff set  "+row+" = \""+data+"\"where staff_ID = \""+ID+"\"";

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
