package com.scs.view;

import com.scs.view.WindowModel.ManageModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class EmployeeManageWindow extends ManageModel implements ActionListener{
    public JPanel getInfoPanel(){
        infoPanel = new JPanel(new BorderLayout());

        addButton = new JButton("添加员工");
        addButton.setPreferredSize(new Dimension(100,60));
        addButton.addActionListener(this);
        deleteButton = new JButton("删除员工");
        deleteButton.setPreferredSize(new Dimension(100,60));
        deleteButton.addActionListener(this);

        JPanel infoOne = new JPanel();
        JLabel jLabel = new JLabel("员工管理系统");

        JPanel infoTwo = new JPanel();

        infoOne.add(jLabel);

        infoTwo.add(addButton);
        infoTwo.add(deleteButton);


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
        Vector vec4 = new Vector();


        vec2.add("姓名");
        vec2.add("工号");
        vec2.add("部门");
        vec2.add("性别");
        vec2.add("电话号码");
        vec2.add("工资");

        vec1.add("宋仁冀");
        vec1.add("20180101         ");
        vec1.add("董事会");
        vec1.add("男");
        vec1.add("15069109266");
        vec1.add("8000.00");

        vec4.add("唐旋风");
        vec4.add("20180201         ");
        vec4.add("销售部");
        vec4.add("男");
        vec4.add("15069109267");
        vec4.add("5000.00");

        vec3.add(vec1);
        vec3.add(vec4);


        JTable jTable1 = new JTable();


//        qi.str= g_SearchFiled.getText();
//        vec1 = qi.queryFromCommodity();
//        jTable1 = Mytable.maketable(vec1, vec2); //显示内容

        DefaultTableModel model = new DefaultTableModel(vec3,vec2);
        jTable1.setModel(model);
        modelScrolPane=new JScrollPane(jTable1);
        modelScrolPane.setPreferredSize(new Dimension(1000,850));            // 设置滚动面板大小



        chooseOne = new JPanel();
        chooseOne.add(modelScrolPane);
/*        chooseTwo = new JPanel();
        chooseTwo.add(modelScrolPane1);*/

        choose=new JTabbedPane();
        choose.add("员工信息",chooseOne);
//        choose.add(chooseTwo);

        cardPanel.add(choose);

        return cardPanel;


    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==addButton){

            new AddemployeeWindow();
        }
        if(e.getSource()==deleteButton){
            new DeleteemployeeWindow();
        }
    }


    public static void main(String[] args){
        new EmployeeManageWindow();
    }
}
