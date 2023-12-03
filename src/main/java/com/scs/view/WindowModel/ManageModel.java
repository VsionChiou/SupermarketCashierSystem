
package com.scs.view.WindowModel;

import com.scs.utils.ClockThread;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;


public class ManageModel extends JFrame {
    protected CardLayout cardLayout;
    protected JPanel mainPanel,infoPanel,cardPanel,storeManagePanel,chooseOne,chooseTwo;
    protected JTable chooseTable,goodsTable,modelTable,modelTable1;
    protected JTabbedPane choose;
    protected JScrollPane storeScrolPane,modelScrolPane,modelScrolPane1;
    protected DefaultTableModel modelmodel1;
    protected JButton addButton,deleteButton;

    protected ClockThread clockThread = null;

    public ManageModel(){
        init();
        setSize(1000,600);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

    }
    public void init(){
        mainPanel = new JPanel(new BorderLayout());


        cardLayout = new CardLayout();


        mainPanel.add(getInfoPanel(),BorderLayout.NORTH);
        mainPanel.add(getCardPanel(),BorderLayout.CENTER);
        add(mainPanel);




    }
    public JPanel getInfoPanel(){
        infoPanel = new JPanel(new BorderLayout());

        addButton = new JButton("添加");
        addButton.setPreferredSize(new Dimension(80,60));
        deleteButton = new JButton("删除");
        deleteButton.setPreferredSize(new Dimension(80,60));

        JPanel infoOne = new JPanel();
        JLabel jLabel = new JLabel("商品管理系统");

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

        modelTable = new JTable();
        modelTable1 = new JTable();
        String[]conlumn={"星期一","星期二","星期三","星期四","星期五","星期六","星期七"};//定义列名，连接数据库后获取数据库信息。
        String[][]content=new String[100][7];

        String[]conlumn1={"星期一","星期二","星期三","星期四","星期五","星期六","星期七"};//定义列名，连接数据库后获取数据库信息。
        String[][]content1=new String[100][7];

        DefaultTableModel model = new DefaultTableModel(content,conlumn);
        DefaultTableModel model1 = new DefaultTableModel(content1,conlumn1);

        modelTable.setModel(model);
        modelTable1.setModel(model1);
        modelScrolPane = new JScrollPane(modelTable);
        modelScrolPane1 = new JScrollPane(modelTable1);

        modelScrolPane.setPreferredSize(new Dimension(1000,850));            // 设置滚动面板大小
        modelScrolPane1.setPreferredSize(new Dimension(1000,850));            // 设置滚动面板大小



        chooseOne = new JPanel();
        chooseOne.add(modelScrolPane);
        chooseTwo = new JPanel();
        chooseTwo.add(modelScrolPane1);

        choose=new JTabbedPane();
        choose.add(chooseOne);
        choose.add(chooseTwo);

        cardPanel.add(choose);

        return cardPanel;


    }

    public JPanel getStoreManagePanel(){

        storeManagePanel =new JPanel();

        storeScrolPane = new JScrollPane(getstoreTable());

        return storeManagePanel;


    }
    public JTable getstoreTable(){
        String[] header = {"序号","商品类别ID","商品条码","商品名称","商品单价","商品数量"};
        goodsTable = new JTable();

        return goodsTable;
    }
    public static void main(String [] args){
        ManageModel a=new ManageModel();
    }

}
