package com.scs.view;

import com.scs.service.sale;
import com.scs.view.WindowModel.ManageModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

public class dataManagerWindow extends ManageModel {
    JLabel data,da;



    public JPanel getInfoPanel(){
        infoPanel = new JPanel(new BorderLayout());

/*        addButton = new JButton("添加记录");
        addButton.setPreferredSize(new Dimension(100,60));
        deleteButton = new JButton("删除记录");
        deleteButton.setPreferredSize(new Dimension(100,60));*/

        sale Sale = new sale();
        String s=String.valueOf(Sale.saleVolume());
        data = new JLabel("销售额：");
        da = new JLabel(s);
        JPanel infoOne = new JPanel();
        JLabel jLabel = new JLabel("销售管理系统");

        JPanel infoTwo = new JPanel();

        infoOne.add(jLabel);

        infoTwo.add(data);
        infoTwo.add(da);


        infoPanel.add(infoOne,BorderLayout.EAST);
        infoPanel.add(infoTwo,BorderLayout.CENTER);
        infoPanel.setPreferredSize(new Dimension(1000,80));
        return infoPanel;

    }
    public JPanel getCardPanel(){
        cardPanel = new JPanel(cardLayout);

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

        jTable1.setModel(model);
//        modelTable1.setModel(model1);
        modelScrolPane = new JScrollPane(jTable1);
//        modelScrolPane1 = new JScrollPane(modelTable1);

        modelScrolPane.setPreferredSize(new Dimension(1000,850));            // 设置滚动面板大小
//        modelScrolPane1.setPreferredSize(new Dimension(1000,850));            // 设置滚动面板大小



        chooseOne = new JPanel();
        chooseOne.add(modelScrolPane);
     /*   chooseTwo = new JPanel();
        chooseTwo.add(modelScrolPane1);*/

        choose=new JTabbedPane();
        choose.add("销售信息",chooseOne);
//        choose.add("",chooseTwo);

        cardPanel.add(choose);

        return cardPanel;


    }

    public static void main(String[] args){
        new dataManagerWindow();
    }
}
