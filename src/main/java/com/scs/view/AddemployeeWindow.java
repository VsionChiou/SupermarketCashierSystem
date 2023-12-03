package com.scs.view;

import com.scs.dao.insertInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddemployeeWindow extends JFrame implements ActionListener {
    JPanel one,two,three,four,five,six,seven;
    JLabel nameLabel,inLabel,phoneLabel,sexLabel,deLabel,idLabel;
    JTextField nameText,inText,phoneText,sexText,deText,idText;
    JButton addButton,Cancel;

    public static void main(String[] args){
        new AddemployeeWindow();
    }

    public AddemployeeWindow(){




        firstGrid();

        twiceGrid();

        thirdGird();

        fourthGird();

        fifthGird();

        sixthGird();

        seventhGird();





        this.setLayout(new GridLayout(7,1));





        this.setSize(400,300);
        this.setVisible(true);
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);



    }

    public void firstGrid(){

        one = new JPanel();

        nameLabel = new JLabel("姓名：");
        nameText = new JTextField(20);



        one.add(nameLabel);
        one.add(nameText);

        add(one);
    }
    public void twiceGrid(){
        two = new JPanel();

        idLabel = new JLabel("工号：");
        idText = new JTextField(20);

        two.add(idLabel);
        two.add(idText);
        add(two);
    }
    public void thirdGird(){
        deLabel = new JLabel("部门：");
        deText = new JTextField(20);

        three = new JPanel();

        three.add(deLabel);
        three.add(deText);

        add(three);

    }
    public void fourthGird(){
        sexLabel = new JLabel("性别：");
        sexText = new JTextField(20);

        four = new JPanel();
        four.add(sexLabel);
        four.add(sexText);

        add(four);
    }
    public void fifthGird(){

        phoneLabel = new JLabel("电话号码：");
        phoneText = new JTextField(20);

        five = new JPanel();
        five.add(phoneLabel);
        five.add(phoneText);

        add(five);
    }
    public void sixthGird(){
        inLabel = new JLabel("收            入：");
        inText = new JTextField(20);


        six = new JPanel();

        six.add(inLabel);
        six.add(inText);

        add(six);
    }
    public void seventhGird(){
        addButton = new JButton("添加");
        addButton.addActionListener(this);
        Cancel = new JButton("取消");
        Cancel.addActionListener(this);
        seven = new JPanel();
        seven.add(addButton);
        seven.add(Cancel);
        add(seven);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        insertInfo add = new insertInfo();
        if(e.getSource()==addButton){


            add.Sname=nameText.getText();
            add.id=idText.getText();
            add.Department=deText.getText();
            add.Sex=sexText.getText();
            add.PhoneID=phoneText.getText();
            add.Income=inText.getText();
            add.insertIntoStaff();
//            System.out.println(add.i);
            dispose();
        }
        if(e.getSource()==Cancel){
            dispose();
        }
    }
}
