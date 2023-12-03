package com.scs.view;

import com.scs.dao.queryInfo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class AdminWindow extends EmployeeWindow implements ActionListener {

    private JButton emplpyeeManagerButton,goodsManagerButton,dataManagerButton;
    private DefaultTableModel model,model1;
    JScrollPane jScrollPane2 = new JScrollPane();

    JScrollPane jScrollPane1 = new JScrollPane();
    queryInfo qi = new queryInfo();

    public AdminWindow(){

    }

    public JPanel getButtonPanel(){
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,15,0));
        buttonPanel.setBackground(new Color(242,242,242));

        goodsManagerButton = new JButton("商品管理");
        emplpyeeManagerButton = new JButton("员工管理");
        dataManagerButton = new JButton("销售管理");

        goodsManagerButton.addActionListener(this);
        emplpyeeManagerButton.addActionListener(this);
        dataManagerButton.addActionListener(this);

        buttonPanel.add(goodsManagerButton);
        buttonPanel.add(emplpyeeManagerButton);
        buttonPanel.add(dataManagerButton);

        return buttonPanel;
    }

    public JPanel getGoodsManagerPanel(){
        goodsManagerPanel = new JPanel();
        goodsManagerPanel.setBackground(new Color(242,242,242));
//        goodss = goodsService.getAll();                                // 获取 数据库 所有商品



//        goodsTable = new JTable();
        //定义列名
//        String[]conlumn={"星期一","星期二","星期三","星期四","星期五","星期六","星期七"};//定义列名，连接数据库后获取数据库信息。
/*
        String[][]content=new String[100][7];

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"日期/时间","操作工","产品型号","数量"});

        model.addRow(new Object[]{});

        goodsTable.setModel(model);*/

        Vector vec1 = new Vector();
        Vector vec2 = new Vector();
        Vector vec3 = new Vector();


        vec2.add("库存编号");
        vec2.add("商品条码");
        vec2.add("商品名称");
        vec2.add("商品价格");
        vec2.add("生产日期");
        vec2.add("保质期");
        vec2.add("库存数量");

        vec1.add("0001");
        vec1.add("6908512108230    ");
        vec1.add("旺旺雪饼");
        vec1.add("3.0");
        vec1.add("2018-07-06");
        vec1.add("2019-02-06");
        vec1.add("100");

        vec3.add(vec1);

        JTable jTable1 = new JTable();


//        qi.str= g_SearchFiled.getText();
//        vec1 = qi.queryFromCommodity();
//        jTable1 = Mytable.maketable(vec1, vec2); //显示内容

        DefaultTableModel model = new DefaultTableModel(vec3,vec2);
        jTable1.setModel(model);
//        jScrollPane2.add(jTable1); //把表装入容器


//        goodsTableModel = new MyTableModel();
//        goodsScrolPane = new JScrollPane(getGoodsTable);

//SearchTable();
        goodsScrolPane = new JScrollPane(jTable1);
        goodsScrolPane.setPreferredSize(new Dimension(1920,850));            // 设置滚动面板大小

        add(goodsScrolPane);

        g_NounthPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));     // 查询 商品面板
        g_NounthPanel.setBackground(new Color(242,242,242));
        g_SearchFiled = new JTextField(60);
        g_SearchFiled.setPreferredSize(new Dimension(60,50));
        g_SearchFiled.setText("请输入需要查询商品条码");                                    // 此处未注册 鼠标监听
        g_SearchButton = new JButton("查询");
        g_SearchButton.addActionListener(this);
        g_SearchButton.setPreferredSize(new Dimension(80,50));
//        g_SearchButton.addActionListener(this);
        g_NounthPanel.add(g_SearchFiled);
        g_NounthPanel.add(g_SearchButton);

        g_SouthPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,20,0));
        g_SouthPanel.setBackground(new Color(242,242,242));




        g_AddButton = new JButton("添加商品");
//        g_DeleteButton = new JButton("删除商品");
        g_UpdateButton = new JButton("修改信息");

        g_AddButton.addActionListener(this);
//        g_DeleteButton.addActionListener(this);
        g_UpdateButton.addActionListener(this);

        g_SouthPanel.add(g_AddButton);
//        g_SouthPanel.add(g_DeleteButton);
        g_SouthPanel.add(g_UpdateButton);

        goodsManagerPanel.add(g_NounthPanel,BorderLayout.NORTH);
        goodsManagerPanel.add(goodsScrolPane,BorderLayout.CENTER);
        goodsManagerPanel.add(g_SouthPanel,BorderLayout.SOUTH);


        return goodsManagerPanel;
    }
    //查询表
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==goodsManagerButton){
            new GoodsManageWindow();
        }
        if(e.getSource()==g_SearchButton){

            Vector vec3 = new Vector();
           JTable jTable2 = new JTable();
            vec3.add("库存编号");
            vec3.add("商品编码");
            vec3.add("商品名称");
            vec3.add("库存数量");
            vec3.add("库存数量");
            vec3.add("库存数量");
            vec3.add("库存数量");
            model1=new DefaultTableModel(qi.queryFromCommodity(),vec3);
            jTable2.setModel(model1);
            goodsScrolPane = new JScrollPane(jTable2);

        }
        if(e.getSource()==emplpyeeManagerButton){
            new EmployeeManageWindow();
        }
        if(e.getSource()==dataManagerButton){
            new dataManagerWindow();
        }
        if(e.getSource()==g_AddButton){
            new AddComWindow();
        }
        if(e.getSource()==g_UpdateButton){
            new ModifyComWindow();
        }
    }
    public static void main(String [] args){
        new AdminWindow();
    }
}