package com.scs.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MyTableModel extends JFrame {
    private DefaultTableModel model;
    private JTable tableModel;
    private JScrollPane jsp;

    public MyTableModel(){
        model = new DefaultTableModel();
        tableModel = new JTable(model);
        jsp = new JScrollPane(tableModel);

        add(jsp);
    }

}
