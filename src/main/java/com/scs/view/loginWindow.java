package com.scs.view;

import com.scs.service.loginJudge;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class loginWindow extends JFrame implements ActionListener {

    private static int count = 0;
    private static JButton bt1;//登陆按钮
    private static JButton bt2;//忘记密码按钮
    private static JLabel jl_1;//登录的版面
    //    private static JFrame jf_1;//登陆的框架
    private static JTextField jtext1;//用户名
    private static JPasswordField jtext2;//密码
    private static JLabel jl_title;
    private static JLabel jl_admin;
    private static JLabel jl_password;
//    private JComboBox<String> chooseLogin;
    // private String idenfiy = "";

    String account = null ;
    String password = null;
    // private AdminService adminService = ServiceFactory.getAdminService();
    //private EmployeeService employeeService = ServiceFactory.getEmployeeService();

    public loginWindow() {//初始化登陆界面
        Font font = new Font("黑体", Font.PLAIN, 20);//设置字体

        jl_1 = new JLabel();

        jl_title = new JLabel("欢迎使用超市收银系统");
        jl_title.setBounds(80, 5, 200, 50);
        jl_title.setFont(font);

        jl_admin = new JLabel("工          号");
        jl_admin.setBounds(20, 50, 60, 50);
        //jl_admin.setFont(font);

        jl_password = new JLabel("密          码");
        jl_password.setBounds(20, 100, 60, 50);
        //jl_password.setFont(font);
//
//        String[] identity = {"收银员", "管理员"};
//        chooseLogin = new JComboBox<String>(identity);
//        chooseLogin.setBounds(100, 150, 200, 50);

        bt1 = new JButton("登陆");         //更改成loginButton
        bt1.setBounds(80, 300, 100, 50);
        //bt1.setFont(font);
        bt1.addActionListener(this);

        bt2 = new JButton("退出");
        bt2.setBounds(220, 300, 100, 50);
        //bt2.setFont(font);
        bt2.addActionListener(this);

        //加入文本框
        jtext1 = new JTextField();
        jtext1.setBounds(100, 60, 200, 30);
        //jtext1.setFont(font);

        jtext2 = new JPasswordField();//密码输入框
        jtext2.setBounds(100, 110, 200, 30);
        //jtext2.setFont(font);


        jl_1.add(jl_title);
        jl_1.add(jtext1);
        jl_1.add(jtext2);
//        jl_1.add(chooseLogin);

        jl_1.add(jl_admin);
        jl_1.add(jl_password);
        jl_1.add(bt1);
        jl_1.add(bt2);


        this.add(jl_1);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setLocation(650, 300);
        this.setBounds(650,300,400,400);


    }




    public void actionPerformed(ActionEvent e) {

        loginJudge LG = new loginJudge();
        if (e.getSource() == bt1) {

            LG.user = String.valueOf(jtext1.getText());

            LG.password = String.valueOf(jtext2.getPassword());
            //String password =
//            idenfiy = (String) chooseLogin.getSelectedItem();


            if(LG.userJudge()&&LG.depart.equals("董事会")){
                dispose();
                new AdminWindow();

            }else if(LG.userJudge()&&(LG.depart.equals("收银部")||LG.depart.equals("销售部"))){
                new EmployeeWindow();
                dispose();

            }

        }
        else if(e.getSource()==bt2){
            System.exit(0);
        }
    }


    public static void main(String[] args) {
        //初始化登陆界面

        loginWindow login_w = new loginWindow();

        loginJudge LoginJudge = new loginJudge();




        //登陆点击事件

    }
}