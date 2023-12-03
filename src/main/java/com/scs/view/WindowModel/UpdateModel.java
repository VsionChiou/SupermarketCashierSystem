package com.scs.view.WindowModel;
import com.scs.dao.insertInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateModel extends JFrame implements ActionListener {
    protected JLabel CoBarCode_jl,Co_Name_jl,Number_jl,Co_Price_jl,inpriceLabel,lifeLabel,surplusLabel;
    protected JTextField Search,Co_BarCode,Co_Name,Number,Co_Price,inpriceText,lifeText,surplusText;
    protected JButton Add,Cancel,SearchButton;
    protected JPanel one,two,three,four,five,six,seven,eight;

    public static void main(String[] args){
        new UpdateModel();
    }

    public UpdateModel(){


        firstGrid();

        twiceGrid();

        thirdGird();

        fourthGird();

        fifthGird();

        sixthGird();

        seventhGird();

        eighthGird();




        this.setLayout(new GridLayout(8,1));





        this.setSize(400,300);
        this.setVisible(true);
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);



    }

    public void firstGrid(){

        one = new JPanel();

        inpriceLabel = new JLabel("进         价：");
        inpriceText = new JTextField(20);



        one.add(inpriceLabel);
        one.add(inpriceText);

        add(one);
    }
    public void twiceGrid(){
        two = new JPanel();

        Co_Name_jl = new JLabel("商  品  名：");
        Co_Name = new JTextField(20);

        two.add(Co_Name_jl);
        two.add(Co_Name);
        add(two);
    }
    public void thirdGird(){
        CoBarCode_jl = new JLabel("商品条码：");
        Co_BarCode = new JTextField(20);

        three = new JPanel();

        three.add(CoBarCode_jl);
        three.add(Co_BarCode);

        add(three);

    }
    public void fourthGird(){
        Number_jl = new JLabel("生产日期：");
        Number = new JTextField(20);

        four = new JPanel();
        four.add(Number_jl);
        four.add(Number);

        add(four);
    }
    public void fifthGird(){

        Co_Price_jl = new JLabel("商品价格：");
        Co_Price = new JTextField(20);

        five = new JPanel();
        five.add(Co_Price_jl);
        five.add(Co_Price);

        add(five);
    }
    public void sixthGird(){
        surplusLabel = new JLabel("数          量：");
        surplusText = new JTextField(20);


        six = new JPanel();

        six.add(surplusLabel);
        six.add(surplusText);

        add(six);
    }
    public void seventhGird(){
        lifeLabel = new JLabel("保   质   期：");
        lifeText = new JTextField(20);
        seven = new JPanel();
        seven.add(lifeLabel);
        seven.add(lifeText);
        add(seven);

    }
    public void eighthGird(){

        Add = new JButton("添加");
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

        insertInfo add = new insertInfo();
        if(e.getSource()==Add){


            add.name=Co_Name.getText();
            add.price=Co_Price.getText();
            add.inprice=inpriceText.getText();
            add.barCode=Co_BarCode.getText();
            add.date=Number.getText();
            add.life=lifeText.getText();
            add.surplus=Integer.parseInt(surplusText.getText());
            add.insertIntoCommodity();
            dispose();
        }
        if(e.getSource()==Cancel){
            dispose();
        }
    }
}
