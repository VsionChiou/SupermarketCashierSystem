package com.scs.view;

import com.scs.dao.deleteInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteemployeeWindow extends JFrame implements ActionListener {
    private JButton addButton,Cancel;
    private JLabel idLabel;
    private JTextField idText;
    private JPanel six,seven;
    public DeleteemployeeWindow(){



        sixthGird();

        seventhGird();





        this.setLayout(new GridLayout(2,1));





        this.setSize(400,300);
        this.setVisible(true);
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);



    }
    public void sixthGird(){
        idLabel=new JLabel("工号：");
        idText=new JTextField(20);
        six=new JPanel();
        six.add(idLabel);
        six.add(idText);
        add(six);
    }
    public void seventhGird(){
        addButton = new JButton("删除");
        addButton.addActionListener(this);
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

        deleteInfo dele = new deleteInfo();
        if(e.getSource()==addButton){


            dele.str=idText.getText();

            dele.deleFromstaff();
//            System.out.println(add.i);
            dispose();
        }
        if(e.getSource()==Cancel){
            dispose();
        }
    }
    public static void main(String[] args){
        new DeleteemployeeWindow();
    }
}