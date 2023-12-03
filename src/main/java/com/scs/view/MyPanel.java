package com.scs.view;

import javax.swing.*;
import java.awt.*;


public class MyPanel extends JPanel{
    ImageIcon icon;
    Image myImg;

    public MyPanel(){
    }

    public MyPanel(String pictureName){
        icon = new ImageIcon(getClass().getResource("/img/"+pictureName));  //获取图标
        myImg = icon.getImage();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(myImg, 0,0,this.getWidth(),this.getHeight(),this);  //自适应面板大小

    }

}
