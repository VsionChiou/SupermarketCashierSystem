package com.scs.view;

import com.scs.dao.insertInfo;
import com.scs.view.WindowModel.UpdateModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteComWindow extends UpdateModel implements ActionListener {
    private JButton Delete;
    public void eighthGird(){

        Delete = new JButton("删除");
        Delete.addActionListener(this);
        Cancel = new JButton("取消");
        Cancel.addActionListener(this);

        eight = new JPanel();

        eight.add(Delete);
        eight.add(Cancel);

        add(eight);
    }
    public void actionPerformed(ActionEvent e){
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
        }
        if(e.getSource()==Cancel){
            System.exit(0);
        }
    }
    public static void main(String[] args){
        new DeleteComWindow();
    }
}
