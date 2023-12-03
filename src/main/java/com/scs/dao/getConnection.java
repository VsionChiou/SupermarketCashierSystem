package com.scs.dao;

import java.sql.*;
import java.lang.*;

public class getConnection {
    // JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/spmmgts?useUnicode=true&characterEncoding=utf8&useSSL=true&serverTimezone=GMT";
    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASSWORD = "12345666";

    private Connection conn = null;
    private Statement stmt;
    //private PreparedStatement statement;
    private ResultSet res;
    //private List list;

    public Connection linkConnection() {

        try {
            System.out.println("正在链接数据库");//GUI可以用进度条或者弹窗
            Class.forName(JDBC_DRIVER);//驱动
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);//链接数据库
            stmt = conn.createStatement();
            System.out.println("链接成功！");

        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException");
            e.printStackTrace();
        } catch (Exception b) {
            b.printStackTrace();
        }
        return conn;
    }

    public void createTableUsers() {
        try {
            //// //COON==getConnection().linkConnection()
            stmt = new getConnection().linkConnection().createStatement();

            //如果不存在 创建表,
            String sql = "create table  IF NOT EXISTS Users(" +
                    "User_ID CHAR(9) not null primary key ," +
                    "User_Password CHAR (16) not null" +
                    ")charset=utf8;";
            stmt.executeUpdate(sql);
            System.out.println("成功创建表！");

        } catch (SQLException e) {
            System.out.println("SQLException");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //创建商品表
    public void createTableCommodity() {
        try {
            //// //COON==getConnection().linkConnection()
            stmt = new getConnection().linkConnection().createStatement();
            //如果不存在 创建表,
            String sql = "create table  IF NOT EXISTS commodity (" +
                    "Co_Name varchar(20) not null ," +
                    "Co_Price double not null," +
                    "Co_InPrice double not null," +
                    "Co_BarCode char(13) primary key not null ," +
                    "Co_Date DATE not null," +
                    "Shelf_Life DATE not null ," +
                    "Co_Surplus int not null " +
                    ")charset=utf8;";
            stmt.executeUpdate(sql);
            System.out.println("成功创建表！");
        } catch (SQLException e) {
            System.out.println("SQLException");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createTableRecord() {
        try {
            //// //COON==getConnection().linkConnection()
            stmt = new getConnection().linkConnection().createStatement();
            //如果不存在 创建表,
            String sql = "create table  IF NOT EXISTS Record (" +
                    "sale_Number char(8) ," +
                    "isVip char(1)," +
                    "sale_Date DATETIME not null primary key ," +
                    "Co_Name varchar(20) not null ," +
                    "Co_Price double not null," +
                    "Co_InPrice double not null," +
                    "Co_BarCode char(13) not null ," +
                    "Co_Date DATE not null," +
                    "Shelf_Life DATE not null ," +
                    "amount int " +
                    ")charset=utf8;";
            stmt.executeUpdate(sql);
            System.out.println("成功创建表！");
        } catch (SQLException e) {
            System.out.println("SQLException");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//创建员工表

    public void createTableStaff() {
        try {
            //// //COON==getConnection().linkConnection()
            stmt = new getConnection().linkConnection().createStatement();

            //如果不存在 创建表,
            String sql = "create table  IF NOT EXISTS Staff(" +
                    "Staff_Name varchar(20) not null," +
                    "Staff_ID CHAR(9) not null primary key ," +
                    "Staff_Department char(20) not null ," +
                    "Staff_Sex char(2) not null ," +
                    "Staff_Phone CHAR (11) not null," +
                    "Staff_Income double(10,2) not null " +
                    ")charset=utf8;";
            stmt.executeUpdate(sql);
            System.out.println("成功创建表！");

        } catch (SQLException e) {
            System.out.println("SQLException");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //创建vip表
    public void createTableVIP() {
        try {
            //// //COON==getConnection().linkConnection()
            stmt = new getConnection().linkConnection().createStatement();

            //如果不存在 创建表,
            String sql = "create table  IF NOT EXISTS VIP(" +
                    "VIP_Name varchar(20) not null," +
                    "VIP_ID CHAR(9) not null primary key ," +
                    "VIP_Sex char(2) not null ," +
                    "VIP_Phone CHAR(11) not null" +
                    ")charset=utf8;";
            stmt.executeUpdate(sql);
            System.out.println("成功创建表！");
        } catch (SQLException e) {
            System.out.println("SQLException");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        getConnection DBA = new getConnection();

        DBA.createTableUsers();
//        DBA.createTableCommodity();
//        DBA.createTableStaff();
//        DBA.createTableVIP();
//        DBA.createTableRecord();
    }
}
