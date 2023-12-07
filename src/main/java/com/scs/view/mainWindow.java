package com.scs.view;

import com.scs.dao.queryInfo;
import com.scs.entity.Commodity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Vector;

import static javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS;

public class mainWindow extends JFrame implements ActionListener{

    JButton ChangeEmployee,addVIP,Bill,stockCheck,returnGoods,stockGoods,fastCheckout,systemSetting,messages,allMenu,AnalysisData,AddCom,DeleteCom,Update,Classify, Close;
    JPanel north,center,south,easternNorth,westernNorth,easternSouth,westernSouth,easternNorthNorth,easternNorthCenter;
    JLabel logo,Username,TimeShow;
    Vector rowData, columnNames;
    JTable jt=null;
    JScrollPane jsp=null;

    public static void main(String[] args) {
        mainWindow main_w = new mainWindow();
    }
    public mainWindow() {

        // button
        ChangeEmployee = new JButton("交接班");
        addVIP=new JButton("新增会员");
        Bill=new JButton("销售单据");
        stockCheck=new JButton("查库存");
        returnGoods=new JButton("退货");
        stockGoods=new JButton("进货");
        fastCheckout=new JButton("快速收银");
        systemSetting=new JButton("系统设置");
        messages=new JButton("消息中心");
        allMenu=new JButton("全部菜单");

        AnalysisData = new JButton("数据分析");
        AddCom = new JButton("添加商品");
        AddCom.addActionListener(this);
        DeleteCom = new JButton("删除商品");
        Update = new JButton("更新");
        Classify = new JButton("分类");

        Close = new JButton("X");

        logo = new JLabel();

        north= new JPanel(new BorderLayout());
        center = new JPanel();
        south = new JPanel();

        easternNorth = new JPanel(new BorderLayout());
        westernNorth = new JPanel();

        easternNorthNorth=new JPanel();
        easternNorthCenter=new JPanel();

        Username=new JLabel("用户名：");
        TimeShow=new JLabel("2020:10:10");

        easternNorthNorth.add(Username);
        easternNorthNorth.add(TimeShow);
        easternNorth.add(easternNorthNorth,BorderLayout.NORTH);

        easternNorthCenter.add(ChangeEmployee);
        easternNorthCenter.add(addVIP);
        easternNorthCenter.add(Bill);
        easternNorthCenter.add(stockCheck);
        easternNorthCenter.add(returnGoods);
        easternNorthCenter.add(stockGoods);
        easternNorthCenter.add(fastCheckout);
        easternNorthCenter.add(systemSetting);
        easternNorthCenter.add(messages);
        easternNorthCenter.add(allMenu);

        easternNorth.add(easternNorthCenter,BorderLayout.CENTER);
        // 加载logo
        URL logoUrl = mainWindow.class.getClassLoader().getResource("images/RPC.jpeg");
        if (logoUrl !=null){
            ImageIcon icon = new ImageIcon(logoUrl);
            icon = resizeImage(icon, 300,200);
            logo.setIcon(icon);
        }
        westernNorth.add(logo);

/*
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

*/

        //初始化jsp JScrollPane
        jsp=new JScrollPane(jt);

        north.add(easternNorth,BorderLayout.CENTER);
        north.add(westernNorth,BorderLayout.WEST);

        center.add(jsp);

        south.add(AddCom);
        south.add(DeleteCom);
        south.add(Classify);
        south.add(Update);

        //把jsp放入到 jFrame

        this.add(north,"North");
        this.add(center);
        this.add(south,"South");

//        this.setBounds(250,100,1500,800);
        GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        if (device.isFullScreenSupported()) {
            this.dispose();
            this.setUndecorated(true);
            device.setFullScreenWindow(this);
            this.setVisible(true);
        }
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==AddCom){
            new AddComWindow();
        }
    }
    private static ImageIcon resizeImage(ImageIcon originalIcon, int width, int height) {
        Image image = originalIcon.getImage();
        Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }
    }

