package com.scs.view;

import com.scs.dao.updataInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModifyComWindow extends JFrame implements ActionListener {

    private JPanel five,six,seven,eight;
    private JLabel barCodeLabel,rowLabel,dataLabel;
    private JTextField barCodeText,rowText,dataText;
    private JButton Add,Cancel;


    public ModifyComWindow(){


        fifthGird();

        sixthGird();

        seventhGird();

        eighthGird();




        this.setLayout(new GridLayout(4,1));





        this.setSize(400,300);
        this.setVisible(true);
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);



    }

    public void fifthGird(){

        barCodeLabel = new JLabel("条码：");
        barCodeText = new JTextField(20);

        five = new JPanel();
        five.add(barCodeLabel);
        five.add(barCodeText);

        add(five);
    }
    public void sixthGird(){
        rowLabel = new JLabel("属性：");
        rowText = new JTextField(20);


        six = new JPanel();

        six.add(rowLabel);
        six.add(rowText);

        add(six);
    }
    public void seventhGird(){
        dataLabel = new JLabel("数据：");
        dataText= new JTextField(20);
        seven = new JPanel();
        seven.add(dataLabel);
        seven.add(dataText);
        add(seven);

    }
    public void eighthGird(){

        Add = new JButton("修改");
        Add.addActionListener(this);
        Cancel = new JButton("取消");
        Cancel.addActionListener(this);

        eight = new JPanel();
        eight.add(Add);
        eight.add(Cancel);
        add(eight);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        updataInfo add = new updataInfo();
        if(e.getSource()==Add){


            add.barCode=barCodeText.getText();
            add.row=rowText.getText();
            add.data=dataText.getText();
            add.updateIntoCommodity();
            dispose();
        }
        if(e.getSource()==Cancel){
            dispose();
        }
    }


    public static void main(String[] args){
        new ModifyComWindow();
    }
}
