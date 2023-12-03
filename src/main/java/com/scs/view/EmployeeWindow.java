/*
package gui;


import javax.swing.*;
import java.awt.*;

public class EmployeeWindow extends AdminWindow{
    private JButton emplpyeeManagerButton;
    public EmployeeWindow(){
        super();
    }
    public static void main(String[] args){
        new EmployeeWindow();
    }

}*/
package com.scs.view;

import com.scs.utils.ClockThread;
import com.scs.dao.queryInfo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.Vector;

public class EmployeeWindow extends JFrame implements ActionListener{
    protected CardLayout cardLayout;
    protected JPanel mainPanel,cardPanel,buttonPanel,infoPanel,goodsManagerPanel,employeeManagerPanel,dataStatisticsPanel;
    protected JTable goodsTable,goodsTableModel;              // 商品表  用户表
    protected DefaultTableModel goodsModel;   // 商品表模型  用户表模型
    protected JScrollPane goodsScrolPane,employeeScrolPane,jsp;
    protected JButton dataStatisticsButton;

    // goodsManagerPanel 组件
    protected JPanel g_SouthPanel,g_CenterPanel,g_NounthPanel;
    protected JButton g_AddButton,g_DeleteButton,g_UpdateButton,g_SearchButton,g_SearchAllButton,typeManagerButton;
    protected JTextField g_SearchFiled;
    protected DefaultListSelectionModel g_SelectionModel;     // 商品管理面板 表格 选择模型
    protected static int g_DeleteIndex = -1;

    // employeeManagetPaenl 组件
    protected JPanel e_SouthPanel,e_NounthPanel;
    protected JButton e_AddButton,e_DeleteButton,e_UpdateButton,e_SearchButton,e_SearchAllButton;
    protected JTextField e_SearchFiled;
    protected DefaultListSelectionModel e_SelectionModel;    // 员工管理面板  表格 选择模型
    protected static int e_DeleteIndex = -1;

    // dataStatisticsPanel 组件
    protected JPanel dataPanel,dataButtonPanel;
    protected JPanel PieChartPanel,BarChartPanel;
    protected JButton employeeButton,goodsButton;
    public int i;
    protected Vector rowData, columnNames,data;
//    protected  int row = goodsTable.getRowCount() - 1;

    // 自定义 变量
    protected JLabel timeLabel;
    protected Map map = null;
    protected ClockThread clockThread = null;

    public EmployeeWindow(){
//        this.map = map;
        init();
//        setSize(1000,600);
        setBounds(-5,0,1950,1050);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public void  init(){
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(50,50,58));

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        cardPanel.add(getGoodsManagerPanel(),"goodsManagerPanel");
/*        cardPanel.add(getEmployeeManagerPanel(),"employeeManagerPanel");
        cardPanel.add(getDataStatisticsPanel(),"dataStatisticsPanel");*/

        mainPanel.add(getButtonPanel(),BorderLayout.NORTH);
        mainPanel.add(getInfoPanel(),BorderLayout.SOUTH);
        mainPanel.add(cardPanel,BorderLayout.CENTER);
        add(mainPanel);
    }

    public JPanel getButtonPanel(){
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,15,0));
        buttonPanel.setBackground(new Color(242,242,242));

        dataStatisticsButton = new JButton("销售历史");

//        goodsManagerButton.addActionListener(this);
//        emplpyeeManagerButton.addActionListener(this);
        dataStatisticsButton.addActionListener(this);

//        buttonPanel.add(goodsManagerButton);
//        buttonPanel.add(emplpyeeManagerButton);
        buttonPanel.add(dataStatisticsButton);

        return buttonPanel;
    }

    /**
     * 信息 面板
     * @return
     */
    public JPanel getInfoPanel(){
        infoPanel = new JPanel(new BorderLayout());
        infoPanel.setBackground(new Color(242,242,242));

//        Admin admin = (Admin) map.get("admin");                      // 获取登录时  传递的参数

        JPanel infoOne = new JPanel();
        infoOne.setBackground(new Color(242,242,242));
        JLabel jLabel = new JLabel();
        jLabel.setText("欢迎登录!\t      ");
//        jLabel.setForeground(new Color(200,200,200));
        infoOne.add(jLabel);

        JPanel infoTwo = new JPanel();
        infoTwo.setBackground(new Color(242,242,242));
        timeLabel = new JLabel();
//        timeLabel.setForeground(new Color(200,200,200));
        infoTwo.add(timeLabel);

        clockThread = new ClockThread();
        clockThread.setjLabel(timeLabel);
        clockThread.start();

        infoPanel.add(infoOne,BorderLayout.WEST);
        infoPanel.add(infoTwo,BorderLayout.EAST);
        return infoPanel;
    }

    /**
     *  商品库存管理 面板
     * @return JPanel
     */
    public JPanel getGoodsManagerPanel(){
        goodsManagerPanel = new JPanel();
        goodsManagerPanel.setBackground(new Color(242,242,242));
//        goodss = goodsService.getAll();                                // 获取 数据库 所有商品

//        goodsTable = new JTable();

//定义列名
        /*
        String[]names={"商品名称","商品价格","条码","生产日期","保质期","数量"};//定义列名，连接数据库后获取数据库信息。
        String[][]content=new String[i][6];*/
        columnNames = new Vector();
        rowData = new Vector();
        data = new Vector();
        columnNames.add("姓名");
        columnNames.add("工号");
        columnNames.add("条码");
        columnNames.add("生产日期");
        columnNames.add("保质期");
        columnNames.add("数量");

        rowData.add(data);



        goodsTable = new JTable(rowData,columnNames);

//        goodsTable = new JTable();




        DefaultTableModel model = new DefaultTableModel(rowData,columnNames);
        goodsTable.setModel(model);

        goodsScrolPane = new JScrollPane(goodsTable);
        goodsScrolPane.setPreferredSize(new Dimension(1920,850));            // 设置滚动面板大小

        g_NounthPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));     // 查询 商品面板
        g_NounthPanel.setBackground(new Color(242,242,242));
        g_SearchFiled = new JTextField(60);
        g_SearchFiled.setPreferredSize(new Dimension(60,50));
        g_SearchFiled.setText("请输入需要查询商品条码");                                    // 此处未注册 鼠标监听
        g_SearchButton = new JButton("添加");
        g_SearchButton.setPreferredSize(new Dimension(80,50));
        g_SearchButton.addActionListener(this);
        g_NounthPanel.add(g_SearchFiled);
        g_NounthPanel.add(g_SearchButton);

        goodsManagerPanel.add(g_NounthPanel,BorderLayout.NORTH);
        goodsManagerPanel.add(goodsScrolPane,BorderLayout.CENTER);
        return goodsManagerPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        queryInfo qinfo = new queryInfo();
//        commodity comm = new commodity();

        if(e.getSource()==g_SearchButton){
            qinfo.str= g_SearchFiled.getText();
            qinfo.queryFromCommodity();

            System.out.println(data);
//            goodsTable.addRow(data);
        }

    }

    public static void main(String[] args){
        EmployeeWindow w= new EmployeeWindow();
    }



}