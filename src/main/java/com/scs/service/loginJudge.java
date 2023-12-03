package com.scs.service;

import com.scs.dao.getConnection;

import java.sql.*;
import java.util.Scanner;

public class loginJudge {
    private Connection conn = null;
    private Statement stmt;
    private PreparedStatement statement;
    private ResultSet res,rs;
    //private List list;

    //public  String user, password;
    public String use, pass , depart;
    public  String user=null,password=null;
    public boolean userJudge() {
        Scanner co = new Scanner(System.in);
        boolean bo= false, boo = false;
        boolean i = false;
        //文本控件
        //user = co.nextLine();
        //password = co.nextLine();

        try {

            String sql = "SELECT * from Users where User_ID = "+ user;
            //// //COON==getConnection().linkConnection()
            stmt = new getConnection().linkConnection().createStatement();
            res = stmt.executeQuery(sql);
            while(res.next()) {
                use = res.getString("User_ID");
                pass = res.getString("User_password");
            }
            use = String.valueOf(use);
            pass = String.valueOf(pass);
            System.out.println(use);
            System.out.println(user);
            System.out.println(pass);
            System.out.println(password);

            bo = use.equals(user);//比较 输入用户名和表内名
            System.out.println(boo);
            if (bo) {
                boo = pass.equals(password);
                if (boo) {
                    sql = "SELECT * from staff where staff_ID = "+ user;
                    rs = stmt.executeQuery(sql);
                    while(rs.next()) {
                        depart = rs.getString("Staff_Department");
                    }
                    i = true;

                } else {
                    i = false;

                }

            } else {
                i = false;

            }
        } catch (SQLException e) {
            System.out.println("SQLException");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }
}
