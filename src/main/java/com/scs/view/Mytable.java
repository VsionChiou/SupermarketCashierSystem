package com.scs.view;


import javax.swing.*;
import java.util.Vector;

public class Mytable {
    public static JTable maketable(Vector obj, Vector title) {
        JTable table = new JTable();
        table = new JTable(obj, title);
        return table;
    }
}
