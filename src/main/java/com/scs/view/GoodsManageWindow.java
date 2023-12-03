package com.scs.view;

import com.scs.dao.queryInfo;
import com.scs.view.WindowModel.ManageModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class GoodsManageWindow extends ManageModel implements ActionListener {
    private JTable table;
    private JScrollPane jsp;
    private DefaultTableModel dtm;

    queryInfo qi =new queryInfo();
    public GoodsManageWindow(){

    }
    public JPanel getInfoPanel(){
        infoPanel = new JPanel(new BorderLayout());

        addButton = new JButton("添加商品");
        addButton.setPreferredSize(new Dimension(100,60));
        addButton.addActionListener(this);
       /* deleteButton = new JButton("删除商品");
        deleteButton.setPreferredSize(new Dimension(100,60));*/

        JPanel infoOne = new JPanel();
        JLabel jLabel = new JLabel("商品管理系统");

        JPanel infoTwo = new JPanel();

        infoOne.add(jLabel);

        infoTwo.add(addButton);
//        infoTwo.add(deleteButton);


        infoPanel.add(infoOne,BorderLayout.EAST);
        infoPanel.add(infoTwo,BorderLayout.WEST);
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

        modelScrolPane = new JScrollPane(jTable1);

        modelScrolPane.setPreferredSize(new Dimension(1000,850));            // 设置滚动面板大小



//        chooseOne = new JPanel();
//        chooseOne.add(modelScrolPane);
        chooseTwo = new JPanel();
        chooseTwo.add(modelScrolPane);

        choose=new JTabbedPane();
//        choose.add("所有商品",chooseOne);
        choose.add("所有商品",chooseTwo);

        cardPanel.add(choose);

        return cardPanel;


    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==addButton){
            new AddComWindow();
        }
    }

    public static void main(String[] args){
        new GoodsManageWindow();
    }

}