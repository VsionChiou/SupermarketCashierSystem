package com.scs.view;

import com.scs.dao.queryInfo;
import com.scs.entity.Commodity;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import static javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS;

public class mainWindow extends JFrame implements ActionListener{

    JButton ManageCom,ManageEmployee,AnalysisData,AddCom,DeleteCom,Update,Classify;
    JPanel north,center,south;
    Vector rowData, columnNames;
    JTable jt=null;
    JScrollPane jsp=null;

    public static void main(String[] args) {
        mainWindow main_w = new mainWindow();
    }
    public mainWindow() {
        ManageCom = new JButton("商品管理");
        ManageEmployee = new JButton("员工切换");
        AnalysisData = new JButton("数据分析");
        AddCom = new JButton("添加商品");
        AddCom.addActionListener(this);
        DeleteCom = new JButton("删除商品");
        Update = new JButton("更新");
        Classify = new JButton("分类");

        north= new JPanel();
        center = new JPanel();
        south = new JPanel();

        queryInfo queryInfo = new queryInfo();
        Vector vector2= queryInfo.queryFromCommodity();
        System.out.println(vector2.size());

        columnNames= new Vector();
        columnNames.add("序号");
        columnNames.add("类别");
        columnNames.add("名称");
        columnNames.add("单价");
        columnNames.add("数量");

        columnNames.add("折扣");
        columnNames.add("7th");

        //初始化JTable
        jt=new JTable(vector2,columnNames);
        jt.setAutoResizeMode(AUTO_RESIZE_ALL_COLUMNS);

        //初始化jsp JScrollPane
        jsp=new JScrollPane(jt);
//        jsp.setPreferredScrollableViewportSize(new Dimension(100,100));
//        jsp.setRowHeight(50);
        center.setBounds(200,250,100,150);


        jt.setBounds(100,200,400,300);
        north.add(ManageCom);
        north.add(ManageEmployee);
        north.add(AnalysisData);

        center.add(jsp);

        south.add(AddCom);
        south.add(DeleteCom);
        south.add(Classify);
        south.add(Update);

        //把jsp放入到 jFrame

        this.add(north,"North");
        this.add(center);
        this.add(south,"South");

        this.setBounds(250,100,1500,800);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        jt.setFillsViewportHeight(true);
        jt.setAutoResizeMode(AUTO_RESIZE_ALL_COLUMNS);
        this.setVisible(true);

    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==AddCom){
            new AddComWindow();
        }
    }
    }

