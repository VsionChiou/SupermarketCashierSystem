package com.scs.dao;

import java.sql.*;
import java.util.Scanner;

public class insertInfo {


    private Connection conn = null;
    //private Statement stmt;
    private PreparedStatement statement;
    private ResultSet res;
    public String name, price, inprice, barCode, date, life;
    public String Sname, id, Department, Sex, PhoneID, Income;
    public int surplus,i;

    //private List list;

    //插入商品
    public int insertIntoCommodity() {
/*        Scanner co = new Scanner(System.in);
        int i = 0;



        System.out.println("请输入商品信息：");
        name = co.nextLine();
        price = co.nextLine();
        inprice = co.nextLine();
        barCode = co.nextLine();
        date = co.nextLine();
        life = co.nextLine();
        surplus = co.nextInt();*/


        try {
            String sql = "insert into commodity(Co_Name,Co_Price,Co_InPrice,Co_BarCode,Co_Date,Shelf_Life,Co_Surplus) values(?,?,?,?,?,?,?)";
            //// //COON==getConnection().linkConnection()
            statement = new getConnection().linkConnection().prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, price);
            statement.setString(3, inprice);
            statement.setString(4, barCode);
            statement.setString(5, date);
            statement.setString(6, life);
            statement.setInt(7, surplus);

            i = statement.executeUpdate();
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

    public int insertIntoStaff() {

//        Scanner st = new Scanner(System.in);
        int i = 0;


      /*  System.out.println("请输入员工信息：");

        Sname = st.nextLine();
        id = st.nextLine();
        Department = st.nextLine();
        Sex = st.nextLine();
        PhoneID = st.nextLine();
        Income = st.nextLine();
*/
        try {
            String sql = "insert into staff(Staff_Name,Staff_ID,Staff_Department,Staff_Sex,Staff_Phone,Staff_Income) values(?,?,?,?,?,?)";
            //// //COON==getConnection().linkConnection()
            statement = new getConnection().linkConnection().prepareStatement(sql);
            statement.setString(1, Sname);
            statement.setString(2, id);
            statement.setString(3, Department);
            statement.setString(4, Sex);
            statement.setString(5, PhoneID);
            statement.setString(6, Income);

            i = statement.executeUpdate();
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

    public int insertIntoUsers() {

        Scanner st = new Scanner(System.in);
        int i = 0;
        String User_ID, User_Password;

//        System.out.println("请输入员工信息：");
        User_ID = st.nextLine();
        User_Password = st.nextLine();
        try {
            String sql = "insert into Users(User_ID,User_Password) values(?,?)";
            //// //COON==getConnection().linkConnection()
            statement = new getConnection().linkConnection().prepareStatement(sql);
            statement.setString(1, User_ID);
            statement.setString(2, User_Password);
            i = statement.executeUpdate();
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


    public int insertIntoVIP() {

        Scanner st = new Scanner(System.in);
        int i = 0;
        String name, id, Sex, PhoneID;

        System.out.println("请输入会员信息：");

        name = st.nextLine();
        id = st.nextLine();

        Sex = st.nextLine();
        PhoneID = st.nextLine();


        try {
            String sql = "insert into VIP(VIP_Name,VIP_ID,VIP_Sex,VIP_Phone) values(?,?,?,?)";
            //// //COON==getConnection().linkConnection()
            statement = new getConnection().linkConnection().prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, id);
            statement.setString(3, Sex);
            statement.setString(4, PhoneID);


            i = statement.executeUpdate();
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

    public static void main(String args[]) {
        insertInfo inf = new insertInfo();
        while(true)inf.insertIntoCommodity();
    }


}
